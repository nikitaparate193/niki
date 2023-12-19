package com.example.blogging.Blogging.Platform.API.repository;

import com.example.blogging.Blogging.Platform.API.model.Follow;
import com.example.blogging.Blogging.Platform.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFollowRepo extends JpaRepository<Follow,Integer> {
    List<Follow> findByCurrentUserAndCurrentUserFollower(User targetUser, User follower);
}
