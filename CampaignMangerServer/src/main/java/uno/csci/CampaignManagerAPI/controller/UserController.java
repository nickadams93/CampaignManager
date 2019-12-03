package uno.csci.CampaignManagerAPI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uno.csci.CampaignManagerAPI.model.CurrentUser;
import uno.csci.CampaignManagerAPI.model.UserSummary;
import uno.csci.CampaignManagerAPI.repositories.UserRepository;
import uno.csci.CampaignManagerAPI.security.UserPrincipal;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public Boolean checkUsernameAvailability(@RequestParam(value = "username") String username) {
        return !userRepository.existsByUsername(username);
    }

    @GetMapping("/user/checkEmailAvailability")
    public Boolean checkEmailAvailability(@RequestParam(value = "email") String email) {
        return !userRepository.existsByEmail(email);
    }


}