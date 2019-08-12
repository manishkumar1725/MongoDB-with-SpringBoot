package com.manish.Mongo_Demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.Mongo_Demo.Model.Person;
import com.manish.Mongo_Demo.Repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person addPersonInfo(Person person) {
		return personRepository.save(person);
	}

	public Optional<Person> getPersonInfo(int id) {
		return personRepository.findById(id);
	}

	public List<Person> getAllPersonInfo() {
		return personRepository.findAll();
	}

	public String deletePersonInfo(int id) {
		if (personRepository.existsById(id) == false) {
			return "ID NOT FOUND";
		} else {
			personRepository.deleteById(id);
		return "DELETED";
	}
	}
	public Person updatePersonInfo(int id, Person person) {

		person.setId(id);
		personRepository.save(person);
		return person;

	}

	public List<Person> findByCity(String city) {

		List<Person> person = personRepository.findByCity(city);
		return person;

	}

}
