package com.spp.gym_network.mainservice.email.context;

import com.spp.gym_network.mainservice.domain.user.UserEntity;
import org.springframework.web.util.UriComponentsBuilder;

public class AccountVerificationEmailContext extends AbstractEmailContext {

    private String token;


    @Override
    public <T> void init(final T context) {
        //we can do any common configuration setup here
        // like setting up some base URL and context
        UserEntity user = (UserEntity) context; // we pass the user information
        put("firstName", user.getFirstName());
        setTemplateLocation("email-verification");
        setSubject("Complete your registration");
        setFrom("testhw3@outlook.com");
        setTo(user.getEmail());
    }

    public void setToken(String token) {
        this.token = token;
        put("token", token);
    }

    public void buildVerificationUrl(final String baseURL, final String token){
        final String url= UriComponentsBuilder.fromHttpUrl(baseURL)
                .path("api/auth/verify").queryParam("token", token).toUriString();
        put("verificationURL", url);
    }
}
