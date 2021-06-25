package com.orange5.transacao.components;

import com.orange5.transacao.dto.TransacaoRequest;
import com.orange5.transacao.entity.Transacao;
import com.orange5.transacao.repository.TransacacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoComponent {

    @Autowired
    TransacacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void escutaTopico(TransacaoRequest transacaoRequest) {
        Transacao transacao = transacaoRequest.toModel();
        transacaoRepository.save(transacao);
    }
}
