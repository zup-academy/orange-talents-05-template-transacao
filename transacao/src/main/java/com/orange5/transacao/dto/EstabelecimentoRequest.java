package com.orange5.transacao.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orange5.transacao.entity.Estabelecimento;

public class EstabelecimentoRequest {

    @JsonProperty
    private String nome;

    @JsonProperty
    private String cidade;

    @JsonProperty
    private String endereco;

    @JsonCreator
    public EstabelecimentoRequest(@JsonProperty("nome") String nome,@JsonProperty("cidade") String cidade,@JsonProperty("endereco") String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }

}
