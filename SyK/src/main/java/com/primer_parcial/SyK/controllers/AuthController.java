package com.primer_parcial.SyK.controllers;

import com.primer_parcial.SyK.models.Usuario;
import com.primer_parcial.SyK.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping(value = "auth/login")
    public ResponseEntity login(@RequestBody Usuario usuario){

        return usuarioService.login(usuario.getCorreo(), usuario.getPassword());

    }


}
