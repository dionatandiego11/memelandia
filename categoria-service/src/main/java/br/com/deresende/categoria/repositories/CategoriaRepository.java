package br.com.deresende.categoria.repositories;

import br.com.deresende.categoria.entities.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaMeme, Long> {
}