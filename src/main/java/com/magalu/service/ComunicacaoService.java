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

    public void cancelarComuicacao(Long id) {
        Optional<Comunicacao> comunicacao = comunicacaoRepository.findById(id);
        comunicacao.ifPresent(c -> {
            c.setStatus("cancelado");
            comunicacaoRepository.save(c);
        });
    }
}
