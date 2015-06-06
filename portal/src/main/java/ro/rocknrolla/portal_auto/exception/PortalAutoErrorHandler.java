package ro.rocknrolla.portal_auto.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ro.rocknrolla.portal_auto.bean.ValidationFailureResponse;

@ControllerAdvice
public class PortalAutoErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseBody
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationFailureResponse processValidationFailure(MethodArgumentNotValidException ex) {
        return new ValidationFailureResponse.Builder().messageSource(messageSource)
                .fieldErrors(ex.getBindingResult().getFieldErrors())
                .errors(ex.getBindingResult().getGlobalErrors()).build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(UniqueViolationException.class)
    public ValidationFailureResponse processValidationFailure(UniqueViolationException ex) {
        return new ValidationFailureResponse.Builder().messageSource(messageSource)
                .fieldError(ex.getField(), ex.getMessage()).build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(ServerEntityNotFoundException.class)
    public ValidationFailureResponse processValidationFailure(ServerEntityNotFoundException ex) {
        return new ValidationFailureResponse.Builder().messageSource(messageSource)
                .fieldError(ex.getField(), ex.getMessage()).build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAnyException(Exception ex) {
        return ResponseEntity.badRequest().build();
    }
}
