package br.unisul.trabalho.locadora.controller;

import br.unisul.trabalho.locadora.model.Aluga;
import br.unisul.trabalho.locadora.repository.AlugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aluga")
public class AlugarController {

    @Autowired
    AlugaRepository alugaRepository;

    @GetMapping("/")
    public List<Aluga> getAlugueis(){
        return this.alugaRepository.findAll();
    }

    @PostMapping("/create")
    public Aluga createAluga(@Valid @RequestBody Aluga aluga){
        return this.alugaRepository.save(aluga);
    }

    @GetMapping("/{id}")
    public Aluga getAluguel(@PathVariable(value = "id") Integer id){
        return this.alugaRepository.findById(id).orElseThrow(null);
    }

    @PutMapping("/edit/{id}")
    public Aluga updateAluguel(@PathVariable(value = "id") Integer codigo, @Valid @RequestBody Aluga alugaNew){

        Aluga aluga = this.getAluguel(codigo);
        aluga.setDtDevolucao(alugaNew.getDtDevolucao());
        return this.alugaRepository.save(aluga);
    }
}
