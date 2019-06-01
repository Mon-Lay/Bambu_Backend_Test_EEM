package com.bambu.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bambu.test.model.PersonModelBean;
import com.bambu.test.model.PersonReturnModelBean;
import com.bambu.test.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	Logger logger = LogManager.getLogger(PersonController.class);
	
	//Create New Person
	@CrossOrigin(origins = "*")
	 @RequestMapping(method = RequestMethod.POST, value = "/createPerson", consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public boolean createPerson(@RequestBody PersonModelBean request) throws Exception{
		PersonModelBean person = new PersonModelBean();
		boolean createStatus = false;
		try {
			person.setName(request.getName());
			person.setAge(request.getAge());
			person.setLatitude(request.getLatitude());
			person.setLongitude(request.getLongitude());
			person.setMonthlyIncome(request.getMonthlyIncome());
			person.setExperienced(request.getExperienced());
			person.setScore(request.getScore());
			
			createStatus = personService.createPerson(person);
			
			logger.debug("Create Status : "+createStatus);		
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return createStatus;
	}
	
	@CrossOrigin(origins = "*")
	 @RequestMapping(method = RequestMethod.GET, value = {"/people-like-you"}) 
	public PersonReturnModelBean getPeoples(@RequestParam(value="age", required = false) Integer age,
			@RequestParam(value="latitude", required = false) String latitude,
			@RequestParam(value="longitude", required = false) String longitude,
			@RequestParam(value="monthlyIncome", required = false) Integer monthlyIncome,
			@RequestParam(value="experienced", required = false) Boolean experienced) throws Exception{
		PersonReturnModelBean persons = new PersonReturnModelBean();
		try {
			PersonModelBean bean = new PersonModelBean();
			bean.setAge(age);
			bean.setLatitude(latitude);
			bean.setLongitude(longitude);
			bean.setMonthlyIncome(monthlyIncome);
			bean.setExperienced(experienced);
			persons = personService.getPersons(bean);
			
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return persons;
	}
	
}
