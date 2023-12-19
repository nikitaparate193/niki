package com.example.blogging.Blogging.Platform.API.controller;

import com.example.blogging.Blogging.Platform.API.model.*;
import com.example.blogging.Blogging.Platform.API.model.dto.SignInInput;
import com.example.blogging.Blogging.Platform.API.model.dto.SignUpOutput;
import com.example.blogging.Blogging.Platform.API.service.AuthenticationService;
import com.example.blogging.Blogging.Platform.API.service.PostService;
import com.example.blogging.Blogging.Platform.API.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    PostService postService;

    @PostMapping("user/signup")
    public SignUpOutput signUpBlogUser(@RequestBody User user){
        return userService.signUpBlogUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInBlogUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.sigInBlogUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String signOutBlogUser(String email, String token){
        if(authenticationService.authenticate(email, token)){
            return userService.signOutBlogUser(email);
        }else{
            return "Sign out not allowed for non Authenticate user";
        }

    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    //Post

    @PostMapping("post")
    public String createBlogPost(@RequestBody Post post, @RequestParam String email, @RequestParam String token){
        if(authenticationService.authenticate(email,token)){
            return userService.createBlogPost(post,email);
        }else{
            return "Not an Authenticated user activity!!!";
        }
    }

    @PutMapping("user/post/{userId}")
    public Post updateBlogPost(@PathVariable Long userId, @RequestBody Post updatedPost)
    {
        return userService.updateBlogPost(userId,updatedPost);
    }

    @DeleteMapping("post")
    public String removeBlogPost(@RequestParam Long postId, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.removeBlogPost (postId,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    @GetMapping("posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("post/{postId}")
    public Optional<Post> getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    //comment
    @PostMapping("comment")
    public String addComment(@RequestBody Comment comment, @RequestParam String commenterEmail, @RequestParam String commenterToken)
    {
        if(authenticationService.authenticate(commenterEmail,commenterToken)) {
            return userService.addComment(comment,commenterEmail);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    @DeleteMapping("comment")
    public String removeBlogComment(@RequestParam Long commentId, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.removeBlogComment(commentId,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    //follow

    @PostMapping("follow")
    public String followUser(@RequestBody Follow follow, @RequestParam String followerEmail, @RequestParam String followerToken)
    {
        if(authenticationService.authenticate(followerEmail,followerToken)) {
            return userService.followUser(follow,followerEmail);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    @DeleteMapping("unfollow/target/{followId}")
    public String unFollowUser(@PathVariable Integer followId, @RequestParam String followerEmail, @RequestParam String followerToken){
        if(authenticationService.authenticate(followerEmail,followerToken)){
            return userService.unFollowUser(followId,followerEmail);
        }else{
            return " Not an Authenticated user activity";
        }
    }



}
