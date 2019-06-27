package com.ufc.es.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufc.es.model.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long>{

}
