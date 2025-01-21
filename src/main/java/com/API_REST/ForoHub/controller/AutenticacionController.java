package com.API_REST.ForoHub.controller;

import com.API_REST.ForoHub.infra.security.DatosJWTTokenDTO;
import com.API_REST.ForoHub.infra.security.TokenService;
import com.API_REST.ForoHub.modelo.usuario.DatosAutenticacionUsuarioDTO;
import com.API_REST.ForoHub.modelo.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuarioDTO datosUsuario){
        Authentication AuthToken = new UsernamePasswordAuthenticationToken(datosUsuario.login(), datosUsuario.clave());
        var ususarioAutenticado = authenticationManager.authenticate(AuthToken);
        var JWTtoken = tokenService.generarToken((Usuario) ususarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTTokenDTO(JWTtoken));
    }

}
