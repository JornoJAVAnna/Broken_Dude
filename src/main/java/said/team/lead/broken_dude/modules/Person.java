package said.team.lead.broken_dude.modules;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "person")
@Setter
@Getter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "money")
    private int money;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Business> businesses;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }
}
