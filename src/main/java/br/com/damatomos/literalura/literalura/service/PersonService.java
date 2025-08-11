package br.com.damatomos.literalura.literalura.service;

import br.com.damatomos.literalura.literalura.dto.ResponsePersonDTO;
import br.com.damatomos.literalura.literalura.mapper.PersonMapper;
import br.com.damatomos.literalura.literalura.model.PersonModel;
import br.com.damatomos.literalura.literalura.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public PersonModel save(PersonModel personModel)
    {
        return repository.save(personModel);
    }

    public List<PersonModel> findAll()
    {
        return repository.findAll();
    }


    public List<PersonModel> findAllByYear(Integer year) {
        return repository.findAllByYear(year);
    }

    public Optional<PersonModel> findByAuthor(PersonModel author) {
        return repository.findByName(author.getName());
    }
}
