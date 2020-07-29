package com.ghost.csbstoreapi.dto;

import com.ghost.csbstoreapi.models.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Required field")
    @Length(min = 5, max = 80, message = "The field must have a minimum of 5 and a maximum of 80 characters")
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category){
        id = category.getId();
        name = category.getName();
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
}
