package com.myspringmongo.mymongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.crypto.Data;
import java.util.List;

@Document("employee")
public class Employee {

    private String _id;
    private String name;
    private String dept_id;
    private DataProvider dataProvider;
    private List<Location> location;
    private List<Object> departments;

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public DataProvider getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public List<Object> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Object> departments) {
        this.departments = departments;
    }

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

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }
}
