package consumingApis.consumingApis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({InvalidCoinOrCurrency.class})
    public ResponseEntity<Object> invalidCoinOrCurrency (InvalidCoinOrCurrency ex, WebRequest request) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now(), request.getDescription(false));
        return new ResponseEntity(apiErrorResponse, apiErrorResponse.getStatus());
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity<Object> missingServletRequestParameterException (MissingServletRequestParameterException ex, WebRequest request) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now(), request.getDescription(false));
        return new ResponseEntity(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
