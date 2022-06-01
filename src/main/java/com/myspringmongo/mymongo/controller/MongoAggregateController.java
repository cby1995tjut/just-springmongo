package com.myspringmongo.mymongo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myspringmongo.mymongo.entity.Order;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.expression.Operation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController()
public class MongoAggregateController {

    private final ObjectMapper mapper = new ObjectMapper();


    private final MongoTemplate mongoTemplate;
    @Autowired
    public MongoAggregateController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @RequestMapping("/sum")
    public String getSum() throws JsonProcessingException {
        Criteria criteria = Criteria.where("size").is("small");
        GroupOperation groupMaxOperation = Aggregation.group("name").sum("quantity").as("totalQuantity");

        AggregationResults<Document> aggregate = mongoTemplate.aggregate(Aggregation.newAggregation(new MatchOperation(criteria),groupMaxOperation), "orders", Document.class);
        List<Document> mappedResults = aggregate.getMappedResults();
        return mapper.writeValueAsString(mappedResults);
    }

    @RequestMapping("/date/avg")
    public String getByDateAndAVG() throws ParseException, JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dateFormat.parse("2020-01-30");
        Date end = dateFormat.parse("2022-01-30");
        Criteria criteria = Criteria.where("date").gte(start).lt(end);

        DateOperators.DateOperatorFactory dateOperatorFactory = DateOperators.dateOf("date");
        DateOperators.DateToString dateToString = dateOperatorFactory.toString("yyyy-MM-dd");

//        ProjectionOperation.ProjectionOperationBuilder and = Aggregation.project("date").and(DateOperators.DateToString.dateOf("date").toString("%Y-%m-%d"));
        GroupOperation groupMaxOperation = Aggregation.group().sum("price").as("price")
                .avg("quantity").as("avgQuantity");
        ReplaceRootOperation replaceRootOperation = Aggregation.replaceRoot(dateToString);
        ProjectionOperation as = Aggregation.project("date").and(dateToString).as("groupdate");
        AggregationResults<Document> aggregate = mongoTemplate.aggregate(Aggregation.newAggregation(new MatchOperation(criteria), replaceRootOperation, groupMaxOperation), "orders", Document.class);
        List<Document> mappedResults = aggregate.getMappedResults();

        GroupOperation group = Aggregation.group(dateToString.toDocument().toString());

        Aggregation.newAggregation(new MatchOperation(criteria), group, groupMaxOperation);
        return mapper.writeValueAsString(mappedResults);
    }


    @RequestMapping("/date/avg/1")
    public String getByDateAndAVGAnd1() throws ParseException, JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dateFormat.parse("2020-01-30");
        Date end = dateFormat.parse("2022-01-30");
        Criteria criteria = Criteria.where("date").gte(start).lt(end);

        DateOperators.DateOperatorFactory dateOperatorFactory = DateOperators.dateOf("date");
        DateOperators.DateToString dateToString = dateOperatorFactory.toString("%Y-%m-%d");


        List<AggregationOperation> operations = new ArrayList<>();

//        ProjectionOperation groupDate = Aggregation.project().andExpression("{ $dateToString: { format: \"%Y-%m-%d\", date: \"$date\" } }").as("groupDate").and("price").as("price").and("quantity").as("quantity");
        ProjectionOperation groupDate = Aggregation.project().andExpression(dateToString.toDocument().toJson()).as("groupDate").and("price").as("price").and("quantity").as("quantity");
        GroupOperation groupMaxOperation = Aggregation.group("groupDate").sum("price").as("totalPrice")
                .avg("quantity").as("avgQuantity");

        operations.add(new MatchOperation(criteria));
        operations.add(groupDate);
        operations.add(groupMaxOperation);
        Aggregation aggregation = Aggregation.newAggregation(operations);
        System.out.println(aggregation);
        AggregationResults<Document> aggregate = mongoTemplate.aggregate(aggregation, "orders", Document.class);
        List<Document> mappedResults = aggregate.getMappedResults();
        return mapper.writeValueAsString(mappedResults);
    }
}
