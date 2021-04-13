package br.com.adams.livros.converter.basic;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E, D> implements Converter<E, D> {

  @Override
  public List<D> toDtoList(List<E> entityList) {
    return entityList.stream().map(this::toDto).collect(Collectors.toList());
  }

  @Override
  public List<E> toEntityList(List<D> dtoList) {
    return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
  }
}
