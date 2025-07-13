package said.team.lead.broken_dude.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import said.team.lead.broken_dude.modules.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
