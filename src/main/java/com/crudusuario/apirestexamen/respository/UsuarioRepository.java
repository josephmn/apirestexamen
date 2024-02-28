package com.crudusuario.apirestexamen.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudusuario.apirestexamen.clases.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    
    Usuario findByEmail(String mail);
    
}
