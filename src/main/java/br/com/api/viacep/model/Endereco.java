package br.com.api.viacep.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String numero;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    @Deprecated
    public Endereco() {
    }

    public Endereco(String cep, String logradouro, String complemento,
                    String numero, String bairro, String localidade,
                    String uf, String ibge, String gia, String ddd,
                    String siafi) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getIbge() {
        return ibge;
    }

    public String getGia() {
        return gia;
    }

    public String getDdd() {
        return ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public Long getId() {
        return id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                '}';
    }
}

