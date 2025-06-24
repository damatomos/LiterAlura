package br.com.damatomos.literalura.literalura;

import br.com.damatomos.literalura.literalura.dto.RequireBookDTO;
import br.com.damatomos.literalura.literalura.dto.RequireDataDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		HttpClient client = HttpClient.newBuilder()
				.followRedirects(HttpClient.Redirect.ALWAYS)
				.build();

		HttpRequest request = HttpRequest.newBuilder(new URI("https://gutendex.com/books")).build();

		HttpResponse<String> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get();

		ObjectMapper mapper = new ObjectMapper();

		RequireDataDTO result = mapper.readValue(response.body(), RequireDataDTO.class);

		System.out.println(result.results());

	}
}
