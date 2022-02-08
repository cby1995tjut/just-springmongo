package com.myspringmongo.mymongo.controller;

import com.myspringmongo.mymongo.entity.Employee;
import com.myspringmongo.mymongo.entity.Order;
import com.myspringmongo.mymongo.service.AutoInject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MongoController {

    private final MongoTemplate mongoTemplate;
    private AutoInject autoInjectPrimary;

    @Autowired
    public MongoController(MongoTemplate mongoTemplate, AutoInject autoInjectPrimary) {
        this.mongoTemplate = mongoTemplate;
        this.autoInjectPrimary = autoInjectPrimary;
    }

    @RequestMapping("/index")
    public String getIndex() {

//        Order order =  new Order();
//        order.setOrderName("o1");
//        order.setPersonName("aaa");
        Criteria criteria = Criteria.where("personName").is("aaa");
        List<Order> orders = mongoTemplate.find(Query.query(criteria), Order.class);


        LookupOperation as = LookupOperation.newLookup().from("order").localField("personName").foreignField("name").as("person");

        TypedAggregation<Order> agg =
                Aggregation.newAggregation(
                        Order.class,
                        as
                );


        AggregationResults<Order> results = mongoTemplate.aggregate(agg, "order", Order.class);

        results.getMappedResults();
        return "aaa";
    }


    @RequestMapping("/index1")
    public String getIndex1() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("department")
                .localField("dataProvider.dept_id")
                .foreignField("_id")
                .as("departments");

        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is("616a60fd5cb41f548b59caa1")) , lookupOperation);
        List<Employee> results = mongoTemplate.aggregate(aggregation, "employee", Employee.class).getMappedResults();
        return "aaa";
    }

    @RequestMapping("/index2")
    public String getIndex2() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("department")
                .localField("dept_id")
                .foreignField("_id")
                .as("departments");

        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is("616a60fd5cb41f548b59caa1")) , lookupOperation);
        List<Employee> results = mongoTemplate.aggregate(aggregation, "employee", Employee.class).getMappedResults();
        return "aaa";
    }

    @RequestMapping("/index3")
    public String getIndex3() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("location")
                .localField("employee.eid")
                .foreignField("eid")
                .as("location");

        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is("616a60fd5cb41f548b59caa1")) , lookupOperation);
        List<Employee> results = mongoTemplate.aggregate(aggregation, "employee", Employee.class).getMappedResults();
        return "aaa";
    }
}
