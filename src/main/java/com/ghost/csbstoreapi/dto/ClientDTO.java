package com.ghost.csbstoreapi.dto;

import com.ghost.csbstoreapi.models.user.Client;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Required field")
    @Length(min = 5, max = 120, message = "The field must have a minimum of 5 and a maximum of 80 characters")
    private String name;

    @NotEmpty(message = "Required field")
    @Email(message = "Invalid email")
    private String email;

    public ClientDTO(){}

    public ClientDTO(Client obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
