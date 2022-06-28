package br.com.biblioteca.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.configs.ControllerConfig;
import br.com.biblioteca.controllers.dto.LivroInput;
import br.com.biblioteca.controllers.dto.LivroOutput;
import br.com.biblioteca.converts.LivroConvert;
import br.com.biblioteca.entities.LivroEntity;
import br.com.biblioteca.services.LivroService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private LivroConvert livroConvert;
	
	@PostMapping
		public LivroOutput cadastra(@RequestBody @Valid LivroInput livroInput) {
			LivroEntity livroEntity = livroConvert.inputToNewEntity(livroInput);
			LivroEntity livroCadastrado = livroService.cria(livroEntity);
		return livroConvert.entityToOutput(livroCadastrado);
		
	}
	
	@PutMapping("/{id}")
		public LivroOutput altera(@PathVariable Long id, @RequestBody @Valid Livro Input livroInput) {
			LivroEntity localizaLivro = livroService.buscarLivroPorId(id);
			livroConvert.copyInputToEntity(localizaLivro, livroInput);
			LivroEntity livroAlterado = autorService.altera(localizaLivro);
		return livroConvert.entityToOutput(livroAlterado); 
		
	}
	
	@GetMapping
		public List<LivroOutput> listarTodosLivros() {
		    List<LivroEntity> listarTodosLivros = livroService.listarTodosLivros();
		return livroConvert.entityToOutput(listarTodosLivros);
			}
	
	@GetMapping("/{id}")
		public LivroOutput buscarPorId(@PathVariable Long id) {
			LivroEntity localizaLivro = livroService.buscarLivroPorId(id);
		return livroConvert.entityToOutput(localizaLivro);
		
	}
		
	@DeleteMapping("/{id}")
		public void remove(@PathVariable Long id) {
			LivroEntity localizaLivro = livroService.buscaLivroPorId(id);
			livroService.remove(localizaLivro);
	}