package com.crudusuario.apirestexamen.clases;

import com.crudusuario.apirestexamen.anotaciones.ValidatorEmail; 
import com.crudusuario.apirestexamen.respository.UsuarioRepository;
 
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;    

public class ValidacionEmail implements ConstraintValidator<ValidatorEmail, String> {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
    @Override
    public boolean isValid(String dato, ConstraintValidatorContext context) {
        boolean vRespuesta = true;
        String vExpReg = "";

        if (dato != null && !dato.equals("")) {
        	
            Usuario usuario = usuarioRepository.findByEmail(dato);  

            if (usuario != null) {
                vRespuesta = false;
            }

        }
        
    	return vRespuesta;
    }

}




