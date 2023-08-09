package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
public class HelloModel {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String firstName;
	private String lastName;
	private int salary;
	
	public HelloModel (HelloModel model)
	{
		this.firstName = model.getFirstName();
		this.lastName = model.getLastName();
		this.salary = model.getSalary();
	}
	
	

	
	
	
	
}
