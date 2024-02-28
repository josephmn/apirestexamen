package com.crudusuario.apirestexamen;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crudusuario.apirestexamen.clases.Usuario;
import com.crudusuario.apirestexamen.dto.TelefonoDto;
import com.crudusuario.apirestexamen.dto.UsuarioDto;
import com.crudusuario.apirestexamen.respository.TelefonoRespository;
import com.crudusuario.apirestexamen.respository.UsuarioRepository;
import com.crudusuario.apirestexamen.serviceimpl.UsuarioImplService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ApirestexamenApplicationTests {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private TelefonoRespository telefonoRespository;

    @InjectMocks
    private UsuarioImplService usuarioService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    
	@Test
	void registroTest() {  
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(new Usuario());

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setName("John Doe");
        usuarioDto.setEmail("john@example.com");
        usuarioDto.setPassword("password123");
        
        List<TelefonoDto> telefonos = new ArrayList<>();
        TelefonoDto telefonoDto = new TelefonoDto();
        telefonoDto.setNumber("123456789");
        telefonoDto.setCitycode("1");
        telefonoDto.setContrycode("1");
        telefonos.add(telefonoDto);
        usuarioDto.setPhones(telefonos);
         
        usuarioService.registro(usuarioDto);
        
        verify(usuarioRepository, times(1)).save(any(Usuario.class));

	}

}
