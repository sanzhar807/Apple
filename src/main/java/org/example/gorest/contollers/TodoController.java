package org.example.gorest.contollers;

import io.qameta.allure.Step;
import org.example.gorest.HttpRequest;
import org.example.gorest.endPoint.EndPoint;
import org.example.gorest.models.Todo;


public class TodoController extends HttpRequest {

    public TodoController(String url) {
        super(url);
    }

    @Step("Create user to do")
    public Todo createUserTodo(Integer userId, Todo todo) {
        super.post(
                getEndPoint(EndPoint.PUBLIC, EndPoint.v2, EndPoint.USERS,
                        String.valueOf(userId), EndPoint.TODOS),
                todo.toJson()
        );
        if (this.response.getStatusCode() == 201) {
            return this.response.as(Todo.class);
        }
        return null;
    }
}