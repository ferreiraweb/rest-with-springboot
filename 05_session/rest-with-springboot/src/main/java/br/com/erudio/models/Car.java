package br.com.erudio.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "car")
public class Car implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "brand", nullable = false, length = 10)
	private String brand;
	
	@Column(name = "model", nullable = false, length = 20)
	private String model;
	
	@Column(name = "year", nullable = false )
	private Integer year;
	
	
	private Car() {}

	/* ------------------------------- */
	
	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, id, model, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(id, other.id) && Objects.equals(model, other.model)
				&& Objects.equals(year, other.year);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	

	
	
	
	
	
	
}
