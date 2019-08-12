package com.manish.Mongo_Demo.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.manish.Mongo_Demo.Model.Person;
import com.manish.Mongo_Demo.Repository.PersonRepository;
import com.manish.Mongo_Demo.Service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

	@Autowired
	private PersonService personService;

	@MockBean
	private PersonRepository personRepository;

	Person person1 = new Person(1, "Manish", "Mumbai", "7001322721");
	Person person2 = new Person(2, "Manish Kumar", "Navi Mumbai", "7001322722");

	@Test
	public void testAddPersonInfo() {

		Mockito.when(personRepository.save(person1)).thenReturn(person1);

		assertThat(personService.addPersonInfo(person1)).isEqualTo(person1);
	}

	@Test
	public void testGetPersonInfo() {

		Mockito.when(personRepository.findById(1)).thenReturn(Optional.of(person1));

		assertThat(personService.getPersonInfo(1)).isEqualTo(Optional.of(person1));
	}

	@Test
	public void testGetAllPersonInfo() {

		List<Person> personInfo = new ArrayList<>();

		personInfo.add(person1);
		personInfo.add(person2);

		Mockito.when(personRepository.findAll()).thenReturn(personInfo);

		assertThat(personService.getAllPersonInfo()).isEqualTo(personInfo);
	}

	@Test
	public void testDeletePersonInfo() {


        
       // personService.deletePersonInfo(person1.getId());

        
       // verify(personRepository, times(1)).deleteById.(ArgumentCaptor<T>));

		
	}

	@Test
	public void testUpdatePersonInfo() {

		Mockito.when(personRepository.findById(1)).thenReturn(Optional.of(person1));

		person1.setName("Kumar Manish");

		Mockito.when(personRepository.save(person1)).thenReturn(person1);

		assertThat(personService.updatePersonInfo(1, person1)).isEqualTo(person1);

	}

	@Test
	public void testFindByCity() {

		List<Person> personInfo = new ArrayList<>();

		personInfo.add(person1);
		personInfo.add(person2);

		Mockito.when(personRepository.findByCity("Mumbai")).thenReturn(personInfo);

		assertThat(personService.findByCity("Mumbai")).isEqualTo(personInfo);
	}

}
