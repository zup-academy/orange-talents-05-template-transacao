package com.orange5.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.orange5.transacao.entity.Transacao;

public class TransacaoResponse {
 
    private String id;
	private BigDecimal valor;
	private LocalDateTime efetivadaEm;
	private String email;
	private String nome;
	private String cidade;
	private String endereco;
    
    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.email = transacao.getCartao().getEmail();
        this.nome = transacao.getEstabelecimento().getNome();
        this.cidade = transacao.getEstabelecimento().getCidade();
        this.endereco = transacao.getEstabelecimento().getEndereco();
    }

    public String getId() {
        return this.id;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return this.efetivadaEm;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getEndereco() {
        return this.endereco;
    }

}

    
