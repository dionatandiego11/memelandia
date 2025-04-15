package br.com.deresende.meme.repositories;

import br.com.deresende.meme.entities.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemeRepository extends JpaRepository<Meme, Long> {
}