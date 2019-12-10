package uno.csci.CampaignManagerAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CampaignResponse {
    private Long id;
    private UserSummary createdBy;
    private List<PlayerCharacter> characters;
    private User dungeonMaster;
}
