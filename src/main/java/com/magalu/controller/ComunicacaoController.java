package com.magalu.controller;

import com.magalu.entity.Comunicacao;
import com.magalu.service.ComunicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/comunicacoes")
public class ComunicacaoController {

    @Autowired
    private ComunicacaoService comunicacaoService;

    @PostMapping
    private ResponseEntity<Comunicacao> agendarComunicacao(@RequestBody Comunicacao comunicacao) {
        Comunicacao novaComunicacao = comunicacaoService.agendarComunicacao(comunicacao);
        return ResponseEntity.ok(novaComunicacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comunicacao> consultarComunicacao(@PathVariable Long id) {
        Optional<Comunicacao> comunicacao = comunicacaoService.consultarComunicacao(id);
        return comunicacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarComunicacao(@PathVariable Long id) {
        Optional<Comunicacao> comunicacaoCancelada = comunicacaoService.cancelarComunicacao(id);
        if (comunicacaoCancelada.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
