package com.santos0santos0.log.api.exceptionhandler;

import com.santos0santos0.log.domain.exception.DomainException;
import com.santos0santos0.log.domain.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Field> fields = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            fields.add(new Field(name, message));
        }
        
        ExceptionDefault exceptionDefault = new ExceptionDefault();
        exceptionDefault.setStatus(status.value());
        exceptionDefault.setDateTime(OffsetDateTime.now());
        exceptionDefault.setTitle("Invalid fields. Verify fields and try again");
        exceptionDefault.setFields(fields);

        return handleExceptionInternal(ex, exceptionDefault, headers, status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionDefault exceptionDefault = new ExceptionDefault();
        exceptionDefault.setStatus(status.value());
        exceptionDefault.setDateTime(OffsetDateTime.now());
        exceptionDefault.setTitle(ex.getMessage());

        return handleExceptionInternal(ex, exceptionDefault, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> handleDomain(DomainException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionDefault exceptionDefault = new ExceptionDefault();
        exceptionDefault.setStatus(status.value());
        exceptionDefault.setDateTime(OffsetDateTime.now());
        exceptionDefault.setTitle(ex.getMessage());

        return handleExceptionInternal(ex, exceptionDefault, new HttpHeaders(), status, request);
    }
}
