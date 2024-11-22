package com.apostle.blogging_platform_api.exceptions;

import com.apostle.blogging_platform_api.utils.ApiResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalException {

//controller advice error are used for custom error
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> handleNotFound(NotFoundException ex){
        ApiResponse apiResponse=new ApiResponse(
                ex.getMessage(),
                null,
                "FAILED"
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleValidationError(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errorMessages=bindingResult.getFieldErrors().stream()
                .map(error->{
                    String field = error.getField();
                    String defaultMessage = error.getDefaultMessage();
                    return field + ": " + defaultMessage;
        }).toList();
        ApiResponse apiResponse=new ApiResponse(
                errorMessages.getFirst(),
                null,
                "FAILED"
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }
}
