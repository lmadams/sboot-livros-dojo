package br.com.adams.livros.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto {

  private Long id;

  @NotEmpty(message = "Informe um nome!!!")
  @Length(min = 3, message = "minimo 3 caracteres!!!")
  private String nome;
}
