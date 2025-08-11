package br.com.damatomos.literalura.literalura.mapper;

import br.com.damatomos.literalura.literalura.dto.ResponsePersonDTO;
import br.com.damatomos.literalura.literalura.model.BookModel;
import br.com.damatomos.literalura.literalura.model.PersonModel;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class PersonMapper {

    @Transactional
    public static ResponsePersonDTO toResponse(PersonModel model)
    {
        return new ResponsePersonDTO(model.getName(), model.getBirthYear(), model.getDeathYear(), model.getBooks().stream().map(BookModel::getTitle).collect(Collectors.toList()));
    }

}
