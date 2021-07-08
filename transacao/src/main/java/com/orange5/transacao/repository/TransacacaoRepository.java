package com.orange5.transacao.repository;

import com.orange5.transacao.entity.Transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransacacaoRepository extends PagingAndSortingRepository<Transacao, String> {

    Page<Transacao> findAllByCartaoId(String id, Pageable pageable);
}
