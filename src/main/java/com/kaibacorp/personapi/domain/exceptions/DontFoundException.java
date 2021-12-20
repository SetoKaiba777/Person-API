package com.kaibacorp.personapi.domain.exceptions;

public class DontFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DontFoundException(String msg){
        super(msg);
    }
}
