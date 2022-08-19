package com.ifce.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ifce.br.model.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository <Cliente , Long>  {

}
