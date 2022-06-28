package br.com.biblioteca.controllers.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

	@Getter
	@Setter
		public class BiografiaInput {
	
	@Length(max = 1000)
	@NotNull(message = "Biografia dos autores é obbrigatório.")
		private String biografia;
}
