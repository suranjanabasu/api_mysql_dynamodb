package com.springjwt.apijwt.pojo;

import javax.validation.constraints.NotBlank;

public class UserInfo {

    private String firstname;
    private String lastname;
    private String email;
    private String accessToken;
    @NotBlank(message = "MageId is mandatory")
    private String mageId;

    public UserInfo(@NotBlank(message = "MageId is mandatory") String mageId) {
        this.mageId = mageId;
    }

    public UserInfo() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getMageId() {
        return mageId;
    }

    public void setMageId(String mageId) {
        this.mageId = mageId;
    }
}
