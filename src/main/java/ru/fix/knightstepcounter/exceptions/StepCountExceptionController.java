package ru.fix.knightstepcounter.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StepCountExceptionController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status,
                                                                          WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";
        return getResponseEntity(HttpStatus.BAD_REQUEST, ex, error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
                                                                   WebRequest request) {
        String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();
        return getResponseEntity(HttpStatus.BAD_REQUEST, ex, error);
    }

    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    public ResponseEntity<Object> handleStringIndexOutOfBounds(StringIndexOutOfBoundsException ex,
                                                                   WebRequest request) {
        String error = "Wrong format of 'start' or 'end' parameters. Example: start=A4";
        return getResponseEntity(HttpStatus.BAD_REQUEST, ex, error);
    }

    @ExceptionHandler(PositionFormatException.class)
    public ResponseEntity<Object> handleNumberFormat(PositionFormatException ex,
                                                               WebRequest request) {
        String error = "Wrong format of 'start' or 'end' parameters. Example: start=A4";
        return getResponseEntity(HttpStatus.BAD_REQUEST, ex, error);
    }

    private ResponseEntity<Object> getResponseEntity(HttpStatus status, Exception ex, String error) {
        ApiError apiError = new ApiError(status, ex.getLocalizedMessage(), error);
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
