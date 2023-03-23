
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
	@GetMapping("/tl-dolar")
	public String tlDolar(@RequestParam(value = "amount", defaultValue = "0") String amount,@RequestParam(value = "direction", defaultValue = "0") String direction) {
		String url = "http://localhost:5000/";
		if(direction.equals("1")){
			url += "usdToTry?amount="+ amount;
		}
		else{
			url += "tryToUsd?amount="+ amount;
		}
		return this.restTemplate.getForObject(url, String.class);
	}

	@GetMapping("/tl-euro")
	public String tlEuro(@RequestParam(value = "amount", defaultValue = "0") String amount,@RequestParam(value = "direction", defaultValue = "0") String direction) {
		String url = "http://localhost:4000/";
		if(direction.equals("1")){
			url += "euroToTry?amount="+ amount;
		}
		else{
			url += "tryToEuro?amount="+ amount;
		}
		return this.restTemplate.getForObject(url, String.class);
	}

	@GetMapping("/dolar-euro")
	public String dolarEuro(@RequestParam(value = "amount", defaultValue = "0") String amount,@RequestParam(value = "direction", defaultValue = "0") String direction) {
		String url = "http://localhost:6000/";
		if(direction == "1"){
			url += "euroToUsd?amount="+ amount;
		}
		else{
			url += "usdToEuro?amount="+ amount;
		}
		return this.restTemplate.getForObject(url, String.class);
	}
	@GetMapping("*")
	public String notfound() {
		return "Not Found";
	}

}
            