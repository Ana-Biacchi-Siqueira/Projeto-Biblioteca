package br.com.biblioteca.converts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import br.com.biblioteca.controllers.dto.LivroInput;
import br.com.biblioteca.controllers.dto.LivroOutput;
import br.com.biblioteca.entities.AutorEntity;
import br.com.biblioteca.entities.LivroEntity;
import br.com.biblioteca.services.AutorService;

	@Component
		public class LivroConvert {
		
	@Autowired
		private ModelMapper modelMapper;
	
	@Autowired
		private AutorService autoresService;
	
		public LivroEntity inputToNewEntity(LivroInput livroInput) {
			LivroEntity livroEntity = modelMapper.map(livroInput, LivroEntity.class);
			converteIdsAutorParaAutores(livroInput, livroEntity);
		return livroEntity;
		
		}
		
		public void copyInputToEntity(LivroEntity livroEntity, LivroInput livroInput) {
			modelMapper.map(livroInput, livroEntity);
			converteIdsAutorParaAutores(livroInput, livroEntity);
			
		}

		public LivroOutput entityToOutput(LivroEntity livroEntity) {
			return modelMapper.map(livroEntity, LivroOutput.class);
		}
		
		public List<LivroOutput> entityToOutput(List<LivroEntity> livros) {
			return livros.stream().map(livroEntity -> {
				return entityToOutput(livroEntity);
			}).collect(Collectors.toList()); }
		
		private void converteIdsAutorParaAutores(LivroInput livroInput, LivroEntity livroEntity) {
			List<AutorEntity> autores = new ArrayList<>();
			for (Long idAutor : livroInput.getIdsAutores(); {
				AutorEntity autor = autoresService.listarPeloId(idAutor);
				autores.add(autor);
			}
			livroEntity.setAutores(autores); }
		
		
		public Page<LivroOutput> listPageEntityToListPageOutput(Page<LivroEntity> localizaLivros) {
			return localizaLivros.map(this::entityToOutput);
		}

		//public void copyInputToEntity(LivroEntity localizaLivro, @Valid LivroInput livroInput) {
			//modelMapper.map(livroInput, localizaLivro);
			//converteIdsAutorParaAutores(livroInput, localizaLivro);

		

		public Page<LivroOutput> entityToOutput(Page<LivroEntity> localizaLivros, Pageable paginacao) {
			return new PageImpl<>(localizaLivros.stream().map(livroEntity -> {
				return entityToOutput(livroEntity);
			}).collect(Collectors.toList()));
		}}
