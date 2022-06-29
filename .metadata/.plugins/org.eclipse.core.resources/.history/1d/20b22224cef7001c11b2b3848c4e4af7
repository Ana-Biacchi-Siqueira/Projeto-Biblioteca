package br.com.biblioteca.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

	@Getter
	@Setter
	@Entity
	@Table(name = "table_livros")
		public class LivroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
		private Long id;

	@Column(name = "titulo", length = 200)
		private String titulo;

	@Column(name = "ano_de_lancamento", columnDefinition = "integer(4)")
		private Integer anoDeLancamento;

	@JoinColumn(name = "autor_id")
	@ManyToMany
	@JoinTable(name = "table_livros_autores", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
		private List<AutorEntity> autores;
}
