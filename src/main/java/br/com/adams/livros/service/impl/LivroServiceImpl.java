package br.com.adams.livros.service.impl;

import br.com.adams.livros.domain.Livro;
import br.com.adams.livros.exceptions.CustonException;
import br.com.adams.livros.repository.LivroRepository;
import br.com.adams.livros.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

  private final LivroRepository repository;

  @Override
  public List<Livro> listar() {
    return repository.findAll();
  }

  @Override
  public Livro buscarPorId(Long id) {
    return repository
        .findById(id)
        .orElseThrow(
            () -> new CustonException(String.format("Livro não encontrada para o id: %d", id)));
  }

  @Override
  public Livro criar(Livro livro) {
    return repository.save(livro);
  }

  @Override
  public Livro editar(final Long id, final Livro livroEditado) {
    final Livro livroOriginal = buscarPorId(id);

    livroOriginal.setCategoria(livroEditado.getCategoria());
    livroOriginal.setCodigo(livroEditado.getCodigo());
    livroOriginal.setNome(livroEditado.getNome());
    livroOriginal.setPaginas(livroEditado.getPaginas());

    return repository.save(livroOriginal);
  }

  @Override
  public void excluir(Long id) {
    final Livro livro = buscarPorId(id);
    repository.delete(livro);
  }
}
