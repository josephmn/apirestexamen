package com.crudusuario.apirestexamen.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudusuario.apirestexamen.clases.ExpresionesRegulares;

@Repository
public interface ExpresionesRegularesRepository extends JpaRepository<ExpresionesRegulares, Integer> {
    
}
