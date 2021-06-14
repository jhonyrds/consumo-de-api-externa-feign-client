package br.com.api.viacep.dto;

public interface EnderecoDto {
    Long getId();

    String getCep();

    String getLogradouro();

    String getNumero();

    String getComplemento();

    String getBairro();

    String getLocalidade();

    String getUf();
}
