package ravi.examples.mongospring.service;

import ravi.examples.mongospring.domain.Person;

import java.util.List;

/**
 * @author ravi
 *
 */
public interface IPersonService
{
    List<Person> findAll();
    
    Person findByusername(String username);
    
    Person save(Person person);
}
