package br.com.adams.livros.service;

import br.com.adams.livros.domain.Livro;

import java.util.List;

public interface LivroService {

  List<Livro> listar();

  Livro buscarPorId(Long id);

  Livro criar(Livro livro);

  Livro editar(Long id, Livro livro);

  void excluir(Long id);
}
