package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.erudio.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {}

