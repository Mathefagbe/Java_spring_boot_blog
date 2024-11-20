package com.apostle.blogging_platform_api.exceptions;

import com.apostle.blogging_platform_api.utils.ApiResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

//controller advice error are used for custom error
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> handleNotFound(NotFoundException ex){
        ApiResponse apiResponse=new ApiResponse(
                ex.getMessage(),
                null,
                "failed"
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }
}
