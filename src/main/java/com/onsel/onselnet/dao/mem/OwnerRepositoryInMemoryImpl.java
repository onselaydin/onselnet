package com.onsel.onselnet.dao.mem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.onsel.onselnet.dao.OwnerRepository;
import com.onsel.onselnet.model.Owner;

@Repository
public class OwnerRepositoryInMemoryImpl implements OwnerRepository {

	private Map<Long, Owner> ownersMap = new HashMap<>();
	
	public OwnerRepositoryInMemoryImpl() {
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Hakan");
		owner1.setLastName("YÜCEL");
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Ahmet");
		owner2.setLastName("GÖKTAŞ");
		
		Owner owner3 = new Owner();
		owner3.setId(3L);
		owner3.setFirstName("Murat");
		owner3.setLastName("ŞENCAN");
		
		Owner owner4 = new Owner();
		owner4.setId(4L);
		owner4.setFirstName("Sinem");
		owner4.setLastName("BAHAR");

		ownersMap.put(owner1.getId(), owner1);
		ownersMap.put(owner2.getId(), owner2);
		ownersMap.put(owner3.getId(), owner3);
		ownersMap.put(owner4.getId(), owner4);
	}
	
	@Override
	public List<Owner> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(ownersMap.values());
	}

	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		return ownersMap.get(id);
	}

	@Override
	public List<Owner> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return ownersMap.values().stream().filter(o->o.getLastName().equals(lastName)).collect(Collectors.toList());
	}

	@Override
	public void create(Owner owner) {
		// TODO Auto-generated method stub
		owner.setId(new Date().getTime());
		ownersMap.put(owner.getId(),owner);

	}

	@Override
	public Owner update(Owner owner) {
		// TODO Auto-generated method stub
		ownersMap.replace(owner.getId(), owner);
		return owner;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ownersMap.remove(id);
	}

}
