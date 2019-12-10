package uno.csci.CampaignManagerAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uno.csci.CampaignManagerAPI.model.*;
import uno.csci.CampaignManagerAPI.repositories.CampaignRepository;
import uno.csci.CampaignManagerAPI.repositories.UserRepository;
import uno.csci.CampaignManagerAPI.security.UserPrincipal;
import uno.csci.CampaignManagerAPI.utils.ModelMapper;

import java.util.Collections;
import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private UserRepository userRepository;

    public PagedResponse<CampaignResponse> getCampaignsCreatedBy(String username, UserPrincipal currentUser, int page, int size) {
        validatePageNumberAndSize(page, size);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException());

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");

        Page<Campaign> campaigns = campaignRepository.findByCreatedBy(user.getId(), pageable);

        if (campaigns.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), campaigns.getNumber(),
                    campaigns.getSize(), campaigns.getTotalElements(), campaigns.getTotalPages(), campaigns.isLast());
        }

        List<Long> campaignIds = campaigns.map(Campaign::getId).getContent();

        List<CampaignResponse> campaignResponses = campaigns.map(
                campaign -> {
                    return ModelMapper.mapCampaignToCampaignResponse(campaign,
                            user);
                }
        ).getContent();

        return new PagedResponse<CampaignResponse>(campaignResponses, campaigns.getNumber(), campaigns.getSize(), campaigns.getTotalElements(),
                campaigns.getTotalPages(), campaigns.isLast());
    }

    private void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > 20) {
            throw new BadRequestException("Page size must not be greater than " + 20);
        }
    }
}
