package com.tcs.country.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {
    @Id
    @Column(name="code")
    private Integer code;
    @Column(name="name")
    private String name;

    public Country(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Country() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format("Code: {0}/t Name: {1}/n",code,name);
    }
}
