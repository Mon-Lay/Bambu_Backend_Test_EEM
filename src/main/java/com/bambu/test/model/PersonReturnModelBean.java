package com.bambu.test.model;

import java.util.ArrayList;

public class PersonReturnModelBean {

	private ArrayList<PersonModelBean> peopleLikeYou;
	
	public PersonReturnModelBean() {

    }

	public ArrayList<PersonModelBean> getPeopleLikeYou() {
		return peopleLikeYou;
	}

	public void setPeopleLikeYou(ArrayList<PersonModelBean> peopleLikeYou) {
		this.peopleLikeYou = peopleLikeYou;
	}
	
}
