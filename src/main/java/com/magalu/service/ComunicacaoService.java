package com.magalu.service;

import com.magalu.entity.Comunicacao;
import com.magalu.repository.ComunicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComunicacaoService {

    @Autowired
    private ComunicacaoRepository comunicacaoRepository;

    public Comunicacao agendarComunicacao(Comunicacao comunicacao) {
        comunicacao.setStatus("agendado");
        return comunicacaoRepository.save(comunicacao);
    }

    public Optional<Comunicacao> consultarComunicacao(Long id) {
        return comunicacaoRepository.findById(id);
    }

    public Optional<Comunicacao> cancelarComunicacao(Long id) {
        return comunicacaoRepository.findById(id).map(comunicacao -> {
            comunicacao.setStatus("cancelado");
            return comunicacaoRepository.save(comunicacao);
        });
    }
}
