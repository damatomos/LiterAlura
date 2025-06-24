package br.com.damatomos.literalura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_person", schema = "public")
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "death_year")
    private Integer deathYear;
}
