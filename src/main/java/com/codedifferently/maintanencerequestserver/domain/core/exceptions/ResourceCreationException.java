package com.codedifferently.maintanencerequestserver.domain.core.exceptions;

public class ResourceCreationException extends RuntimeException{
    public ResourceCreationException(String message){
        super(message);
    }
}
