package org.example.gorest.contollers;


import io.qameta.allure.Step;
import org.example.gorest.HttpRequest;
import org.example.gorest.endPoint.EndPoint;
import org.example.gorest.models.Users;


public class UserController extends HttpRequest {
    private static final String Slash = "/";

    public UserController(String url) {
        super(url);
    }

    @Step("Get all users")
    public Users[] getAllUsers(){
        return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.v2,EndPoint.USERS)).as(Users[].class);
    }

    @Step("Get user")
    public Users getUser(Integer id) {
        super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.v2, EndPoint.USERS, String.valueOf(id)));
        if (this.response.getStatusCode() == 200) {
            return this.response.as(Users.class);
        }
        return null;
    }

    @Step("Create new user")
    public Users createNewUser(Users user) {
        super.post(
                getEndPoint(EndPoint.PUBLIC, EndPoint.v2, EndPoint.USERS),
                user.toJson());
        if (this.response.getStatusCode() == 201) {
            return this.response.as(Users.class);
        }
        return null;
    }

    @Step("Update user")
    public Users updateUser(Integer id, Users user) {
        super.put(
                getEndPoint(EndPoint.PUBLIC, EndPoint.v2, EndPoint.USERS, String.valueOf(id)),
                user.toJson()
        );
        if (this.response.getStatusCode() == 200) {
            return this.response.as(Users.class);
        }
        return null;
    }

    @Step("Partial update user")
    public Users patchUser(Integer id, Users user) {
        super.patch(
                getEndPoint(EndPoint.PUBLIC, EndPoint.v2, EndPoint.USERS, String.valueOf(id)),
                user.toJson()
        );
        if (this.response.getStatusCode() == 200) {
            return this.response.as(Users.class);
        }
        return null;
    }

    @Step("Delete user")
    public int deleteUser(Integer id) {
        return super.delete(
                getEndPoint(EndPoint.PUBLIC, EndPoint.v2, EndPoint.USERS, String.valueOf(id))
        ).getStatusCode();
    }
}
