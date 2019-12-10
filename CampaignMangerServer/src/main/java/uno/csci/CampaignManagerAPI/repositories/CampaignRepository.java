package uno.csci.CampaignManagerAPI.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import uno.csci.CampaignManagerAPI.model.Campaign;

import java.util.List;
import java.util.Optional;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    Optional<Campaign> findById(Long campaignId);

    Page<Campaign> findByCreatedBy(Long userId, Pageable pageable);

}
