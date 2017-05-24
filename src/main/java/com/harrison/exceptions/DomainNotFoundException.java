package com.harrison.exceptions;

public class DomainNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7494563853998268255L;
    
    public DomainNotFoundException(String message) {
        super(message);
    }

}
