package com.example.blogging.Blogging.Platform.API.service;

import com.example.blogging.Blogging.Platform.API.model.Post;
import com.example.blogging.Blogging.Platform.API.model.User;
import com.example.blogging.Blogging.Platform.API.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;

    public String createBlogPost(Post post) {
        postRepo.save(post);
        return "Post uploaded !!!";
    }

    public String removeBlogPost(Long postId, User user) {

        Post post  = postRepo.findById(postId).orElse(null);
        if(post != null && post.getPostOwner().equals(user))
        {
            postRepo.deleteById(postId);
            return "Removed successfully";
        }
        else if (post == null)
        {
            return "Post to be deleted does not exist";
        }
        else{
            return "Un-Authorized delete detected....Not allowed";
        }
    }

    public boolean validatePost(Post blogPost) {
        return (blogPost!=null && postRepo.existsById(blogPost.getPostId()));
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }


    public Optional<Post> getPostById(Long postId) {
        return postRepo.findById(postId);
    }
}
