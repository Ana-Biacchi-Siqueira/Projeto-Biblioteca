package br.com.biblioteca.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.configs.ControllerConfig;
import br.com.biblioteca.controllers.dto.AutorInput;
import br.com.biblioteca.controllers.dto.AutorOutput;
import br.com.biblioteca.controllers.dto.BiografiaInput;
import br.com.biblioteca.controllers.dto.BiografiaOutput;
import br.com.biblioteca.converts.AutorConvert;
import br.com.biblioteca.converts.LivroConvert;
import br.com.biblioteca.entities.AutorEntity;
import br.com.biblioteca.entities.BiografiaEntity;
import br.com.biblioteca.services.AutorService;
import br.com.biblioteca.services.LivroService;

	@RestController
	@RequestMapping(ControllerConfig.PRE_URL + "/autores")
		public class AutorController {
	
	@Autowired
		private AutorService autorService;
	
	@Autowired
		private AutorConvert autorConvert;
	
	@Autowired
		private AutorService biografiaService;
	
	@Autowired
		private AutorConvert biografiaConvert; 
	
	@Autowired
		private LivroService livroService;
	
	@Autowired
		private LivroConvert livroConvert;
	
	@PostMapping
		public AutorOutput cadastra(@RequestBody @Valid AutorInput autorInput) {
		AutorEntity autorEntity = autorConvert.inputToNewEntity(autorInput);
		AutorEntity cadastraAutor = autorService.cadastra(autorEntity);
			return autorConvert.entityToOutput(cadastraAutor);
		
	}
	
	@PutMapping("/{id}")
		public AutorOutput altera(@PathVariable Long id, @RequestBody @Valid AutorInput autorInput) {
			AutorEntity encontraAutor = autorService.listarPorId(id);
			autorConvert.copyInputToEntity(encontraAutor, autorInput);
			AutorEntity autorAlterado = autorService.altera(encontraAutor);
		return autorConvert.entityToOutput(autorAlterado); 
		
	}
		
	@PostMapping("/{id}")
		public BiografiaOutput cadastraBio(@RequestBody @Valid BiografiaInput biografiaInput) {
			BiografiaEntity biografiaEntity = biografiaConvert.inputToNewEntity(biografiaInput);
			BiografiaEntity cadastraBiografia = biografiaService.cria(biografiaEntity);
		return biografiaConvert.entityToOutput(cadastraBiografia); } 
			
    @GetMapping
		public List<AutorOutput> listarTodos() {
		    List<AutorEntity> listarTodos = autorService.listarTodos();
		return autorConvert.entityToOutput(listarTodos);
			}
    
    @GetMapping("/{id}")
		public AutorOutput listarPorId(@PathVariable Long id) {
	    		AutorEntity listarPorId = autorService.listarPorId(id);
	    return autorConvert.entityToOutput(listarPorId);
		}
		
		
		
		
			