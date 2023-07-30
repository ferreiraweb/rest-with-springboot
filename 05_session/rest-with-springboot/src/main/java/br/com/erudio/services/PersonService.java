package br.com.erudio.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.models.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonService {

	//private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
		
	
	public PersonService() {}
	
	
	public Person findById(Long id) {
		
		logger.info("): Find one person");
		
		/*
		Person person = new Person();
		
		//person.setId(counter.getAndIncrement());
		person.setFirstName("Alexandre");
		person.setLastName("Ferreira");
		person.setAddress("Rua CAETE - DUQUE DE CAXIAS - RJ");
		person.setGender("Male");
		
		return person;
		*/
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public List<Person> findAll() {
		/*
		List<Person> persons = new ArrayList<Person>();
		
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
		*/
		logger.info("): Finding all people!");
		return repository.findAll();
		
	}

	public Person create(Person person) {
		logger.info("): creating new person");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("): updating person");
		
		Person entity = repository.findById(person.getId())
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID!") ); 
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}

	public void delete(Long id) {
		logger.info("): Deleting one person!");
		
		Person entity = repository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID!") ); 
		
		repository.delete(entity);
		
	}
	
	
	// --------------------------------------
	
	/*
	private Person mockPerson(int i) {
		
		Person person = new Person();
		
		person.setId(counter.getAndIncrement());
		person.setFirstName("Alexandre " + i);
		person.setLastName("Ferreira " + i);
		person.setAddress("Rua CAETE - DUQUE DE CAXIAS - RJ " + i);
		person.setGender("Male");
				
		return person;
	}
	
	*/
}
