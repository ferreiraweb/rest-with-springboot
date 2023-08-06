package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.erudio.models.Livro;


public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
