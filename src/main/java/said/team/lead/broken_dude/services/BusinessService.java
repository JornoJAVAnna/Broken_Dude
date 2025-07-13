package said.team.lead.broken_dude.services;

import org.springframework.stereotype.Service;
import said.team.lead.broken_dude.dto.BusinessDTO;
import said.team.lead.broken_dude.modules.Business;
import said.team.lead.broken_dude.modules.Person;
import said.team.lead.broken_dude.repos.BusinessRepository;
import said.team.lead.broken_dude.repos.PersonRepository;

import java.util.List;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final PersonRepository personRepository;

    public BusinessService(BusinessRepository businessRepository, PersonRepository personRepository) {
        this.businessRepository = businessRepository;
        this.personRepository = personRepository;
    }

    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    public Business getBusinessById(int id) {
        return businessRepository.findById(id).orElse(null);
    }

    public void addBusiness(BusinessDTO dto) {
        Person owner = personRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        Business business = new Business();
        business.setTitle(dto.getTitle());
        business.setIncome(dto.getIncome());
        business.setOwner(owner);

        businessRepository.save(business);
    }
}
