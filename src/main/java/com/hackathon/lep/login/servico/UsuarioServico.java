package com.hackathon.lep.login.servico;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.lep.login.modelo.Usuario;
import com.hackathon.lep.login.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	public Usuario obter(UUID chave) {

		Optional<Usuario> usuario = usuarioRepositorio.getByChave(chave);

		if (usuario.isPresent()) {
			if (usuario.get().getAtivo()) {
				return usuario.get();
			}
		}
		return null;
	}
	
	public Usuario obter(String email, String senha) {

		Optional<Usuario> usuario = usuarioRepositorio.findByEmailAndSenha(email, senha);
		System.out.println("email: " + email);
		System.out.println("senha: " + senha);
	
		if (usuario.isPresent()) {
			if (usuario.get().getAtivo()) {
				System.out.println("senha: " + usuario.get().toString());
				return usuario.get();
			}
		}
		return null;
	}
	
	
	public Boolean criarUsuario(String email, String senha) {

		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);

		Usuario usuarioSalvo = usuarioRepositorio.save(usuario);

		if (usuarioSalvo != null && usuarioSalvo.getId() > 0) {
			return true;
		} else {
			return false;
		}

	}

}
