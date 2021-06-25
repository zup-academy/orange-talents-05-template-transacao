package com.orange5.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orange5.transacao.entity.Transacao;

public class TransacaoRequest {

    @JsonProperty
    private String id;

    @JsonProperty
    private BigDecimal valor;

    @JsonProperty
    private LocalDateTime efetivadaEm;

    @JsonProperty
    private CartaoRequest cartao;

    @JsonProperty
    private EstabelecimentoRequest estabelecimento;

    /**
     * @param id
     * @param valor
     * @param efetivadaEm
     * @param cartao para funcionar corretamente o Objeto preciso ter o nome do objeto que recebe por exemplo Cartao cartao
     * @param estabelecimento mesma coisa
     */
    
    @JsonCreator
    public TransacaoRequest(@JsonProperty("id") String id, @JsonProperty("valor") BigDecimal valor,
            @JsonProperty("efetivadaEm") LocalDateTime efetivadaEm, @JsonProperty("cartao") CartaoRequest cartao,
            @JsonProperty("estabelecimento") EstabelecimentoRequest estabelecimento) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.cartao = cartao;
        this.estabelecimento = estabelecimento;
    }

    public Transacao toModel() {
        return new Transacao(id, valor, efetivadaEm, getCartao().toModel(), getEstabelecimento().toModel());
    }

    public String getId() {
        return this.id;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public CartaoRequest getCartao() {
        return this.cartao;
    }

    public EstabelecimentoRequest getEstabelecimento() {
        return this.estabelecimento;
    }

}
