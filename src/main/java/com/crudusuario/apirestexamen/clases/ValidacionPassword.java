package com.crudusuario.apirestexamen.clases;

import com.crudusuario.apirestexamen.anotaciones.ValidatorPassword;
import com.crudusuario.apirestexamen.respository.ExpresionesRegularesRepository;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;    

public class ValidacionPassword implements ConstraintValidator<ValidatorPassword, String> {

	@Autowired
	private ExpresionesRegularesRepository expresionesRegularesRepository;
	
    @Override
    public boolean isValid(String dato, ConstraintValidatorContext context) {
        boolean vRespuesta = true;
        String vExpReg = "";

        if (dato != null && !dato.equals("")) {
        	
            Optional<ExpresionesRegulares> expresionRegular = expresionesRegularesRepository.findById(1);
            vExpReg = expresionRegular.get().getExpresionRegular();
            Pattern pattern = Pattern.compile(vExpReg); 
            Matcher matcher = pattern.matcher(dato);

            vRespuesta = matcher.matches();

        }
        
    	return vRespuesta;
    }

}




