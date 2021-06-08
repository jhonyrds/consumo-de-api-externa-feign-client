package br.com.api.viacep.controller;

import br.com.api.viacep.interfaces.BuscaPeloCep;
import br.com.api.viacep.model.Endereco;
import br.com.api.viacep.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepRestController {

    @Autowired
    private BuscaPeloCep buscaPeloCep;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> getCep(@PathVariable String cep) {

        Endereco endereco = buscaPeloCep.buscaEnderecoPorCep(cep);


        if (endereco != null) {
            enderecoRepository.save(endereco);
            return ResponseEntity.ok().body(endereco);
        }
        return ResponseEntity.notFound().build();
    }
}
