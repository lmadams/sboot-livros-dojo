package br.com.adams.livros.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LivroDto {

  private Long id;

  private Long codigo;

  private Long paginas;

  @NotEmpty(message = "O 'Nome' não pode ser vazio")
  private String nome;

  @NotNull(message = "A 'Categoria' não pode ser nula")
  private CategoriaDto categoria;
}
