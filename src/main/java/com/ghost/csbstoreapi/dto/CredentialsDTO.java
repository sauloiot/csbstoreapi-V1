package com.ghost.csbstoreapi.dto;

public class CredentialsDTO {
    private static final long serialVersionUID = 1L;

    private String email;
    private String password;

    public CredentialsDTO() {
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
