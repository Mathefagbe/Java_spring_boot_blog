package com.apostle.blogging_platform_api.exceptions;

public class NotFoundException extends  RuntimeException {
    private  String message;

    public NotFoundException(String message){
        super(message);
    }
}
