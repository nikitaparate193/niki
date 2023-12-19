package com.example.blogging.Blogging.Platform.API.repository;

import com.example.blogging.Blogging.Platform.API.model.AuthenticationToken;
import com.example.blogging.Blogging.Platform.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);


    AuthenticationToken findFirstByUser(User user);
}
