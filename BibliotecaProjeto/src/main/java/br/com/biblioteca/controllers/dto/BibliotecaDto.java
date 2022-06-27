package br.com.biblioteca.controllers.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.biblioteca.entities.Autor;

public class BibliotecaDto {

	private Long id;
	private String nome;
	private String biografia;
	
	public BibliotecaDto(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.biografia = autor.getBiografia();}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getBiografia() {
		return biografia;
	}

	public static List<BibliotecaDto> converter(List<Autor> autores) {
		return autores.stream().map(BibliotecaDto::new).collect(Collectors.toList());
	}

}
