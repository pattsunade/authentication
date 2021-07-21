package com.patriciadelgado.authentication.Validator;

import com.patriciadelgado.authentication.Models.User;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
     // 1
    @Override
    public boolean supports(Class<?> clazz) { //supports(Class<?>): Especifica que una instancia del modelo
                                            //User puede ser validada con este validador personalizado.
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) { //validate(Object, Errors): Crea nuestra validación personalizada.
                                                        //Podemos agregar errores vía.rejectValue(String, String)
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match"); //.rejectValue(String, String): El primer argumento es
                                                                //la variable de nuestro modelo que estamos validando.
                                                                // El segundo argumento es un código que podemos usar para establecer un mensajes de error.
        }         
    }
}
