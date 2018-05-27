# JAZ-zad4

## Api URL

### /film
-> GET
-> POST: 
  {
    "name" : "testName",
    "description" : "testDesc"
  }
  
### /film/{id}
-> GET
-> DELETE
-> PUT:
  {
    "name" : "testName1",
    "description" : "testDesc1"
  }
  
### /{filmId}/comment
-> GET
-> DELETE
-> POST
  {
    "comment" : "testComment"
  }
  
### /{filmId}/rate
-> GET
-> DELETE
-> POST
  {
    "rate" : 10
  }
  
### /{filmId}/actor
-> GET
-> DELETE
-> POST
  {
    "name" : "nameTest"
  }
