package br.com.adams.livros.controller;

import br.com.adams.livros.converter.LivroConverter;
import br.com.adams.livros.domain.Livro;
import br.com.adams.livros.dto.LivroDto;
import br.com.adams.livros.service.LivroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "livro")
public class LivroController {

  private final LivroService service;
  private final LivroConverter converter;

  @GetMapping
  public List<LivroDto> listar() {
    log.info("Endpoint para listar todos os livros");
    final List<Livro> livroList = service.listar();
    return this.converter.toDtoList(livroList);
  }

  @GetMapping(value = "{id}")
  public LivroDto buscarPorId(@PathVariable final Long id) {
    log.info("Endpoint para bucar um livro com o ID: {}", id);
    final Livro livro = service.buscarPorId(id);
    return converter.toDto(livro);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public LivroDto salvar(@Valid @RequestBody final LivroDto livroDto) {
    log.info("Endpoint para salvar um livro: {}", livroDto.toString());
    final Livro livro = converter.toEntity(livroDto);
    return converter.toDto(service.criar(livro));
  }

  @PutMapping(value = "{id}")
  public LivroDto editar(@PathVariable final Long id, @Valid @RequestBody final LivroDto livroDto) {
    log.info("Endpoint para editar um livro com ID:{} e payload: {}", id, livroDto.toString());
    final Livro livro = converter.toEntity(livroDto);
    return converter.toDto(service.editar(id, livro));
  }

  @DeleteMapping(value = "{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void excluir(@PathVariable final Long id) {
    log.info("Endpoint para excluir um livro com ID:{}", id);
    service.excluir(id);
  }
}
