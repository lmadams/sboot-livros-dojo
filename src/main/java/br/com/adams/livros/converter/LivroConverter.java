package br.com.adams.livros.converter;

import br.com.adams.livros.converter.basic.AbstractConverter;
import br.com.adams.livros.domain.Livro;
import br.com.adams.livros.dto.LivroDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LivroConverter extends AbstractConverter<Livro, LivroDto> {

  private final CategoriaConverter categoriaConverter;

  @Override
  public Livro toEntity(final LivroDto livroDto) {
    return Optional.ofNullable(livroDto)
        .map(
            dto ->
                Livro.builder()
                    .id(dto.getId())
                    .nome(dto.getNome())
                    .codigo(dto.getCodigo())
                    .paginas(dto.getPaginas())
                    .categoria(categoriaConverter.toEntity(dto.getCategoria()))
                    .build())
        .orElse(null);
  }

  @Override
  public LivroDto toDto(final Livro livro) {
    return Optional.ofNullable(livro)
        .map(
            entity ->
                LivroDto.builder()
                    .id(entity.getId())
                    .nome(entity.getNome())
                    .codigo(entity.getCodigo())
                    .paginas(entity.getPaginas())
                    .categoria(categoriaConverter.toDto(entity.getCategoria()))
                    .build())
        .orElse(null);
  }
}
