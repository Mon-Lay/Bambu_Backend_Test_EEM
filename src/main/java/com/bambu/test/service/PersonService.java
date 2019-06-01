package com.bambu.test.service;

import com.bambu.test.model.PersonModelBean;
import com.bambu.test.model.PersonReturnModelBean;

public interface PersonService {

	boolean createPerson(PersonModelBean person);	
	PersonReturnModelBean getPersons(PersonModelBean bean);
}
