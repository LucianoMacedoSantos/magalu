package com.magalu.repository;

import com.magalu.entity.Comunicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunicacaoRepository extends JpaRepository<Comunicacao, Long> {
}
