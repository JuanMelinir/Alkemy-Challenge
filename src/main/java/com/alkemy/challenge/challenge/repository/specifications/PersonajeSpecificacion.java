package com.alkemy.challenge.challenge.repository.specifications;

import com.alkemy.challenge.challenge.controller.PersonajeFiltersDTO;
import com.alkemy.challenge.challenge.entity.PeliculaEntity;
import com.alkemy.challenge.challenge.entity.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
//import org.springframework.util.StringUtils;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


public class PersonajeSpecificacion {

    public Specification<PersonajeEntity> getByFilters(PersonajeFiltersDTO filtersDTO){
        return  (root,query,criteriaBuilder)->{
        List<Predicate> predicates=new ArrayList<>();
        if(StringUtils.hasLength(filtersDTO.getNombre())){
            predicates.add(
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("nombre")),
                            "%"+filtersDTO.getNombre().toLowerCase()+"%"
                    )
            );

        }
            if(StringUtils.hasLength(filtersDTO.getEdad())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("nombre")),
                                "%"+filtersDTO.getNombre().toLowerCase()+"%"
                        )
                );

            }
            if(!CollectionUtils.isEmpty(filtersDTO.getPeliculas())){
                Join<PeliculaEntity,PersonajeEntity>join=root.join("peliculas", JoinType.INNER);
                Expression<String>peliculasId=join.get("id");
                predicates.add(peliculasId.in(filtersDTO.getPeliculas()));
            }
            //Remover duplicados
            query.distinct(true);
            //Order resolver
            String orderByField="nombre";
            query.orderBy(
                    filtersDTO.isASC()?
                            criteriaBuilder.asc(root.get(orderByField)):
                            criteriaBuilder.desc(root.get(orderByField))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
