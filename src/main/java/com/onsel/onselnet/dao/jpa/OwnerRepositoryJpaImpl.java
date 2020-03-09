package com.onsel.onselnet.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.onsel.onselnet.dao.OwnerRepository;
import com.onsel.onselnet.model.Owner;

@Repository("ownerRepository")
public class OwnerRepositoryJpaImpl implements OwnerRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Owner> findAll() {
		// TODO Auto-generated method stub
		//return null;
		return entityManager.createQuery("from Owner", Owner.class).getResultList();
	}

	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		//return null;
		return entityManager.find(Owner.class, id);
	}

	@Override
	public List<Owner> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		//return null;
		return entityManager.createQuery("from Owner where lastName = : lastName", Owner.class).setParameter("lastName", lastName).getResultList();
	}

	@Override
	public void create(Owner owner) {
		// TODO Auto-generated method stub
		entityManager.persist(owner);
	}

	@Override
	public Owner update(Owner owner) {
		// TODO Auto-generated method stub
		//return null;
		return entityManager.merge(owner);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.getReference(Owner.class, id));
	}

}
