package com.gildocordeiro.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.repository.UsuarioRepository;

@Service
public class UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salvarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
//	public void autenticarUsuario(Usuario usuario, HttpSession session) {
//		java.util.List<Usuario> listaUser= usuarioRepository.findAll();
//		for(Usuario users:listaUser){
//			System.out.println(users.getLogin());
//			
//			
//		}
//		
		
//		
//	}

}
