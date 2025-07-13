package said.team.lead.broken_dude.modules;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "business")
@Setter
@Getter
@NoArgsConstructor
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "income")
    private int income;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Person owner;


    public Business(String title, int income, Person owner) {
        this.title = title;
        this.income = income;
        this.owner = owner;
    }
}
