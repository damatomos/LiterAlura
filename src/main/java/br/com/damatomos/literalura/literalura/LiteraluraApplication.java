package br.com.damatomos.literalura.literalura;

import br.com.damatomos.literalura.literalura.console.ApplicationConsole;
import br.com.damatomos.literalura.literalura.dto.RequireBookDTO;
import br.com.damatomos.literalura.literalura.dto.RequireDataDTO;
import br.com.damatomos.literalura.literalura.service.BookService;
import br.com.damatomos.literalura.literalura.service.WebService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private ApplicationConsole console;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true)
		{
			console.run();
		}

	}
}
