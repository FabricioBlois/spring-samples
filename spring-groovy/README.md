# Spring boot groovy example project

[![Build Status](https://travis-ci.org/FabricioBlois/books.svg?branch=master)](https://travis-ci.org/FabricioBlois/books)

### GET resource
```console
curl -X GET http://localhost:8080/api/v1/books/{id} 
```

### CREATE resource
```console
curl -X POST http://localhost:8080/api/v1/books/
   -H 'Content-Type: application/json'
   -d '{
 	"name":"name",
 	"author": {
 		"name": "name"
 	},
 	"publishedDate": "YYYY-MM-DD",
 	"pages": 1
 }'
```

### UPDATE resource
```console
curl -X PUT
  http://localhost:8080/api/v1/books/{id}
  -H 'Content-Type: application/json'
  -d '{
    "name": "name",
    "author": {
        "name": "name"
    },
    "publishedDate": "YYYY-MM-DD",
    "pages": 1
}'
```

### DELETE resource
```console
curl -X DELETE http://localhost:8080/api/v1/books/{id}
```