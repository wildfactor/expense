package com.poc.expense.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Exception controller.
 */
@ControllerAdvice
public class ExceptionController extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    /**
     * Handle exception response entity.
     *
     * @param request the request
     * @param e       the e
     * @return the response entity
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorMessage> handleException(HttpServletRequest request, Exception e){
        logger.error(String.valueOf(e));
        ErrorMessage exceptionResponse = new ErrorMessage(e.getMessage(), "Please review your request");

        return new ResponseEntity<ErrorMessage>(exceptionResponse,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
