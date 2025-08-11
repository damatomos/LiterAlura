package br.com.damatomos.literalura.literalura.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tbl_book", schema = "public")
@Data
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "idioms")
    private List<String> idioms;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private PersonModel author;

    @Column(name = "count_downloads")
    private Integer countDownloads;

}
