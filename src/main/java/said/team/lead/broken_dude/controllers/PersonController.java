package said.team.lead.broken_dude.controllers;

import org.springframework.web.bind.annotation.*;
import said.team.lead.broken_dude.modules.Person;
import said.team.lead.broken_dude.services.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable int id) {
        return personService.findOne(id);
    }

    @PostMapping("/create")
    public void addPerson(@RequestBody Person person) {
        personService.save(person);
    }

    @PutMapping("/{id}")
    public void updatedPerson(@PathVariable int id, @RequestBody Person updatedPerson) {
        personService.update(id, updatedPerson);
    }
}
