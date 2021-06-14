package br.com.api.viacep.dto;

import br.com.api.viacep.model.Endereco;
import br.com.api.viacep.repository.EnderecoRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class EnderecoRequest {

    @NotBlank
    private String numero;

    @NotBlank
    private String complemento;

    public EnderecoRequest(String numero, String complemento) {
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco atualizar(Long id, EnderecoRepository repository) {
        Endereco endereco = repository.findById(id).get();
        endereco.setNumero(this.numero);
        endereco.setComplemento(this.complemento);
        return endereco;
    }
}
