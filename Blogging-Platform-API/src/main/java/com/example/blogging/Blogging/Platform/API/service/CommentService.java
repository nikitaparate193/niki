package com.example.blogging.Blogging.Platform.API.service;

import com.example.blogging.Blogging.Platform.API.model.Comment;
import com.example.blogging.Blogging.Platform.API.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    ICommentRepo commentRepo;

    public String addComment(Comment comment) {
        commentRepo.save(comment);
        return "Comment has been added!!!";
    }

    public Comment findComment(Long commentId) {
        return  commentRepo.findById(commentId).orElse(null);
    }

    public void removeComment(Comment comment) {
        commentRepo.delete(comment);
    }
}
