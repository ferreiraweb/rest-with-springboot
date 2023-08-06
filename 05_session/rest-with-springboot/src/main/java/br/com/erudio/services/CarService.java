package br.com.erudio.services;


import java.util.logging.Logger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.models.Car;
import br.com.erudio.repositories.CarRepository;

@Service
public class CarService {

	private Logger logger = Logger.getLogger(CarService.class.getName());
	
	@Autowired
	private CarRepository repository;
	
	public Car findById(Long id) {
		
		logger.info("): find Car by Id");
		
		return repository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException(">: Car not found for this id") );
						
	}
	
	public List<Car> findAll() {
		logger.info("): find all Cars");
		
		return repository.findAll();
	}
	
	public Car create(Car car) {
		logger.info("): create one new car");
		return repository.save(car);
	}
	
	public Car update(Car car) {
		
		logger.info("): update a car");
		
		Car entity = repository.findById(car.getId()).orElseThrow(
				() -> new ResourceNotFoundException(">: Car not found for this id")
				);
		
		entity.setBrand(car.getBrand());
		entity.setModel(car.getModel());
		entity.setYear(car.getYear());
		
		repository.save(entity);
		
		return entity;
	}
	
	public void delete(Long id) {
		logger.info("): delete one car");
		
		Car entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(">: Car not found for this id")
				);
		
		repository.delete(entity);
			
	}
	
	
	
}
