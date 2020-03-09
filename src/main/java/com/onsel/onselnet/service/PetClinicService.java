package com.onsel.onselnet.service;

import java.util.List;

import com.onsel.onselnet.exception.OwnerNotFoundException;
import com.onsel.onselnet.model.Owner;

public interface PetClinicService {

	List<Owner> findOwners();
	List<Owner> findOwners(String lastname);
	Owner findOwner(Long id) throws OwnerNotFoundException;
	
	void createOwner(Owner owner);
	void update(Owner owner);
	void deleteOwner(Long id);
	
}
