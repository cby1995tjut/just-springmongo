package com.myspringmongo.mymongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("department")
public class Department {

    private String _id;
    private String dept_name;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
