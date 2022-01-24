package com.alkemy.challenge.challenge.repository;

import com.alkemy.challenge.challenge.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero,Long> {
}
