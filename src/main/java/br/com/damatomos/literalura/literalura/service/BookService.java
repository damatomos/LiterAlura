package br.com.damatomos.literalura.literalura.service;

import br.com.damatomos.literalura.literalura.dto.ResponseBookDTO;
import br.com.damatomos.literalura.literalura.mapper.BookMapper;
import br.com.damatomos.literalura.literalura.model.BookModel;
import br.com.damatomos.literalura.literalura.model.PersonModel;
import br.com.damatomos.literalura.literalura.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final PersonService personService;

    @Transactional
    public ResponseBookDTO save(BookModel bookModel)
    {
        Optional<BookModel> book = repository.findByTitle(bookModel.getTitle());
        if (book.isEmpty())
        {
            Optional<PersonModel> authorOptional = personService.findByAuthor(bookModel.getAuthor());

            PersonModel author;

            author = authorOptional.orElseGet(() -> personService.save(bookModel.getAuthor()));

            bookModel.setAuthor(author);
            repository.save(bookModel);
        }
        return BookMapper.toResponse(bookModel);
    }

    public List<ResponseBookDTO> findAll()
    {
        return repository.findAll().stream().map(BookMapper::toResponse).collect(Collectors.toList());
    }

    public List<BookModel> findBooksByIdiom(String idiom) {
        return repository.findAllByIdiom(idiom);
    }
}
