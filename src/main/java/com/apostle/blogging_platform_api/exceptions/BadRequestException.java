package com.apostle.blogging_platform_api.exceptions;

public class BadRequestException  extends  RuntimeException{
        private  String message;
        public BadRequestException(String message){
            super(message);
        }
}
