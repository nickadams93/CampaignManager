package uno.csci.CampaignManagerAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uno.csci.CampaignManagerAPI.model.PlayerCharacter;

public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, Long> {
}
