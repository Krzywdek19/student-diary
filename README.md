
# Student-diary




## API Reference

### School

```http
  POST /api/v1/school - add school
    Example request body: 
        {
            "name": "school name",
            "address": {
                    "city":"city",
                    "street":"street",
                    "building":"building"
                },
            "schoolType": 1
        }
  GET /api/v1/school - get all schools
  GET /api/v1/school/{id} - get school by id
  PUT /api/v1/school/{id} - update school details
    Example request body: 
      {
        "name" : "another school name"
      }
  DELETE /api/v1/school/{id} - delete school by id
```

### School classes

```http
  POST /api/v1/school/{schoolId}/class - add class to school
      Example request body: 
      {
        "classGrade": 1,
        "classSign": "C"
      }
  GET /api/v1/school/{schoolId}/class - get all classes belong to school
  GET /api/v1/school/{schoolId}/class/{id} - get class by id
  PUT /api/v1/school/{schoolId}/class/{id} - update school class details
        Example request body: 
      {
        "classGrade": 2
      }
  DELETE /api/v1/school/{id}/class/{id} - delete school class by id
```


