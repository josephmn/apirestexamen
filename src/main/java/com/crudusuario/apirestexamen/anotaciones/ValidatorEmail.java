package com.crudusuario.apirestexamen.anotaciones;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.crudusuario.apirestexamen.clases.ValidacionEmail; 


@Documented
@Constraint(validatedBy = ValidacionEmail.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidatorEmail {
    
	String message() default "";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
