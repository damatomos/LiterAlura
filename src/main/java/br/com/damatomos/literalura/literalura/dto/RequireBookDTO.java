package br.com.damatomos.literalura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties("formats")
public record RequireBookDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("title")
        String title,
        @JsonProperty("subjects")
        List<String> subjects,
        @JsonProperty("authors")
        List<RequirePersonDTO> authors,
        @JsonProperty("summaries")
        List<String> summaries,
        @JsonProperty("translators")
        List<RequirePersonDTO> translators,
        @JsonProperty("bookshelves")
        List<String> bookshelves,
        @JsonProperty("languages")
        List<String> languages,
        @JsonProperty("copyright")
        Boolean copyright,
        @JsonProperty("media_type")
        String mediaType,
        @JsonProperty("download_count")
        Integer downloadCount
) {
}
