package br.com.api.viacep.controller;

import br.com.api.viacep.dto.EnderecoDto;
import br.com.api.viacep.dto.EnderecoRequest;
import br.com.api.viacep.interfaces.BuscaPeloCep;
import br.com.api.viacep.model.Endereco;
import br.com.api.viacep.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
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

    @GetMapping()
    public ResponseEntity<?> listar() {
        List<EnderecoDto> enderecos = enderecoRepository.findAllBy();
        return ResponseEntity.ok().body(enderecos);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        enderecoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid EnderecoRequest request) {
        Optional<Endereco> existeEndereco = enderecoRepository.findById(id);
        if (existeEndereco.isPresent()) {
            Endereco endereco = request.atualizar(id, enderecoRepository);
            enderecoRepository.save(endereco);
            return ResponseEntity.ok().body(endereco);
        }
        return ResponseEntity.badRequest().build();
    }
}
