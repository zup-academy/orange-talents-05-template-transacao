package com.orange5.transacao.repository;

import com.orange5.transacao.entity.Transacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacacaoRepository extends JpaRepository<Transacao, String> {}
