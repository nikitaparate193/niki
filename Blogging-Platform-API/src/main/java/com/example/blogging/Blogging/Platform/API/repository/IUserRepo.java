package com.example.blogging.Blogging.Platform.API.repository;

import com.example.blogging.Blogging.Platform.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,Long> {
    User findFirstByUserEmail(String newEmail);
}
