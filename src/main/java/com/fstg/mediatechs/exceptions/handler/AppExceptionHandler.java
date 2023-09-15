package com.fstg.mediatechs.exceptions.handler;

import com.fstg.mediatechs.exceptions.EntityAlreadyExistException;
import com.fstg.mediatechs.exceptions.EntityNotFoundException;
import com.fstg.mediatechs.shared.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex) {
        ErrorMessage errorMessage=ErrorMessage.builder()
                .message(ex.getMessage())
                .code(404)
                .date(new Date())
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> HandelMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String , String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
        return  new ResponseEntity<>(errors,new HttpHeaders(),HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(value = {EntityAlreadyExistException.class})
    public ResponseEntity<Object> entityAlreadyExistException(EntityAlreadyExistException ex){
        ErrorMessage errorMessage=ErrorMessage.builder().message(ex.getMessage()).date(new Date()).code(409).build();
        return new ResponseEntity<>(errorMessage,HttpStatus.CONFLICT);
    }
}
