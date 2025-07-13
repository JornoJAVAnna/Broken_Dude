package said.team.lead.broken_dude.services;

import org.springframework.stereotype.Service;
import said.team.lead.broken_dude.repos.BusinessRepository;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;

    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }
}
