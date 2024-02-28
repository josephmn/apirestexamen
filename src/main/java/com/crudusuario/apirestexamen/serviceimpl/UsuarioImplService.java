package com.crudusuario.apirestexamen.serviceimpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.crypto.SecretKey;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import com.crudusuario.apirestexamen.clases.Telefono;
import com.crudusuario.apirestexamen.clases.TelefonoPk;
import com.crudusuario.apirestexamen.clases.Usuario;
import com.crudusuario.apirestexamen.dto.TelefonoDto;
import com.crudusuario.apirestexamen.dto.UsuarioDto;
import com.crudusuario.apirestexamen.response.UsuarioResponse; 
import com.crudusuario.apirestexamen.respository.TelefonoRespository;
import com.crudusuario.apirestexamen.respository.UsuarioRepository;
import com.crudusuario.apirestexamen.service.IUsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys; 

@Service
public class UsuarioImplService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TelefonoRespository telefonoRespository;

    @Transactional
    @Override
    public UsuarioResponse registro(UsuarioDto usuarioDto) { 
    
        List<TelefonoDto> lstTelefonoDto = usuarioDto.getPhones();

        long tiempoExpiracionMillis = 60000;
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        Usuario usuario = new Usuario();
        usuario.setCreated(new Date());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setId(UUID.randomUUID().toString());
        usuario.setIsActive(0);
        usuario.setLast_login(new Date());
        usuario.setModified(new Date());
        usuario.setName(usuarioDto.getName());
        usuario.setPassword(usuarioDto.getPassword());

        String jwtToken = Jwts.builder()
            .setSubject(usuario.getName())
                //.claim("email", usuario.getEmail())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + tiempoExpiracionMillis))  
            .signWith(secretKey)
            .compact();

        usuario.setToken(jwtToken);
        usuarioRepository.save(usuario);

        for (TelefonoDto telefono : lstTelefonoDto) {
            Telefono iTemTelefono = new Telefono();
            iTemTelefono.setTelefonoPk(new TelefonoPk());
            iTemTelefono.getTelefonoPk().setIdUsuario(usuario.getId());
            iTemTelefono.getTelefonoPk().setNumber(telefono.getNumber());
            iTemTelefono.setCityCode(telefono.getCitycode());
            iTemTelefono.setCountryCode(telefono.getContrycode());
            telefonoRespository.save(iTemTelefono);
        }
 
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setActive(usuario.getIsActive()==1);
        usuarioResponse.setCreated(usuario.getCreated());
        usuarioResponse.setId(usuario.getId());
        usuarioResponse.setLast_Login(usuario.getLast_login());
        usuarioResponse.setModified(usuario.getModified());
        usuarioResponse.setToken(usuario.getToken());

        return usuarioResponse;
    }
    
}
