package br.com.damatomos.literalura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RequirePersonDTO(
        @JsonProperty("birth_year")
        Integer birthYear,
        @JsonProperty("death_year")
        Integer deathYear,
        @JsonProperty("name")
        String name
) {
}
