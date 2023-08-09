package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.HelloModel;
import com.example.demo.repository.Hellorepository;

@Service
public class HelloService implements IService{

	@Autowired
	private Hellorepository repository;
	
	@Override
	public String print() {
		return "Welcome to Spring";
	}

	@Override
	public String getDtails() {
		return "Spring is awesome";
	}

	@Override
	public String addValue(HelloModel model) {
		String val = "My name is :" +model.getFirstName()+" "+model.getLastName()+" "+model.getSalary();
		return val;	}

	@Override
	public String postData(String firstName, String lastName, int salary) {
		String val = "My New Name is :"+firstName+ " "+lastName+ " "+salary;
		return val;
	}

	@Override
	public HelloModel postempuser(HelloModel model) {
		
		HelloModel user = new HelloModel(model);
		repository.save(user);	
		return user;
		
	}

	@Override
	public List<HelloModel> getAllUser() {
		return repository.findAll();
	}

	@Override
	public HelloModel getAllUser(int id) {
	
		Optional<HelloModel> user = repository.findById(id);
		return user.get();
	}

	@Override
	public String deleteUser(int id) {
		repository.deleteById(id);
		return "User deleted Successfull,with the help of Id :" +id;
	}

	@Override
	public HelloModel update(int id, HelloModel model) {
		HelloModel user =repository.findById(id).get();
		user.setFirstName(model.getFirstName());
		user.setLastName(model.getLastName());
		user.setSalary(model.getSalary());
		repository.save(user);
		return user;
	}

	@Override
	public HelloModel getData(int id) {
		Optional<HelloModel> user = repository.findById(id);
		return user.get();
	}
	

}
