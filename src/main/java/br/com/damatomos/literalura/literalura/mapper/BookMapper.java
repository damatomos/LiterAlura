package br.com.damatomos.literalura.literalura.mapper;

import br.com.damatomos.literalura.literalura.dto.RequireBookDTO;
import br.com.damatomos.literalura.literalura.dto.RequirePersonDTO;
import br.com.damatomos.literalura.literalura.dto.ResponseBookDTO;
import br.com.damatomos.literalura.literalura.model.BookModel;
import br.com.damatomos.literalura.literalura.model.PersonModel;

import java.util.stream.Collectors;

public class BookMapper {

    public static BookModel toModel(RequireBookDTO book)
    {
        BookModel bookModel = new BookModel();
        bookModel.setTitle(book.title());
        bookModel.setIdioms(book.languages());
        bookModel.setCountDownloads(book.downloadCount());

        PersonModel author = new PersonModel();
        RequirePersonDTO authorDTO = book.authors().getFirst();
        author.setName(authorDTO.name());
        author.setBirthYear(authorDTO.birthYear());
        author.setDeathYear(authorDTO.deathYear());

        bookModel.setAuthor(author);
        return bookModel;
    }

    public static ResponseBookDTO toResponse(BookModel book)
    {
        return new ResponseBookDTO(
                book.getTitle(),
                book.getAuthor().getName(),
                book.getIdioms().getFirst(),
                book.getCountDownloads()
        );
    }

    public static ResponseBookDTO toResponse(RequireBookDTO book)
    {
        return new ResponseBookDTO(
                book.title(),
                book.authors().getFirst().name(),
                book.languages().stream().collect(Collectors.joining(", ")),
                book.downloadCount()
        );
    }

}
