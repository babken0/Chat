package com.example.chat;

public class User {

    private String name;
    private String email;
    private String id;
    private int avatarMockUpRecourse;

    public User(){
    }

    public User(String name, String email, String id, int avatarMockUpRecourse) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.avatarMockUpRecourse = avatarMockUpRecourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAvatarMockUpRecourse() {
        return avatarMockUpRecourse;
    }

    public void setAvatarMockUpRecourse(int avatarMockUpRecourse) {
        this.avatarMockUpRecourse = avatarMockUpRecourse;
    }
}
