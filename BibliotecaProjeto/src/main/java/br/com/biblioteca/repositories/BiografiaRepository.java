package br.com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.entities.Biografia;

public interface BiografiaRepository extends JpaRepository<Biografia, String> {

	Biografia findByAutorBiografia(String autorBiografia);

}
