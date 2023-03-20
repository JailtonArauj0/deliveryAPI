package com.algaworks.deliveryapi.domain.exception;

import java.io.Serial;

public class CustomException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -2307826079723973686L;

    public CustomException(String message){
        super(message);
    }
}
