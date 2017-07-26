package ravi.examples.mongospring.app;

import ravi.examples.mongospring.domain.Person;
import ravi.examples.mongospring.repository.PersonRepository;
import ravi.examples.mongospring.service.PersonService;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @Mock
    private PersonRepository mockPersonRepository;
    private PersonController personController;

    private Person person1 = new Person();

    @Before
    public void setup() {
        setupPerson();
        when(mockPersonRepository.findAll()).thenReturn(Arrays.asList(person1));
        PersonService personService = new PersonService(mockPersonRepository);

        personController = new PersonController(personService);
    }

    @Test
    public void findAllTest() {
        List<Person> allPersons = personController.findAll();

        assertEquals(1, allPersons.size());

        Person actualPerson = allPersons.get(0);
        assertEquals("German", actualPerson.getusername());
        assertEquals("Password", actualPerson.getpassword());
        
    }

    private void setupPerson(){
        person1.setusername("German");
        person1.setpassword("Password");
       
    }
}
