package said.team.lead.broken_dude.services;

import org.springframework.stereotype.Service;
import said.team.lead.broken_dude.modules.Business;
import said.team.lead.broken_dude.modules.Person;
import said.team.lead.broken_dude.repos.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findOne(int id) {
        return personRepository.findById(id);
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
    }

    public void collectIncome(int personId) {
        Person person = personRepository.findById(personId)
        .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

       Business business = person.getBusiness();

       int totalIncome = 0;
       if(business != null) {
           totalIncome = business.getIncome();
       }
        person.setMoney(person.getMoney() + totalIncome);
        personRepository.save(person);
    }

}
