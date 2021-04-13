package br.com.adams.livros.handler;

import br.com.adams.livros.exceptions.CustonException;
import br.com.adams.livros.reponse.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(final Exception e) {
    log.error("Tratativa de erros nao esperados!", e);

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ErrorResponse.builder().message(e.getMessage()).build());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleException(final MethodArgumentNotValidException e) {
    log.error("Tratativa de erros de Bean Validation!", e);

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ErrorResponse.builder().message("Payload recebido é invalido!").build());
  }

  @ExceptionHandler(CustonException.class)
  public ResponseEntity<ErrorResponse> handleException(final CustonException e) {
    log.error("Tratativa de erro customizado!", e);

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(ErrorResponse.builder().message(e.getMessage()).build());
  }
}
