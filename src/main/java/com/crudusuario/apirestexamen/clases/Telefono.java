package com.crudusuario.apirestexamen.clases;
 
import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Telefono implements Serializable {
    
    private static final long serialVersionUID = 1L;
  
    @EmbeddedId
    private TelefonoPk telefonoPk;
    private String cityCode;
    private String countryCode;
									
}
