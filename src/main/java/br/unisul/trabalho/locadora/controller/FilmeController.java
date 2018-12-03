package br.unisul.trabalho.locadora.controller;

import br.unisul.trabalho.locadora.model.Filme;
import br.unisul.trabalho.locadora.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {


    @Autowired
    FilmeRepository filmeRepository;

    @GetMapping("/")
    public List<Filme> getFilmes(){
        return this.filmeRepository.findAll();
    }

    @PostMapping("/create")
    @ResponseBody
    public Filme createFilme(@Valid @RequestBody Filme filme){
        return this.filmeRepository.save(filme);

    }

    @GetMapping("/{id}")
    public Filme getFilme(@PathVariable(value = "id") Integer id){
        return this.filmeRepository.findById(id).orElseThrow(null);
    }

    @PutMapping("/edit/{id}")
    public Filme updateFilme(@PathVariable(value = "id") Integer codigo, @Valid @RequestBody Filme filmeNew){

        Filme filme = this.getFilme(codigo);
        filme.setTitulo(filmeNew.getTitulo());
        filme.setTipo(filmeNew.getTipo());
        filme.setQuantidade(filmeNew.getQuantidade());
        return this.filmeRepository.save(filme);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFilme(@PathVariable(value = "id") Integer codigo){
        Filme filme = this.getFilme(codigo);
        this.filmeRepository.delete(filme);
        return ResponseEntity.ok().build();
    }

}
