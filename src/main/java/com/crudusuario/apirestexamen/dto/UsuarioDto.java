package com.crudusuario.apirestexamen.dto;

import java.util.List;

import javax.validation.constraints.Email;

import com.crudusuario.apirestexamen.anotaciones.ValidatorEmail;
import com.crudusuario.apirestexamen.anotaciones.ValidatorPassword;

import lombok.Getter;
import lombok.Setter;  

@Getter
@Setter
public class UsuarioDto {
    
    private String name; 
    @ValidatorEmail(message = "El correo ya esta registrado")
    @Email(message = "El correo no tiene el formato correcto")
    private String email;
    @ValidatorPassword(message = "El password no cumple con los requisitos")
    private String password;
    private List<TelefonoDto> phones;
}
