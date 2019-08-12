package com.example.RestTemplate;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/rt/getPersonInfo/{id}")
	public PersonInfo getPersonInfo(@PathVariable int id) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PersonInfo> entity = new HttpEntity<PersonInfo>(headers);

		return restTemplate
				.exchange("http://localhost:8082/getPersonInfo/" + id, HttpMethod.GET, entity, PersonInfo.class)
				.getBody();
	}
	
	@GetMapping(value = "/rt/getPersonByCity/{city}")
	public PersonInfo getPersonByCity(@PathVariable String city) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<List<PersonInfo>> entity = new HttpEntity<List<PersonInfo>>(headers);

		return restTemplate
				.exchange("http://localhost:8082/getPersonByCity/" + city, HttpMethod.GET, entity,PersonInfo.class)
				.getBody();
	}
	
	@GetMapping(value = "/rt/getAllPersonInfo")
	public List<PersonInfo> getAllPersonInfo() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<List<PersonInfo>> entity = new HttpEntity<List<PersonInfo>>(headers);

		return restTemplate
				.exchange("http://localhost:8082/getAllPersonInfo", HttpMethod.GET, entity, new ParameterizedTypeReference<List<PersonInfo>>(){})
				.getBody();
		
		
		// The purpose of ParameterizedTypeReference class is to enable capturing and passing a generic Type. In order to capture the generic type and retain it at runtime, 
		// you need to create a subclass (ideally as anonymous inline class)
	}


	@PostMapping(value = "/rt/addPersonInfo")
	public PersonInfo addPersonInfo(@RequestBody PersonInfo personInfo) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PersonInfo> entity = new HttpEntity<PersonInfo>(personInfo, headers);

		return restTemplate.exchange("http://localhost:8082/addPersonInfo", HttpMethod.POST, entity, PersonInfo.class)
				.getBody();
	}

	@DeleteMapping(value = "/rt/deletePersonInfo/{id}")
	public PersonInfo deletePersonInfo(@PathVariable int id) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PersonInfo> entity = new HttpEntity<PersonInfo>(headers);

		return restTemplate
				.exchange("http://localhost:8082/deletePersonInfo/" + id, HttpMethod.DELETE, entity,PersonInfo.class)
				.getBody();

	}
	
	@PutMapping(value = "/rt/updatePersonInfo/{id}")
	public PersonInfo updatePersonInfo(@PathVariable int id,@RequestBody PersonInfo personInfo) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PersonInfo> entity = new HttpEntity<PersonInfo>(personInfo,headers);

		return restTemplate
				.exchange("http://localhost:8082/updatePersonInfo/" + id, HttpMethod.PUT, entity, PersonInfo.class)
				.getBody();

	}
	
}