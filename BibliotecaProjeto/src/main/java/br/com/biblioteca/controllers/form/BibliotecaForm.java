package br.com.biblioteca.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.biblioteca.entities.Autor;
import br.com.biblioteca.entities.Biografia;
import br.com.biblioteca.repositories.AutorRepository;
import br.com.biblioteca.repositories.BiografiaRepository;
import br.com.biblioteca.repositories.LivrosRepository;

public class BibliotecaForm {

	@NotNull @NotEmpty
	private Long id;
	
	@NotNull @NotEmpty @Length(max = 100)
	private String nomeAutor;
	
	@NotNull @NotEmpty @Length(max = 1000)
	private String autorBiografia;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nomeAutor;
	}

	public void setNome(String nome) {
		this.nomeAutor = nome;
	}

	public String getAutorBiografia() {
		return autorBiografia;
	}

	public void setAutorBiografia(String autorBiografia) {
		this.autorBiografia = autorBiografia;
	}

	public Autor converter(BiografiaRepository biografiaRepository) {
		Biografia biografia = biografiaRepository.findByAutorBiografia(autorBiografia);
		return new Autor(id, nomeAutor, autorBiografia);
	}

}
