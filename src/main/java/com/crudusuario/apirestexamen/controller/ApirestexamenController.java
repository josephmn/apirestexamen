package com.crudusuario.apirestexamen.controller;
 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crudusuario.apirestexamen.dto.UsuarioDto;
import com.crudusuario.apirestexamen.response.RespuestaResponse;
import com.crudusuario.apirestexamen.response.UsuarioResponse;
import com.crudusuario.apirestexamen.service.IUsuarioService;
 
@RestController
@RequestMapping("/api/v1/usuario")
@Validated 
public class ApirestexamenController {
    
    @Autowired
    private IUsuarioService usuario; 

    @PostMapping(value="/registro",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> requestBalance(@Valid @RequestBody UsuarioDto usuarioDto) {
        try {
            UsuarioResponse usuarioResponse = usuario.registro(usuarioDto);
            return ResponseEntity.ok().body(usuarioResponse);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new RespuestaResponse(e.getMessage()));
        }      
    }

}
