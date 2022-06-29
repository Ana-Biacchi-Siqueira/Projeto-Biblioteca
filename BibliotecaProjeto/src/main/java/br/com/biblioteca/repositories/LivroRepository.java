package br.com.biblioteca.repositories;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.entities.LivroEntity;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

	Page<LivroEntity> findAllByAutoresIds(Long id, Pageable paginacao);

}
