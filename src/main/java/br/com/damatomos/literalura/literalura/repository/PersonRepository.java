package br.com.damatomos.literalura.literalura.repository;

import br.com.damatomos.literalura.literalura.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {

    @Query("""
            SELECT p 
            FROM PersonModel p 
            WHERE (p.birthYear <= :year OR p.birthYear is NULL) 
            AND ( p.deathYear >= :year or p.deathYear is NULL)
            """)
    List<PersonModel> findAllByYear(@Param("year") Integer year);

    Optional<PersonModel> findByName(String name);
}
