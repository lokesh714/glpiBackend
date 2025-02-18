package com.marvell.backend.data.advices;

import com.marvell.backend.data.exceptions.ResourceNotFoundException;
import com.marvell.backend.data.exceptions.RuntimeConflictException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFoundException(ResourceNotFoundException e) {
        ApiError apiError = ApiError
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return helper(apiError);
    }

    @ExceptionHandler(RuntimeConflictException.class)
    public ResponseEntity<ApiResponse<?>> handleRuntimeConflictException(RuntimeConflictException e) {
        ApiError apiError = ApiError
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.CONFLICT)
                .build();
        return helper(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInputValidationException(MethodArgumentNotValidException e) {

        List<String> errors = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        ApiError apiError = ApiError
                .builder()
                .message("Invalid Input Fields")
                .subErrors(errors)
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return helper(apiError);
    }



    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<?>> handleAccessDeniedException(AccessDeniedException e) {
        ApiError apiError = ApiError
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.FORBIDDEN)
                .build();
        return helper(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception e){

        ApiError apiError = ApiError
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return helper(apiError);
    }

    private ResponseEntity<ApiResponse<?>> helper(ApiError apiError){
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
    }
}
