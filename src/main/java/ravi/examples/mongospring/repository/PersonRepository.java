package ravi.examples.mongospring.repository;

import ravi.examples.mongospring.domain.Person;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String>
{
    public Person findByusername(String username);
    public List<Person> findBypassword(String password);
    
}