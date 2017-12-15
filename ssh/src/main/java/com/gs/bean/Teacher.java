package com.gs.bean;

import org.apache.struts2.json.annotations.JSON;

import java.util.Set;

public class Teacher {
    private Long id;
    private String name;
    private String phone;

    private Set<Clazz> clazzSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JSON(serialize = false)
    public Set<Clazz> getClazzSet() {
        return clazzSet;
    }

    public void setClazzSet(Set<Clazz> clazzSet) {
        this.clazzSet = clazzSet;
    }
}
