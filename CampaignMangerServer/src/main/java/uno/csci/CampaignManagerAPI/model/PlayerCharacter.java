package uno.csci.CampaignManagerAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerCharacter {
    @GeneratedValue
    @Id
    private long id;
    @ManyToOne
    private Campaign campaign;
    private String name;
    private int level;
    private int experience;
    private String race;
    private String vocation;
    private String notes;
}
