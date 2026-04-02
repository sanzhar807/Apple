package org.example.gorest.contollers;

import io.qameta.allure.Step;
import org.example.gorest.HttpRequest;
import org.example.gorest.JsonUtils;
import org.example.gorest.endPoint.EndPoint;
import org.example.gorest.models.Comment;
import org.example.gorest.models.Post;


import java.util.Arrays;
import java.util.List;

public class PostController extends HttpRequest {

    public PostController(String url) {
        super(url);
    }

    @Step("Get all posts")
    public List<Post> getAllPosts() {
        return Arrays.asList(
                super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.v2, EndPoint.POSTS))
                        .as(Post[].class)
        );
    }

    @Step("Get post by user")
    public List<Post> getPostsByUser(Integer userId) {
        return Arrays.asList(
                super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.v2, EndPoint.USERS,
                                String.valueOf(userId), EndPoint.POSTS))
                        .as(Post[].class)
        );
    }

    @Step("Get post")
    public Post getPost(Integer postId) {
        return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.v2, EndPoint.POSTS,
                        String.valueOf(postId)))
                .as(Post.class);
    }

    @Step("Create a user post")
    public Post createUserPost(Integer userId, Post post) {
        super.post(
                getEndPoint(EndPoint.PUBLIC, EndPoint.v2, EndPoint.USERS,
                        String.valueOf(userId), EndPoint.POSTS),
                post.toJson()
        );
        if (this.response.getStatusCode() == 201) {
            return this.response.as(Post.class);
        }
        return null;
    }

    @Step("Create a post comment")
    public Comment createPostComment(Integer postId, Comment comment) {
        super.post(
                getEndPoint(EndPoint.PUBLIC, EndPoint.v2, EndPoint.POSTS,
                        String.valueOf(postId), EndPoint.COMMENTS),
                JsonUtils.toJson(comment)
        );
        if (this.response.getStatusCode() == 201) {
            return this.response.as(Comment.class);
        }
        return null;
    }
}
