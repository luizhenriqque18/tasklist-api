package com.supero.tasklist.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.supero.tasklist.exception.TaskNotExist;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TaskNotExist.class)
	public ResponseEntity<?> EntityNotFound(TaskNotExist e) {
		
		EntityException problem = new EntityException(e.getMessage(), LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
	}
}
