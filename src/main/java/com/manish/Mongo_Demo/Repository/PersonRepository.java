package com.manish.Mongo_Demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.manish.Mongo_Demo.Model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person,Integer>{

	List<Person> findByCity(String city);
	
}
