package br.com.damatomos.literalura.literalura.dto;

import java.util.List;
import java.util.stream.Collectors;

public record ResponsePersonDTO(
        String name,
        Integer birthYear,
        Integer deathYear,
        List<String> books
) {
    @Override
    public String toString() {
        return """
               {
                    Nome do Autor: %s,
                    Ano de nascimento: %s,
                    Ano de falecimento: %s,
                    Livros: %s
               }
               """.formatted(name, birthYear, deathYear, String.join(", ", books));
    }
}
