package com.crudusuario.apirestexamen.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudusuario.apirestexamen.clases.Telefono;
import com.crudusuario.apirestexamen.clases.TelefonoPk; 

@Repository
public interface TelefonoRespository  extends JpaRepository<Telefono, TelefonoPk> {
    
}

