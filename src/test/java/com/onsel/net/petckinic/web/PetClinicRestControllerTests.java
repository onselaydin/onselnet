package com.onsel.net.petckinic.web;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.onsel.onselnet.model.Owner;

public class PetClinicRestControllerTests {

	private RestTemplate restTemplate;
	
	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void testDeleteOwner()
	{
		restTemplate.delete("http://localhost:8080/rest/owner/1");
		try
		{
			restTemplate.getForEntity("http://localhost:8080/rest/owner/1", Owner.class);
			Assert.fail("should have not return owner");
		}
		catch(HttpClientErrorException ex) {
			MatcherAssert.assertThat(ex.getStatusCode().value(), Matchers.equalTo(404));	
			
		}
		catch(Exception ex) {
			Assert.fail(ex.toString());
		}
		
	}
	
	
	@Test
	public void testupdateOwner() {
		Owner owner = restTemplate.getForObject("http://localhost:8080/rest/owner/1", Owner.class);
		MatcherAssert.assertThat(owner.getFirstName(), Matchers.equalTo("Hakan"));
		
		owner.setFirstName("Hakan YUCEL");
		restTemplate.put("http://localhost:8080/rest/owner/1", owner);
		
		owner = restTemplate.getForObject("http://localhost:8080/rest/owner/1", Owner.class);
		MatcherAssert.assertThat(owner.getFirstName(), Matchers.equalTo("Hakan YUCEL"));
	}
	
	@Test
	public void testCreateOwner() {
		Owner owner = new Owner();
		owner.setFirstName("Önsel");
		owner.setLastName("AYDIN");
		
		URI location = restTemplate.postForLocation("http://localhost:8080/rest/owner", owner);
		
		Owner owner2 = restTemplate.getForObject(location, Owner.class);
//		
//		MatcherAssert.assertThat(owner2.getFirstName(), Matchers.equalTo(owner.getFirstName()));
//		MatcherAssert.assertThat(owner2.getLastName(), Matchers.equalTo(owner.getLastName()));
	}
	
	@Test
	public void testGetOwnerById() {
		//metodun üstüne sağ click run as junit test komutunu çalıştır....
		ResponseEntity<Owner> response = restTemplate.getForEntity("http://localhost:8080/rest/owner/1",Owner.class);
	    MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo("Yagmur"));
	}
	@Test
	public void testGetOwnersByLastName() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owner?ln=Aydın", List.class);
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		List<Map<String, String>> body = response.getBody();
		List<String> firstNames = body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Yagmur","Ahmet","Sinem"));
		
	}
	
	@Test
	public void testGetOwners() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owners", List.class);
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		List<Map<String,String>> body = response.getBody();
		List<String> firstNames = body.stream().map(e -> e.get("firstName")).collect(Collectors.toList());
		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Hakan","Ahmet","Cavit","Yagmur"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
