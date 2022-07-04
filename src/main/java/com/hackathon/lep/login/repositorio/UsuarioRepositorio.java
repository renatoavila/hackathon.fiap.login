package com.hackathon.lep.login.repositorio;

import java.util.Optional;

import com.hackathon.lep.login.modelo.Usuario;

public interface UsuarioRepositorio extends JpaCustomizadoRepositorio<Usuario, Integer> {
	
	Optional<Usuario> findByEmailAndSenha(String email, String senha);
 
}