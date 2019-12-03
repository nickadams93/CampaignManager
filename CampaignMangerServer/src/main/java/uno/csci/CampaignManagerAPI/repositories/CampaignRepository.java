package uno.csci.CampaignManagerAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uno.csci.CampaignManagerAPI.model.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
