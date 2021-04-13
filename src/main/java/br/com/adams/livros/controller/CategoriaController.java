package br.com.adams.livros.controller;

import br.com.adams.livros.converter.CategoriaConverter;
import br.com.adams.livros.domain.Categoria;
import br.com.adams.livros.dto.CategoriaDto;
import br.com.adams.livros.service.CategoriaService;
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
@RequestMapping(value = "categoria")
public class CategoriaController {

  private final CategoriaService service;
  private final CategoriaConverter converter;

  @GetMapping
  public List<CategoriaDto> listar() {
    log.info("Endpoint para listar todas as categorias");
    final List<Categoria> categoriaList = service.listar();
    return this.converter.toDtoList(categoriaList);
  }

  @GetMapping(value = "{id}")
  public CategoriaDto buscarPorId(@PathVariable final Long id) {
    log.info("Endpoint para bucar a categoria com o ID: {}", id);
    final Categoria categoria = service.buscarPorId(id);
    return converter.toDto(categoria);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CategoriaDto salvar(@Valid @RequestBody final CategoriaDto categoriaDto) {
    log.info("Endpoint para salvar a categoria: {}", categoriaDto.toString());
    final Categoria categoria = converter.toEntity(categoriaDto);
    return converter.toDto(service.criar(categoria));
  }

  @PutMapping(value = "{id}")
  public CategoriaDto editar(
      @PathVariable final Long id, @Valid @RequestBody final CategoriaDto categoriaDto) {
    log.info(
        "Endpoint para editar a categoria com ID:{} e payload: {}", id, categoriaDto.toString());
    final Categoria categoria = converter.toEntity(categoriaDto);
    return converter.toDto(service.editar(id, categoria));
  }

  @DeleteMapping(value = "{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void excluir(@PathVariable final Long id) {
    log.info("Endpoint para excluir a categoria com ID:{}", id);
    service.excluir(id);
  }
}
