package com.crudusuario.apirestexamen.service;

import com.crudusuario.apirestexamen.dto.UsuarioDto;
import com.crudusuario.apirestexamen.response.UsuarioResponse;

public interface IUsuarioService {
    UsuarioResponse registro(UsuarioDto usuarioDto);
}
