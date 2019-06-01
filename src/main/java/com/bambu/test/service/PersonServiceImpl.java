package com.bambu.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bambu.test.model.PersonModelBean;
import com.bambu.test.model.PersonReturnModelBean;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean createPerson(PersonModelBean person) {
		boolean returnStatus = false;	
		try{
			String sql = "insert into tb_person (name,age,latitude,longitude,monthlyIncome,experienced,score) values(?, ?, ?, ?, ?, ?, ?)";
			int createStatus = jdbcTemplate.update(sql, person.getName(), person.getAge(),person.getLatitude(),person.getLongitude(),person.getMonthlyIncome(),person.getExperienced(),person.getScore());
			if(createStatus > 0)
				returnStatus = true;
			else 
				returnStatus = false;
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return returnStatus;
	}
	
	public PersonReturnModelBean getPersons(PersonModelBean bean) {
		ArrayList<PersonModelBean> persons = new ArrayList<PersonModelBean>();
		PersonReturnModelBean result = new PersonReturnModelBean();
		String param = "";
		try {
			if(bean.getAge() != null && bean.getLatitude() == null && bean.getLongitude() == null && bean.getMonthlyIncome() == null && bean.getExperienced() == null)
				param += " and age="+bean.getAge();
			else
				param += " or age="+bean.getAge();
			
			if(bean.getLatitude() != null && !bean.getLatitude().isEmpty())
				param += " or latitude='"+bean.getLatitude()+"'";
			
			if(bean.getLongitude() != null && !bean.getLongitude().isEmpty())
				param += " or longitude='"+bean.getLongitude()+"'";
			
			if(bean.getMonthlyIncome() != null)
				param += " or monthlyIncome="+bean.getMonthlyIncome();
			
			if(bean.getExperienced() != null)
				param += " or experienced="+bean.getExperienced();
			
			String sql = "select name,age,latitude,longitude,monthlyIncome,experienced,score from tb_person where 1=1 and (score between 0 and 1)"+param+" order by score desc,name";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			for (Map<String, Object> row : rows) 
			{
				PersonModelBean person = new PersonModelBean();
				person.setName((String) row.get("name"));
				person.setAge((Integer) row.get("age"));
				person.setLatitude((String) row.get("latitude"));
				person.setLongitude((String) row.get("longitude"));
				person.setMonthlyIncome((Integer) row.get("monthlyIncome"));
				int exp = (Integer) row.get("experienced");
				if(exp == 1)
					person.setExperienced(true);
				else
					person.setExperienced(false);
				
				person.setScore((Double) row.get("score"));

				persons.add(person);
			}
			result.setPeopleLikeYou(persons);
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
	
}
