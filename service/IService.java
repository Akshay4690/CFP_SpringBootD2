package com.example.demo.service;

import java.util.List;

import com.example.demo.model.HelloModel;

public interface IService {
	
	String  print();

	String getDtails();

	String addValue(HelloModel model);

	String postData(String firstName, String lastName, int salary);

	HelloModel postempuser(HelloModel model);

	List<HelloModel> getAllUser();

	HelloModel getAllUser(int id);

	String deleteUser(int id);

	HelloModel update(int id, HelloModel model);

	HelloModel getData(int id);


	
}
