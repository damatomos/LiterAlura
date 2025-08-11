package br.com.damatomos.literalura.literalura.repository;

import br.com.damatomos.literalura.literalura.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookModel, Long> {
    Optional<BookModel> findByTitle(String title);

    @Query(value = """
    SELECT *
    FROM tbl_book b
    WHERE :idiom = ANY(b.idioms)
    """, nativeQuery = true)
    List<BookModel> findAllByIdiom(@Param("idiom") String idiom);
}
