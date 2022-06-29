package br.com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.biblioteca.entities.AutorEntity;
import br.com.biblioteca.entities.LivroEntity;
import br.com.biblioteca.repositories.AutorRepository;
import br.com.biblioteca.repositories.LivroRepository;

	@Service
		public class LivroService {

	@Autowired
		private LivroRepository livroRepository;
	
		public LivroEntity cria(LivroEntity livroEntity) {
			return livroRepository.save(livroEntity);
	}

		public Page<LivroEntity> buscarLivrosPeloIdDoAutor(Long id, Pageable paginacao) {
			return livroRepository.findAllByAutoresIds(id, paginacao);
	}

		public LivroEntity buscarLivrosPeloId(Long id) {
			return livroRepository.findById(id) }
	//					.orElseThrow(() -> new NotFoundException(String.format("Livro %d não encontrado", id)));
	//}

		public List<LivroEntity> listaTodosLivros() {
			return livroRepository.findAll();
	}
		public LivroEntity altera(LivroEntity livroEntity) {
			return livroRepository.save(livroEntity);
	}
		public void remove(LivroEntity livroLocalizado) {
			livroRepository.delete(livroLocalizado);
	}



}