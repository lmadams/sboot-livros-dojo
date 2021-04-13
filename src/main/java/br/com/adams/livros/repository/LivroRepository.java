package br.com.adams.livros.repository;

import br.com.adams.livros.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

  Long countAllByCategoria_Id(Long id);
}
