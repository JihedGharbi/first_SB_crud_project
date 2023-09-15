package com.fstg.mediatechs.exceptions;

public class EntityAlreadyExistException extends RuntimeException{
    public EntityAlreadyExistException() {
    }

    public EntityAlreadyExistException(String message) {
        super(message);
    }
}
