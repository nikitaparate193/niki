package com.example.blogging.Blogging.Platform.API.service;

import com.example.blogging.Blogging.Platform.API.model.AuthenticationToken;
import com.example.blogging.Blogging.Platform.API.model.User;
import com.example.blogging.Blogging.Platform.API.repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo authenticationRepo;

    public boolean authenticate(String email, String authTokenValue)
    {
        AuthenticationToken authToken = authenticationRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getUser().getUserEmail();

        return tokenConnectedEmail.equals(email);
    }

    public void saveAuthToken(AuthenticationToken authToken)
    {
        authenticationRepo.save(authToken);
    }


    public AuthenticationToken findFirstByUser(User user) {
        return authenticationRepo.findFirstByUser(user);
    }

    public void removeToken(AuthenticationToken token) {
        authenticationRepo.delete(token);
    }
}
