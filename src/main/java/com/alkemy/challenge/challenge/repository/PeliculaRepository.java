package com.alkemy.challenge.challenge.repository;


import com.alkemy.challenge.challenge.entity.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity,Long> {
}
