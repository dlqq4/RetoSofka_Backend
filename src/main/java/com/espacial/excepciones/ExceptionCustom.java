package com.espacial.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionCustom extends RuntimeException{

    private static final long serialVersionUID =1L;

    public ExceptionCustom(String mensaje){
        super(mensaje);

    }

}