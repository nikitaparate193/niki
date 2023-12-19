package com.example.blogging.Blogging.Platform.API.repository;

import com.example.blogging.Blogging.Platform.API.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends JpaRepository<Comment,Long> {
}
