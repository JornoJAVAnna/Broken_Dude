package said.team.lead.broken_dude.controllers;

import org.springframework.web.bind.annotation.*;
import said.team.lead.broken_dude.dto.BusinessDTO;
import said.team.lead.broken_dude.modules.Business;
import said.team.lead.broken_dude.modules.Person;
import said.team.lead.broken_dude.repos.PersonRepository;
import said.team.lead.broken_dude.services.BusinessService;
import said.team.lead.broken_dude.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

    private final BusinessService businessService;
    private final PersonService personService;

    public BusinessController(BusinessService businessService, PersonService personService) {
        this.businessService = businessService;
        this.personService = personService;
    }

    @GetMapping
    public List<Business> getAllBusinesses() {
        return businessService.getAllBusinesses();
    }

    @GetMapping("/{id}")
    public Business getBussinessById(@PathVariable int id) {
        return businessService.getBusinessById(id);
    }

    @PostMapping("/create")
    public void addBusiness(@RequestBody BusinessDTO dto) {
        businessService.addBusiness(dto);
    }
}
