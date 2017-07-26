package ravi.examples.mongospring.service;

import ravi.examples.mongospring.domain.Person;
import ravi.examples.mongospring.repository.PersonRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ravi
 *
 */
@Component
@Transactional
public class PersonService implements IPersonService
{
    private PersonRepository personRepository;
    
    @Autowired
    public PersonService(final PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }


    @Override
    public List<Person> findAll()
    {
        return personRepository.findAll();
    }

    @Override
    public Person save(final Person person)
    {
        return personRepository.save(person);
    }
    @Override
    public Person findByusername(String username) {
        return personRepository.findByusername(username);
    }

   
    

}
