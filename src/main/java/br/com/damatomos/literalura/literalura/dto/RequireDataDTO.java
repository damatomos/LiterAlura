package br.com.damatomos.literalura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record RequireDataDTO(
        @JsonProperty("count")
        Integer count,
        @JsonProperty("next")
        String next,
        @JsonProperty("previous")
        String previous,
        @JsonProperty("results")
        List<RequireBookDTO> results
) {
}
