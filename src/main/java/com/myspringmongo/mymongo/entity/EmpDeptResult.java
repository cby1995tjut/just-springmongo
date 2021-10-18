package com.myspringmongo.mymongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public class EmpDeptResult {

    private String _id;
    private String name;
    private List<Object> departments;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Object> departments) {
        this.departments = departments;
    }
}
