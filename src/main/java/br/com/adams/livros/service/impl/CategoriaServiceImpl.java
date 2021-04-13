package br.com.adams.livros.service.impl;

import br.com.adams.livros.domain.Categoria;
import br.com.adams.livros.exceptions.CustonException;
import br.com.adams.livros.repository.CategoriaRepository;
import br.com.adams.livros.repository.LivroRepository;
import br.com.adams.livros.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

  private final CategoriaRepository categoriaRepository;
  private final LivroRepository livroRepository;

  @Override
  public List<Categoria> listar() {
    return categoriaRepository.findAll();
  }

  @Override
  public Categoria buscarPorId(final Long id) {
    return categoriaRepository
        .findById(id)
        .orElseThrow(
            () ->
                new CustonException(
                    String.format("Não foi encontrada uma categoria para o id: %d !!", id)));
  }

  @Override
  public Categoria criar(final Categoria categoria) {
    return categoriaRepository.save(categoria);
  }

  @Override
  public Categoria editar(final Long id, final Categoria categoriaEditada) {
    final Categoria categoriaOriginal = buscarPorId(id);

    categoriaOriginal.setNome(categoriaEditada.getNome());

    return categoriaRepository.save(categoriaOriginal);
  }

  @Override
  public void excluir(final Long id) {
    final Categoria categoria = buscarPorId(id);
    final Long livrosComACategoria = livroRepository.countAllByCategoria_Id(id);
    log.info("Existem {} livros com a categoria informada", livrosComACategoria);

    if (livrosComACategoria > 0) {
      throw new CustonException(
          String.format(
              "A categoria %s possui %d livro(s) atrelados",
              categoria.getNome(), livrosComACategoria));
    }

    categoriaRepository.delete(categoria);
  }
}
