package uno.csci.CampaignManagerAPI.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CampaignRequest {
    @NotBlank
    private String title;

    @NotBlank
    @Size(max = 140)
    private String description;
}
