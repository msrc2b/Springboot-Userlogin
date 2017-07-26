package ravi.examples.mongospring.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import ravi.examples.mongospring.app.PersonController;
import ravi.examples.mongospring.domain.Person;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class PersonResource extends ResourceSupport {

    private final Person person;
    
    public PersonResource(final Person person) {
        this.person = person;
        this.add(new Link("htgd", "person-link"));
        this.add(linkTo(PersonController.class).withRel("bookmarks"));
        this.add(linkTo(methodOn(PersonController.class).findByusername(person.getusername())).withSelfRel());
        
    }
    
    public Person getPerson(){
        return person;
    }
}
