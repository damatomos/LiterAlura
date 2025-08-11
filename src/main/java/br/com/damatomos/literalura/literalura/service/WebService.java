package br.com.damatomos.literalura.literalura.service;

import br.com.damatomos.literalura.literalura.dto.RequireDataDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class WebService {

    public HttpResponse<String> request(String url) throws URISyntaxException, ExecutionException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder(new URI(url)).build();
        HttpResponse<String> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get();

        return response;
    }

    public RequireDataDTO findBooks() throws Exception
    {
        HttpResponse<String> response = request("https://gutendex.com/books");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), RequireDataDTO.class);
    }

    public RequireDataDTO findBooksByTitle(String title) throws Exception
    {
        HttpResponse<String> response = request("https://gutendex.com/books?search=" + title.replace(" ", "+").toLowerCase());
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response.body(), RequireDataDTO.class);
    }

}
