# MongoDB Aggregation

[TOC]

#### Aggregate Summary

简介: 在MongoDB中，聚合操作处理数据记录/文档并返回计算结果。它从各种文档中收集值并将其分组，然后对分组的数据执行不同类型的操作，如总和、平均值、最小值、最大值等，以返回计算结果。它类似于SQL的聚合函数.

用途:

- Aggregation pipeline
- Map-reduce function
- Single-purpose aggregation

示例：![Lightbox](https://media.geeksforgeeks.org/wp-content/uploads/20210209233143/Aggregate-660x477.png)



#### Aggregation Stage

每一个stage彼此独立, 互不影响，仅将stage产生的结果传递给下一个stage

Results<stage1> -> Results<stage2> -> .... -> Results<stageN> -> Client

```shell
//使用
db.<collection>.aggregate(
    [
        <stage1>,
        <stage2>,
        ...
        <stageN>,
    ]
)
```

![](/home/cby/Downloads/stage.png)

##### Stage Operator

Each stage starts from the stage operator

{$<stageOperator>: {} }

```json
{$match: {age: {$gt:20 } } }
{$group: {_id: "$age"} }
{$sort: {age: -1}
```

##### Stages Overview

```
$match $group $project
$sort  $count $limit
$skip  $out
```

##### $match Stage

Match specific documents using query

Note: Match uses standard MongoDB queries and supports all query operators

eg.

```json
{$match: {city: "New York"}}
{$match: {age: {$gt: 25}}}
{$match: {tags: {$size: 2}}}
{$match: {$and: [{gender: "female"}, {age:{$gt:25}}]}}

```



##### $group Stage

Groups input documents by certain expressions

eg.

```json
{$group: {_id:<expression>, <fields1>: {<accumulator1>:<expression> }, ...}

//
{$group: {_id:{age: "$age", gender: "$gender"}}}
```

Result example

![image-20220712221540612](/home/cby/snap/typora/57/.config/Typora/typora-user-images/image-20220712221540612.png)

#### Aggregate Expression

Expression refers to the name of the field in input documents

eg.

```json
{$group: {_id: "$age"}}
{$group: {_id: "$company.location.country"}}
{$group: {_id: "$name", total:{$sum: "$price"}}}

```

##### Group By Nested Fields

```json
db.persons.aggregate([
	{$group:{_id: "$company.location"}}
])

{	$group: 
	{_id: 
		{age:"$age", gender:"$gender"}
	}
}
```



##### $match and $group

```json
db.persons.aggregate([
	{$match: {gender:"famale"}}
	{$group:{_id: {
	eyeColor: "$eyeColor",
	age: "$age",
	gender: "$female"
	}}}
])
```



##### $group and $stage

```json
db.persons.aggregate([
    {$group:{_id: {
		eyeColor: "$eyeColor",
		age: "$age",
		gender: "$female"
	}}},
	{$match: {"_id.age": {$gt:30}}}
])
```



##### $count

```json
db.persons.aggregate([{$count:"allDocument"}])

//Different count methods
db.persons.aggregate([]).toArray().length    ->> Client-side count
1.7sec -> 1000

db.persons.aggregate([]).itcount()           ->> Client-side count
1.4sec -> 1000

db.persons.aggregate([{$count:"total"}])     ->> Server-side count
0.21sec -> {"total": 1000}

db.persons.find({}).count()     			 ->> Server-side count
0.21sec -> {"total": 1000}

//Find count() is wrapper of the aggregate $count
```



##### $group and $count

```json
db.persons.aggregate([{$group:{
	_id: {eyeColor: "$eyeColor", gender: "$gender"}
	},
	{$count: "count"}
}}])

//result {"count": 6}
```



##### $sort

```json
{$sort: {age: 1, country:1}}

//1 Ascending, -1 Descending
```



##### $group and $sort

```json
db.airbnb.aggregate([
  {
    $group: {
      _id: {
        name: "$name"
      }
    }
  },
  {
    $sort: {
      _id: 1
    }
  }
])
```

![image-20220712221831260](/home/cby/snap/typora/57/.config/Typora/typora-user-images/image-20220712221831260.png)

```json
db.airbnb.aggregate([
  {
    $group: {
      _id: {
        name: "$name",
        beds: "$beds"
      }
    }
  },
  {
    $sort: {
      "_id.name": 1,
      "_id.beds": -1
    }
  }
])
```

![image-20220712222415891](/home/cby/snap/typora/57/.config/Typora/typora-user-images/image-20220712222415891.png)



##### $project Stage

INcludes, Excludes or adds new fields

```json
{$project: {name: 1, "company.title": 1}}
{$project: {_id:0, name: 1, "company.title": 1}}

{$project: {name: 1. newAge: "$age"}}

{$project: {name: 1, "company.title": 1}}
```



![image-20220712223057990](/home/cby/snap/typora/57/.config/Typora/typora-user-images/image-20220712223057990.png)



##### $project with new fields

```json
db.airbnb.aggregate([
  {
    $project: {
      name: 1,
      info: {
        street: "$address.street"
      }
    }
  }
])
```





![image-20220712223646869](/home/cby/snap/typora/57/.config/Typora/typora-user-images/image-20220712223646869.png)

##### $limit

Outputs first N documents from the input

```json
db.airbnb.aggregate([
  {
    $limit:100
  }
])
```



$group in Array

```json
db.airbnb.aggregate([
  {
    $group: {
      _id: {
        tags: "$tags"
      }
    }
  }
])

// result
{ _id: { tags: [ 'a', 'b', 'c' ] } }
{ _id: { tags: [ 'a', 'c', 'b' ] } }
{ _id: { tags: null } }
```



$unwind Stage

Split each document with specified fields

```json
db.airbnb.aggregate([
  
    {$unwind: "$tags" },
    {$project: {name:1, tags: 1}}
  
])

//
{ _id: '10006546', name: 'Ribeira Charming Duplex', tags: 'a' }
{ _id: '10006546', name: 'Ribeira Charming Duplex', tags: 'b' }
{ _id: '10006546', name: 'Ribeira Charming Duplex', tags: 'c' }
{ _id: '1001265',
  name: 'Ocean View Waikiki Marina w/prkg',
  tags: 'a' }
{ _id: '1001265',
  name: 'Ocean View Waikiki Marina w/prkg',
  tags: 'c' }
{ _id: '1001265',
  name: 'Ocean View Waikiki Marina w/prkg',
  tags: 'b' }
```



$unwind and $group

```json
db.airbnb.aggregate([
  
    {$unwind: "$tags" },
    {$group: {_id:"$tags"}}
  
])

// result
{ _id: 'b' }
{ _id: 'c' }
{ _id: 'a' }

```



$out Stage

Write resulting documents to the MongoDB collection

1. $out Must be last stage in the pipeline
2. if output collection doesn't exist, it will be created automatically

```
db.airbnb.aggregate([
  
    {$unwind: "$tags" },
    {$group: {_id:"$tags"}},
  	{$out: "testout"}
])
```



#### Accumulators

```
$sum $avg $max $min

Note: Most accumulators are used only in the $group stage 
```



$sum and $group

```
db.airbnb.aggregate([
    {$group: {_id: {beds: "$beds"}, count: {$sum:1}}},
    {$sort: {"_id.beds":1}}
])

//result 
{ _id: { beds: null }, count: 13 }
{ _id: { beds: 0 }, count: 29 }
{ _id: { beds: 1 }, count: 2700 }
{ _id: { beds: 2 }, count: 1381 }
{ _id: { beds: 3 }, count: 657 }
{ _id: { beds: 4 }, count: 385 }
{ _id: { beds: 5 }, count: 166 }
{ _id: { beds: 6 }, count: 109 }
{ _id: { beds: 7 }, count: 43 }
{ _id: { beds: 8 }, count: 28 }

```





$sum, $unwind and $group

```json
db.airbnb.aggregate([
	{$unwind: "$tags"},
    {$group: {_id: {tags: "$tags"}, count: {$sum:1}}},
])

//result 
{ _id: { tags: 'a' }, count: 2 }
{ _id: { tags: 'b' }, count: 2 }
{ _id: { tags: 'c' }, count: 2 }

```



$avg and $group

```
db.airbnb.aggregate([
    {$group: {_id: {bedrooms: "$bedrooms"}, avgbeds: {$avg: "$beds"}}}
])
```



#### Unary Operators

1. Unary Operators are usually used in the $project stag
2. In the $group stage Unary Operators can be used only conjunction with Accumulators



```
$type $or
$lt $gt
$and $multiply

```

$type and $project

```
db.airbnb.aggregate([
    {$project: {name:1, nameType: {$type: "$name"}, bedsType:{$type: "$beds"}}}
])

//result

{ _id: '10091713',
  name: 'Surry Hills Studio - Your Perfect Base in Sydney',
  nameType: 'string',
  bedsType: 'int' }
```



allowDiskUse: true

All aggregation stages can use maximum 100 MB of RAM

Server will return error if RAM limit is exceeded

Follwing option will enable MongoDB to write stages data to the temporal files

```
{allowDiskUse: true}

db.airbnb.aggregate([
    {$project: {name:1, nameType: {$type: "$name"}, bedsType:{$type: "$beds"}}}
], {allowDiskUse: true})
```



| Functions    |      | SQL Expression  |
| ------------ | ---- | --------------- |
| $match       |      | where           |
| $project     |      | as              |
| $sort        |      | order by        |
| $group       |      | group by        |
| $skip/$limit |      | sklip/limit     |
| $lookup      |      | left outer join |

