package com.ghost.csbstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ghost.csbstoreapi.services.validation.ClientInsert;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClientInsert
public class ClientNewDTO  implements Serializable {
    private static final long serialVersionUID = 1L;


    //client
    @NotEmpty(message = "Required field")
    @Length(min = 5, max = 120, message = "The field must have a minimum of 5 and a maximum of 80 characters")
    private String name;
    @NotEmpty(message = "Required field")
    @Email(message = "Invalid email")
    private String email;
    @NotEmpty(message = "Required field")
    private String cpfOrCnpj;
    private Integer type;
    
    @NotEmpty(message = "Required field")
    private String password;

    //address
    @NotEmpty(message = "Required field")
    private String street;
    @NotEmpty(message = "Required field")
    private String number;
    private String complement;
    private String district;
    @NotEmpty(message = "Required field")
    private String cep;

    //phones
    @NotEmpty(message = "Required field")
    private String phone1;
    private String phone2;
    private String phone3;

    //city
    private Integer cityId;

    public ClientNewDTO() {
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

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
