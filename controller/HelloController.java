package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HelloModel;
import com.example.demo.service.IService;

@RestController
public class HelloController {
	
	@Autowired
	IService service;
	
	@RequestMapping(value="/abc",method = RequestMethod.GET)
	@ResponseBody
	public String print()
	{
		return "Hello World";
	}
	
	@GetMapping("/post")
	public String kite()
	{
		return "Kite is go away ";
	}
	
	@GetMapping ("/shine")
	public String Student()
	{
		String details = service.getDtails();
		return details;
	}
	
	@PostMapping ("/pot")
	public String postData(@RequestBody HelloModel model)
	{
		String details = service.addValue(model);
		return details;
	}
	
	@PostMapping("/show/{salary}")
	public String addValue(@RequestHeader String firstName, @RequestHeader String lastName, @PathVariable int salary)
	{
		String details = service.postData(firstName, lastName, salary);
				return details;
	}
	
	@PostMapping("/fine")
	public HelloModel postempuser(@RequestBody HelloModel model)
	{
		HelloModel user = service.postempuser(model);
		return user;
	}
	
	@GetMapping("/search")
	public List<HelloModel> allUser()
	{
		List<HelloModel> allUser = service.getAllUser() ;
		return allUser;
	}
	
	@GetMapping("/searchByID/{Id}")
	public HelloModel getEmp(@PathVariable int Id)
	{
		HelloModel User = service.getAllUser(Id);
		return User;
	}
	
	@DeleteMapping("/deletByID/{Id}")
	public String deleteEmp(@PathVariable int Id)
	{
		String User = service.deleteUser(Id);
		return User;
	}
	
	@PutMapping("/updateByTD/{Id}")
	public HelloModel update (@PathVariable int Id, @RequestBody HelloModel model)
	{
		HelloModel user = service.update(Id,model);
				return user;
	}
	
	@GetMapping ("/getById")
	public HelloModel getEmp1(@RequestParam int Id)
	{
		HelloModel User = service.getData(Id);
		return User;
	}

}
