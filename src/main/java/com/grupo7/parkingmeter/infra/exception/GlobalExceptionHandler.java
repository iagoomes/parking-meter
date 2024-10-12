package com.grupo7.parkingmeter.infra.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    // Método para tratar ControllerNotFoundException
    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<Object> handleControllerNotFoundException(ControllerNotFoundException ex, WebRequest request) {
        // Cria uma resposta personalizada
        String errorMessage = ex.getMessage();

        // Retorna um ResponseEntity com o status HTTP 404 e a mensagem de erro
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    // Método para tratar BusinessException (ex.: duplicação de CEP)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {
        // Cria uma resposta personalizada para duplicação de CEP
        String errorMessage = ex.getMessage();
        // Retorna um ResponseEntity com o status HTTP 409 (Conflito) e a mensagem de erro
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    // Método para outras exceções genéricas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        log.error("Erro interno no servidor", ex);
        // Retorna um status 500 para erros inesperados
        return new ResponseEntity<>("Ocorreu um erro interno no servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}