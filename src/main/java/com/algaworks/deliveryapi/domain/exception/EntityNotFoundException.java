package com.algaworks.deliveryapi.domain.exception;

import java.io.Serial;

public class EntityNotFoundException extends CustomException{

    @Serial
    private static final long serialVersionUID = -7388768357995782700L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
