package com.t1lean.runlife_api.exception;
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}