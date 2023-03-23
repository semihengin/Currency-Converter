
package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class DemoApplication {

	private final RestTemplate restTemplate;

	public DemoApplication(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/usdToEuro")
	public String euroToTry(@RequestParam(value = "amount", defaultValue = "0") String amount) {
		String url = "https://anyapi.io/api/v1/exchange/convert?apiKey=coicvh0u50gmhl6bn651h89q7diec06h875buf1r69g6fp1522m5ug&amount="+amount+"&base=USD&to=EUR";
		return this.restTemplate.getForObject(url, String.class);
	}

	@GetMapping("/euroToUsd")
	public String tryToEuro(@RequestParam(value = "amount", defaultValue = "0") String amount) {
		String url = "https://anyapi.io/api/v1/exchange/convert?apiKey=coicvh0u50gmhl6bn651h89q7diec06h875buf1r69g6fp1522m5ug&amount="+amount+"&base=EUR&to=USD";
		return this.restTemplate.getForObject(url, String.class);
	}

}
            