package br.com.biblioteca.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.biblioteca.controllers.dto.AutorInput;
import br.com.biblioteca.controllers.dto.AutorOutput;
import br.com.biblioteca.controllers.dto.BiografiaInput;
import br.com.biblioteca.controllers.dto.BiografiaOutput;
import br.com.biblioteca.entities.AutorEntity;
import br.com.biblioteca.entities.BiografiaEntity;

	@Component
		public class BiografiaConvert {

	@Autowired
		private ModelMapper modelMapper;

		public BiografiaEntity inputToNewEntity(BiografiaInput biografiaInput) {
			return modelMapper.map(biografiaInput, BiografiaEntity.class);
	}

		public BiografiaOutput entityToOutput(BiografiaEntity biografiaEntity) {
			return modelMapper.map(biografiaEntity, BiografiaOutput.class);
	}

		public BiografiaEntity entityToOutput(BiografiaEntity biografia) {
			return biografia.stream().map(biografiaEntity -> {
				return entityToOutput(autorEntity);
					}).collect(Collectors.toList());
	}

		public void copyInputToEntity(AutorEntity autorEntity, AutorInput autorInput) {
			modelMapper.map(autorInput, autorEntity);
	}

}
