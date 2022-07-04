package com.hackathon.lep.login.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.lep.login.dto.LoginDto;
import com.hackathon.lep.login.modelo.Usuario;
import com.hackathon.lep.login.servico.UsuarioServico;

@RestController
public class LoginController {
 
	@Autowired
	private UsuarioServico usuarioServico;

	@RequestMapping(value = "api/login", method = RequestMethod.POST)
	public ResponseEntity<?> logar(@RequestBody LoginDto login) {
 
		try {

			Usuario retorno = usuarioServico.obter(login.getEmail(), login.getSenha());

			if(retorno == null) {
				return ResponseEntity.badRequest().body("Falha no login");
			}else {
				return ResponseEntity.ok(retorno);
			}

			

		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Falha no login.");
		}

	}
 
}
