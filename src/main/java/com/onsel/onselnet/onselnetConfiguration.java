package com.onsel.onselnet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class onselnetConfiguration {
	@Autowired
	private onselnetProperties onselnetproperties;
	
	@PostConstruct
	public void init() {
		System.out.println("Display owners with onsel :" + onselnetproperties.isDisplayOwnersWithPets());
	}
	
}