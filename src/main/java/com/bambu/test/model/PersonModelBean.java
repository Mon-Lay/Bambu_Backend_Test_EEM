package com.bambu.test.model;

public class PersonModelBean {

	private String name;
	private Integer age;
	private String latitude;
	private String longitude;
	private Integer monthlyIncome;
	private Boolean experienced;
	private Double score;
	
	public PersonModelBean() {

    }

    public PersonModelBean(String name, Integer age, String latitude, String longitude, Integer monthlyIncome,Boolean experienced,Double score) {
    	this.name = name;
        this.age = age;
		this.latitude = latitude;
        this.longitude = longitude;
        this.monthlyIncome = monthlyIncome;
        this.experienced = experienced;
        this.score = score;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Integer getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(Integer monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public Boolean getExperienced() {
		return experienced;
	}

	public void setExperienced(Boolean experienced) {
		this.experienced = experienced;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}
