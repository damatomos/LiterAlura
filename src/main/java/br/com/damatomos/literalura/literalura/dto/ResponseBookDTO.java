package br.com.damatomos.literalura.literalura.dto;

public record ResponseBookDTO(
        String title,
        String author,
        String idioms,
        Integer countDownloads
) {
    @Override
    public String toString() {
        return """
               {
                    Título: %s,
                    Autor: %s,
                    Idioma: %s,
                    Número de downloads: %d
               }
               """.formatted(title, author, idioms, countDownloads);
    }
}
