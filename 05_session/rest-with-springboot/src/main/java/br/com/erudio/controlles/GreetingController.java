package br.com.erudio.controlles;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.models.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong(); 
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Greeting geeting(
			@RequestParam(value="name", defaultValue="world") 
			String name) {
		
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
		return greeting;
	}
}



