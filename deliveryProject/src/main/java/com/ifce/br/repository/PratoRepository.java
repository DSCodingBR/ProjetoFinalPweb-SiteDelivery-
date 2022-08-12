package com.ifce.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifce.br.model.Prato;

@Repository
public interface PratoRepository extends JpaRepository <Prato , Long> {

}
