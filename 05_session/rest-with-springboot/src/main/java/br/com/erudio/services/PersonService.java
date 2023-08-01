package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.AutoMapper;
import br.com.erudio.models.Person;
import br.com.erudio.data.vo.v1.PersonDTO;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	private PersonRepository repository;
	
	public PersonService() {}
	
	public PersonDTO findById(Long id) {
		
		logger.info("): Find one person");

		var entity = repository.findById(id)
				.orElseThrow(() -> 
				new ResourceNotFoundException("No records found for this ID!"));
		
		return AutoMapper.parseObject(entity, PersonDTO.class);
		
	}
	
	public List<PersonDTO> findAll() {
		
		logger.info("): Finding all people!");
				
		return AutoMapper.parseListObjects(repository.findAll(), PersonDTO.class);
	}

	public PersonDTO create(PersonDTO person) {

		logger.info("): creating new person");

		var entity =  repository.save(AutoMapper.parseObject(person, Person.class));
		
		return AutoMapper.parseObject(entity, PersonDTO.class);
		
	}
	
	public PersonDTO update(PersonDTO person) {
		logger.info("): updating person");
				
		var entity = repository.findById(person.getId())
				.orElseThrow( () -> 
				new ResourceNotFoundException("No records found for this ID!") ); 
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var dto = repository.save(entity);
		
		return AutoMapper.parseObject(dto, PersonDTO.class);
		
		
		
	}

	public void delete(Long id) {
		logger.info("): Deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID!") ); 
		
		repository.delete(entity);
	}
	
}
