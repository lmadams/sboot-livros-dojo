package br.com.adams.livros.converter;

import br.com.adams.livros.converter.basic.AbstractConverter;
import br.com.adams.livros.domain.Categoria;
import br.com.adams.livros.dto.CategoriaDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoriaConverter extends AbstractConverter<Categoria, CategoriaDto> {

  @Override
  public Categoria toEntity(final CategoriaDto categoriaDto) {
    return Optional.ofNullable(categoriaDto)
        .map(dto -> Categoria.builder().id(dto.getId()).nome(dto.getNome()).build())
        .orElse(null);
  }

  @Override
  public CategoriaDto toDto(final Categoria categoria) {
    return Optional.ofNullable(categoria)
        .map(entity -> CategoriaDto.builder().id(entity.getId()).nome(entity.getNome()).build())
        .orElse(null);
  }
}
