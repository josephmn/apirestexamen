package com.crudusuario.apirestexamen.clases;
  
import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class TelefonoPk implements Serializable {
    
    private static final long serialVersionUID = 1L;
     
    private String idUsuario; 
    private String number;
}
