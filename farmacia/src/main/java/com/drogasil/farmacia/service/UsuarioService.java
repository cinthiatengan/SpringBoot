package com.drogasil.farmacia.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import com.drogasil.farmacia.model.UserLogin;
import com.drogasil.farmacia.model.Usuario;
import com.drogasil.farmacia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	//regra de negocio para cadastrar usuario (é uma classe não interface)
	
		@Autowired
		private UsuarioRepository repository;
		
		//metodo que recebe um usuario e retorna o usuario (cadastrar usuario)
		public Usuario CadastrarUsuario(Usuario usuario) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String senhaEncoder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEncoder); //chama o usuario e modifica o atributo senha, passando a senha encriptada
			
			return repository.save(usuario); //salva o objeto usuario com a senha modificada.
		}
		//metodo logar
		
		public Optional<UserLogin> Logar(Optional<UserLogin> user){
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());
			
			if(usuario.isPresent()) { // condição se o usuario tiver algo dentro, o metodo compara a senha encriptada com a senha digitada do usuario
				if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) { //vai verificar se a senhas foram digitadas iguais
				
				String auth = user.get().getUsuario() + ":" + user.get().getSenha(); 
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
	 			String authHeader = "Basic " + new String(encodeAuth); //autenticacao header, prefixo basic concatenando com + new string (converte o array de byte pra string)
	 			
	 			user.get().setToken(authHeader); //preenche o token
	 			user.get().setNome(usuario.get().getNome()); //acesso ao token e coloca o que veio no username
	 			
	 			return user; //retorna o usuario
				
					}
				}
			 return null; // se nao entra desse if ele retorna um nulo. o usuario nao existe no banco de dados.
			}

}
