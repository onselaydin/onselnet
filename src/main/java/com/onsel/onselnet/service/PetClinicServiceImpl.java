package com.onsel.onselnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.onsel.onselnet.dao.OwnerRepository;
import com.onsel.onselnet.dao.PetRepository;
import com.onsel.onselnet.exception.OwnerNotFoundException;
import com.onsel.onselnet.model.Owner;

@Service
@Transactional(rollbackFor=Exception.class)
public class PetClinicServiceImpl implements PetClinicService {

	private OwnerRepository ownerRepository;
	private PetRepository petRepository;
	
	@Autowired
	public void setOwnerRepository(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}
	@Autowired
	public void setPetRepository(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Owner> findOwners() {
		// TODO Auto-generated method stub
		return ownerRepository.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Owner> findOwners(String lastname) {
		// TODO Auto-generated method stub
		return ownerRepository.findByLastName(lastname);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Owner findOwner(Long id) throws OwnerNotFoundException {
		// TODO Auto-generated method stub
		Owner owner = ownerRepository.findById(id);
		if(owner == null) throw new OwnerNotFoundException("Owner not found with id :" + id);
		return owner;
	}
	
	

	@Override
	public void createOwner(Owner owner) {
		// TODO Auto-generated method stub
		ownerRepository.create(owner);
	}

	@Override
	public void update(Owner owner) {
		// TODO Auto-generated method stub
		ownerRepository.update(owner);
	}

	@Override
	public void deleteOwner(Long id) {
		// TODO Auto-generated method stub
		petRepository.deleteByOwnerId(id);
		ownerRepository.delete(id);
		//if(true) throw new RuntimeException("testing rollback");
	}

}
