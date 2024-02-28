package com.crudusuario.apirestexamen.clases;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    @Id
    @Column()
    private String id;
 
    @Column()
    private String name;
    @Column()
    private String email;
    
    @Column()
    private String password;
    
    @Column()
    private Date created;
    
    @Column()
    private Date modified;
    
    @Column()
    private Date last_login;
    
    @Column()
    private String token;
    
    @Column()
    private int isActive;
 

}
