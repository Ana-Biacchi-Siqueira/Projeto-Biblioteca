package br.com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.entities.Biografia;

public interface LivrosRepository extends JpaRepository<Livro, String> {

	Livro findByLivro(String livroTitulo);

}
