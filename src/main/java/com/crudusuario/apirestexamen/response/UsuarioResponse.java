package com.crudusuario.apirestexamen.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
    
    private String id;
    private Date created;
    private Date modified;
    private Date last_Login; 
    private String token;
    private boolean isActive;

}
