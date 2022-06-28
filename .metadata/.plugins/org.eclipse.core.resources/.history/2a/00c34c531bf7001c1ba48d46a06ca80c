package br.com.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	List<Autor> findByAutorBiografia(String autorBiografia);

}
