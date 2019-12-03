package uno.csci.CampaignManagerAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {
    @GeneratedValue
    @Id
    private long id;
    private String name;
    private String description;
    @ManyToMany
    private List<User> players;
    @ManyToOne
    private User dm;

}
