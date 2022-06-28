package br.com.biblioteca.converts;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.biblioteca.controllers.dto.AutorInput;
import br.com.biblioteca.controllers.dto.AutorOutput;
import br.com.biblioteca.controllers.dto.BiografiaInput;
import br.com.biblioteca.entities.AutorEntity;
import br.com.biblioteca.entities.BiografiaEntity;

	@Component
		public class AutorConvert {

	@Autowired
		private ModelMapper modelMapper;

		public BiografiaEntity inputToNewEntity(@Valid BiografiaInput biografiaInput) {
		return modelMapper.map(biografiaInput, BiografiaEntity.class); }
	
		public AutorEntity inputToNewEntity(@Valid AutorInput autorInput) {
			return modelMapper.map(autorInput, AutorEntity.class);
	}

		public AutorOutput entityToOutput(AutorEntity autorEntity) {
			return modelMapper.map(autorEntity, AutorOutput.class);
	}

		public List<AutorOutput> entityToOutput(List<AutorEntity> autores) {
			return autores.stream().map(autorEntity -> {
				return entityToOutput(autorEntity);
					}).collect(Collectors.toList());
	}

		public void copyInputToEntity(AutorEntity autorEntity, AutorInput autorInput) {
			modelMapper.map(autorInput, autorEntity);
	}

}