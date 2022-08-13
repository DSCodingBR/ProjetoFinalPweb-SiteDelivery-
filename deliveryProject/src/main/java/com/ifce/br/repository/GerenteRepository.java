package com.ifce.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ifce.br.model.Gerente;


@Repository
public interface GerenteRepository extends JpaRepository <Gerente , Long>  {

}
