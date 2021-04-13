package br.com.adams.livros.converter.basic;

import java.util.List;

public interface Converter<E, D> {

  E toEntity(D dto);

  D toDto(E entity);

  List<E> toEntityList(List<D> dtoList);

  List<D> toDtoList(List<E> entityList);
}
