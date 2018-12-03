package br.unisul.trabalho.locadora.repository;

import br.unisul.trabalho.locadora.model.Aluga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlugaRepository extends JpaRepository<Aluga,Integer> {
}
