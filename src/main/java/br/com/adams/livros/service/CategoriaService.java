package br.com.adams.livros.service;

import br.com.adams.livros.domain.Categoria;

import java.util.List;

public interface CategoriaService {

  List<Categoria> listar();

  Categoria buscarPorId(Long id);

  Categoria criar(Categoria categoria);

  Categoria editar(Long id, Categoria categoria);

  void excluir(Long id);
}
