package com.onsel.onselnet;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="onselnet")
public class onselnetProperties {

	 private boolean displayOwnersWithPets =false;
	 
	 public boolean isDisplayOwnersWithPets() {
		return displayOwnersWithPets;
	}
	 
	 public void setDisplayOwnersWithPets(boolean displayOwnersWithPets) {
		this.displayOwnersWithPets = displayOwnersWithPets;
	}
	 
	 
}
