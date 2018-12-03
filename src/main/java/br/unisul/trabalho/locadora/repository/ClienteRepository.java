package br.unisul.trabalho.locadora.repository;

import br.unisul.trabalho.locadora.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
