package com.alkemy.challenge.challenge.repository;


import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entity.PeliculaEntity;
import com.alkemy.challenge.challenge.entity.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity,Long>,JpaSpecificationExecutor<PersonajeEntity> {
List<PersonajeEntity> findAll(Specification<PersonajeEntity>espc);
}
