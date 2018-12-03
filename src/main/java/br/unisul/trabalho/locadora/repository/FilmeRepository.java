package br.unisul.trabalho.locadora.repository;

import br.unisul.trabalho.locadora.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme,Integer> {

}
