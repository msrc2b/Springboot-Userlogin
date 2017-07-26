package ravi.examples.mongospring.app;

import ravi.examples.mongospring.domain.Person;
import ravi.examples.mongospring.resources.PersonResource;
import ravi.examples.mongospring.service.IPersonService;
import ravi.examples.mongospring.service.PersonService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ravi
 *
 */
@RestController
@Component
public class PersonController
{
    private IPersonService personService;

    /**
     * @param personService
     */
    @Autowired
    PersonController(
        final PersonService personService)
    {
        this.personService = personService;
    }

    /**
     * @return
     */
    @RequestMapping("/details")
    public List<Person> findAll()
    {
        return personService.findAll();
    }
    
    /**
     * @return
     */
    @RequestMapping("/details/")
    public Person findByusername(@RequestParam(value = "username") final String username)
    {
        return personService.findByusername(username);
    }

    @RequestMapping(value = "/savedetails", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody final Person person)
    {
        Person savedPerson = personService.save(person);
        HttpHeaders httpHeaders = new HttpHeaders();
        
        Link forOnePerson = new PersonResource(savedPerson).getLink("self");
        httpHeaders.setLocation(URI.create(forOnePerson.getHref()));
        


        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }
}