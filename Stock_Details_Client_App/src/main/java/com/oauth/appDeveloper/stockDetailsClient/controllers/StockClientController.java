package com.oauth.appDeveloper.stockDetailsClient.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;


@RestController
@CrossOrigin
@Slf4j
public class StockClientController {

    @Autowired
    OAuth2AuthorizedClientService oauth2ClientService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/albums")
    public String getAlbums(Model model,
                            @AuthenticationPrincipal OidcUser principal) {
        log.info("Principal {}",principal);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        OAuth2AuthorizedClient oauth2Client = oauth2ClientService.
                loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(),
                oauthToken.getName());
        String jwtAccessToken = oauth2Client.getAccessToken().getTokenValue();
        log.info("jwtAccessToken =-- {} ",jwtAccessToken);
        OidcIdToken idToken = principal.getIdToken();
        String idTokenValue = idToken.getTokenValue();
        log.info("idTokenValue--{}", idTokenValue);
        String url = "http://localhost:8180/realms/appDeveloper/protocol/openid-connect/userinfo";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwtAccessToken);
        HttpEntity entity = new HttpEntity<>(headers);
        ResponseEntity responseEntity =  restTemplate.exchange(url, HttpMethod.GET, entity,
                new ParameterizedTypeReference<String>() {});
        log.info("The Response Entity---{}",responseEntity.getBody());
        model.addAttribute("albums", responseEntity.getBody());
        return "albums";
    }

    @GetMapping("/userDetails")
    public String fetchUserDetails( @AuthenticationPrincipal OidcUser principal){
        log.info("Principal {}",principal);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        OAuth2AuthorizedClient oauth2Client = oauth2ClientService.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(),
                oauthToken.getName());
        String jwtAccessToken = oauth2Client.getAccessToken().getTokenValue();
        log.info("jwtAccessToken =-- {} ",jwtAccessToken);
        OidcIdToken idToken = principal.getIdToken();
        String idTokenValue = idToken.getTokenValue();
        log.info("idTokenValue--{}", idTokenValue);
        String url = "http://localhost:8180/realms/appDeveloper/protocol/openid-connect/userinfo";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwtAccessToken);
        HttpEntity entity = new HttpEntity<>(headers);
        ResponseEntity responseEntity =  restTemplate.exchange(url, HttpMethod.GET, entity,
                new ParameterizedTypeReference<String>() {});
        log.info("The Response Entity---{}",responseEntity.getBody());
        return responseEntity.getBody().toString();
    }
}
