package com.orange5.transacao.controller;

import com.orange5.transacao.dto.TransacaoResponse;
import com.orange5.transacao.entity.Transacao;
import com.orange5.transacao.repository.TransacacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cartoes")
public class ConsultaCompraController {

    @Autowired
    TransacacaoRepository transacacaoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaCompra(@PathVariable("id") String id) {
        Integer page = 1;
        Integer size = 10;
        Pageable pageRequest = PageRequest.of(page, size, Sort.by("efetivadaEm").descending());

        Page<Transacao> transacao = transacacaoRepository.findAllByCartaoId(id, pageRequest);

        return transacao.isEmpty() ? 
                ResponseEntity.notFound().build() : ResponseEntity.ok().body(transacao.map(TransacaoResponse::new).getContent());
    }
}
