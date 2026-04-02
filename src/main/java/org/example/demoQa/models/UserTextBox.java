package org.example.demoQa.models;

import java.util.Objects;

public class UserTextBox {

    private String userName;
    private String userEmail;
    private String userCurrentAddress;
    private String userPermanentAddress;

    public UserTextBox(String userName, String userEmail, String userCurrentAddress, String userPermanentAddress) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userCurrentAddress = userCurrentAddress;
        this.userPermanentAddress = userPermanentAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCurrentAddress() {
        return userCurrentAddress;
    }

    public void setUserCurrentAddress(String userCurrentAddress) {
        this.userCurrentAddress = userCurrentAddress;
    }

    public String getUserPermanentAddress() {
        return userPermanentAddress;
    }

    public void setUserPermanentAddress(String userPermanentAddress) {
        this.userPermanentAddress = userPermanentAddress;
    }

    @Override
    public String toString() {
        return "UserTextBox{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userCurrentAddress='" + userCurrentAddress + '\'' +
                ", userPermanentAddress='" + userPermanentAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserTextBox that = (UserTextBox) o;
        return Objects.equals(userName, that.userName) && Objects.equals(userEmail, that.userEmail) && Objects.equals(userCurrentAddress, that.userCurrentAddress) && Objects.equals(userPermanentAddress, that.userPermanentAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userEmail, userCurrentAddress, userPermanentAddress);
    }
}
