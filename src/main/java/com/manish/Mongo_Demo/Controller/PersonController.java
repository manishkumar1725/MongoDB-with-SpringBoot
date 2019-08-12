package com.manish.Mongo_Demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manish.Mongo_Demo.Model.Person;
import com.manish.Mongo_Demo.Service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping(value = "/getPersonInfo/{id}")
	public Optional<Person> getPerson(@PathVariable int id) {
		return personService.getPersonInfo(id);
	}

	@GetMapping(value = "/getAllPersonInfo")
	public List<Person> getAllPerson() {
		return personService.getAllPersonInfo();
	}

	@GetMapping(value = "/getPersonByCity/{city}")
	public List<Person> getPersonByCity(@PathVariable String city) {
		return personService.findByCity(city);
	}

	@PostMapping(value = "/addPersonInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addPerson(@RequestBody Person person) {
		personService.addPersonInfo(person);
	}

	@PutMapping(value = "/updatePersonInfo/{id}")
	public Person updatePerson(@PathVariable int id, @RequestBody Person person) {

		return personService.updatePersonInfo(id, person);
	}

	@DeleteMapping(value = "/deletePersonInfo/{id}")
	public String deletPerson(@PathVariable int id) {
		return personService.deletePersonInfo(id);
	}

}
