package com.crudusuario.apirestexamen.clases;
 
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpresionesRegulares implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private int id;

    @Column()
    private String nombre;

    @Column()
    private String expresionRegular;
}
