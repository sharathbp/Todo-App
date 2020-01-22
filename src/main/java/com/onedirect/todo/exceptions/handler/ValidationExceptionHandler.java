package com.onedirect.todo.exceptions.handler;

import com.onedirect.todo.exceptions.ValidationException;
import com.onedirect.todo.services.TaskService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {
    static Logger logger = Logger.getLogger(TaskService.class.getName());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllException(final Exception ex, HttpServletRequest request){
        logger.debug(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(final ValidationException ex, HttpServletRequest request){
        logger.debug(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> handleSqlException(final SQLException ex, HttpServletRequest request){
        logger.debug(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }

}
