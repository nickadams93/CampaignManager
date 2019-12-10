package uno.csci.CampaignManagerAPI.utils;

import uno.csci.CampaignManagerAPI.model.Campaign;
import uno.csci.CampaignManagerAPI.model.CampaignResponse;
import uno.csci.CampaignManagerAPI.model.User;
import uno.csci.CampaignManagerAPI.model.UserSummary;

public class ModelMapper {
    public static CampaignResponse mapCampaignToCampaignResponse(Campaign campaign, User creator) {
        CampaignResponse campaignResponse = new CampaignResponse();
        campaignResponse.setId(campaign.getId());
        campaignResponse.setCharacters(campaign.getPlayers());
        campaignResponse.setDungeonMaster(creator);
        UserSummary creatorSummary = new UserSummary(creator.getId(), creator.getUsername(), creator.getName());
        campaignResponse.setCreatedBy(creatorSummary);

        return campaignResponse;
    }

}
