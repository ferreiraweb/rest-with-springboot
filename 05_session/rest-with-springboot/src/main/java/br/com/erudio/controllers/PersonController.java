package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.PersonDTO;
import br.com.erudio.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.*;


@RestController()
@RequestMapping("/api/persons")
@Tag(name = "People", description = "Edpoint fo managing People")
public class PersonController {

	@Autowired
	PersonService service;
	
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonDTO fingById( @PathVariable("id") Long id) {
		
		PersonDTO person = service.findById(id);
		return person;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(
			summary = "busca todas as pessoas", 
			description="", 
			tags= {"People"}, 
			responses = {
					@ApiResponse(description = "Success", responseCode = "200", 
							content = {
									@Content(
											mediaType = "application/json",
											array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class))
											)
							}),
					@ApiResponse(description = "Success", responseCode = "200", 
							content = @Content)
			})
	public List<PersonDTO> findAll() {
		return service.findAll();
	}

	@PostMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public PersonDTO create(@RequestBody PersonDTO person) {
		return service.create(person);
	}
	
	@PutMapping(
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public PersonDTO update(@RequestBody PersonDTO person) {
		return service.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
