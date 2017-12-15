package com.gs.bean;

import java.util.Set;

public class Contract {
    private Long id;
    private String name;
    private String phone;

    private Set<Stu> stuSet;

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

    public Set<Stu> getStuSet() {
        return stuSet;
    }

    public void setStuSet(Set<Stu> stuSet) {
        this.stuSet = stuSet;
    }
}
