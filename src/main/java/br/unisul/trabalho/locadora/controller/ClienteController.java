package br.unisul.trabalho.locadora.controller;

import br.unisul.trabalho.locadora.model.Cliente;
import br.unisul.trabalho.locadora.repository.ClienteRepository;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/")
    public List<Cliente> getClientes(){
        return this.clienteRepository.findAll();
    }

    @PostMapping("/create")
    @ResponseBody
    public Cliente createCliente(@Valid @RequestBody Cliente cliente){
        return this.clienteRepository.save(cliente);

    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable(value = "id") Integer id){
        return this.clienteRepository.findById(id).orElseThrow(null);
    }

    @PutMapping("/edit/{id}")
    public Cliente updateCliente(@PathVariable(value = "id") Integer codigo, @Valid @RequestBody Cliente clienteUpdate){

        Cliente cliente = this.getCliente(codigo);
        cliente.setNome(clienteUpdate.getNome());
        cliente.setTelefone(clienteUpdate.getTelefone());
        return this.clienteRepository.save(cliente);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable(value = "id")
                                                 Integer codigo){
        Cliente cliente = this.getCliente(codigo);
        this.clienteRepository.delete(cliente);
        return ResponseEntity.ok().build();
    }
}
