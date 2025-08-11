package br.com.damatomos.literalura.literalura.console;

import br.com.damatomos.literalura.literalura.dto.RequireDataDTO;
import br.com.damatomos.literalura.literalura.dto.ResponseBookDTO;
import br.com.damatomos.literalura.literalura.dto.ResponsePersonDTO;
import br.com.damatomos.literalura.literalura.mapper.BookMapper;
import br.com.damatomos.literalura.literalura.mapper.PersonMapper;
import br.com.damatomos.literalura.literalura.model.BookModel;
import br.com.damatomos.literalura.literalura.model.PersonModel;
import br.com.damatomos.literalura.literalura.service.BookService;
import br.com.damatomos.literalura.literalura.service.PersonService;
import br.com.damatomos.literalura.literalura.service.WebService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationConsole {

    private final WebService webService;
    private final BookService bookService;
    private final PersonService personService;

    public void run() throws Exception {
        Scanner in = new Scanner(System.in);
        String gui =
                """
                ------------------------------------------------------
                1) Buscar livro por título
                2) Listagem de todos os livros
                3) Listagem de autores
                4) Listagem de autores vivos em um determinado ano
                5) Listagem de livro por idioma
                6) Sair
                ------------------------------------------------------
                """;

        System.out.println(gui);
        Integer option = in.nextInt();
        in.nextLine();

        switch (option)
        {
            case 1:
                findBookByTitle(in);
                break;
            case 2:
                findAllBooks();
                break;
            case 3:
                findAllAuthors();
                break;
            case 4:
                listLiveAuthorsByYear(in);
                break;
            case 5:
                listBooksByIdioms(in);
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Nenhuma opção válida foi informada");
                break;
        }
    }

    private void listBooksByIdioms(Scanner in) {
        String gui =
                """
                Insira o idioma para realizar a busca:
                
                es - espanhol
                en - english
                fr - frânces
                pt - português
                """;
        System.out.println(gui);
        String idiom = in.nextLine();

        List<BookModel> books = bookService.findBooksByIdiom(idiom);

        if (books.isEmpty())
        {
            System.out.println("Não existem livros nesse idioma no banco de dados.");
            return;
        }

        String responseGui =
                """
                ------------------ Livros ------------------
                %s
                -------------------------------------------
                """.formatted(books.stream().map(BookMapper::toResponse).collect(Collectors.toList()));
        System.out.println(responseGui);
    }

    private void listLiveAuthorsByYear(Scanner in) {
        String gui =
                """
                Informe o ano que deseja pesquisar:
                """;
        System.out.println(gui);
        Integer year = in.nextInt();

        List<PersonModel> data = personService.findAllByYear(year);
        System.out.println(data.stream().map(PersonMapper::toResponse).collect(Collectors.toList()));

    }

    private void findAllBooks() throws Exception {
        List<ResponseBookDTO> data = bookService.findAll();
        System.out.println(data);
    }

    private void findBookByTitle(Scanner in) throws Exception {
        String gui =
                """
                Informe o título do livro:
                """;
        System.out.println(gui);
        String title = in.nextLine();
        RequireDataDTO data = webService.findBooksByTitle(title);

        if (data.results().isEmpty())
        {
            System.out.println("Nenhum livro chamado " + title + " foi encontrado.");
            return;
        }

        BookModel book = BookMapper.toModel(data.results().getFirst());
        bookService.save(book);

        String responseGui =
                """
                ------------------ Livro ------------------
                %s
                -------------------------------------------
                """.formatted(BookMapper.toResponse(book));
        System.out.println(responseGui);
    }

    private void findAllAuthors() throws Exception {
        List<PersonModel> data = personService.findAll();
        System.out.println(data.stream().map(PersonMapper::toResponse).collect(Collectors.toList()));
    }

}
