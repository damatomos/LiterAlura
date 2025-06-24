package br.com.damatomos.literalura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_book", schema = "public")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "subjects")
    private String[] subjects;

    @ManyToOne()
    private PersonModel authors;

}
