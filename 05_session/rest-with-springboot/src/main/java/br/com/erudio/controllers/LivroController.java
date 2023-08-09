
package br.com.erudio.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.models.Livro;
import br.com.erudio.services.LivroService;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/livros")
public class LivroController {


@Autowired
private LivroService service;


@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public Livro findById(@PathVariable("id") int id){
		return service.findById(id);
}

//@CrossOrigin(origins = "http://localhost:8080")
@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public List<Livro> findAll() {
	return service.findAll();
}

@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE)
public Livro create(@RequestBody Livro livro) {

	return service.create(livro);
	
}


@PutMapping( 
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
public Livro update(@RequestBody Livro livro) {
	
	return service.update(livro);
	
}

public ResponseEntity<?> delete(int id) {
	
	service.delete(id);
	
	return ResponseEntity.noContent().build();
	
}



}