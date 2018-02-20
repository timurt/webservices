WebServices
===================

Sample web-application to demonstrate basics of REST/SOAP protocols. 
Only server parts are implemented. Two implemented endpoints have same 
functionality create/edit/delete/list persons.


----------
Technologies
-------------

- javaee-api 8.0
- gson 2.8.2
- Gradle 4.2
- JBoss WildFly 11.0.0

----------
Installation
------------

To load dependencies
> $ gradle build

To package war file
> $ gradle war

----------
REST
------------
- Endpoint url `http://localhost:8080/webservices-1.0/rest`
- List all persons - [GET] /person
- Find person by id - [GET] /rest/person/{id}
- Create new person - [POST] /rest/person/
- Update person by id - [PUT] /rest/person/{id}
- Delete person by id - [DELETE] /rest/person/{id}

Sample request
```
[POST] /rest/person/
{
	"firstName" : "Harry",
	"lastName" : "Potter",
	"age" : "26",
	"birthDate" : "1993-03-05",
	"email" : "h.potter@hogwarts.com"
}

```

Sample response
```
{
   "id": 705,
   "age": 26,
   "firstName": "Harry",
   "lastName": "Potter",
   "email": "h.potter@hogwarts.com",
   "birthDate": "Mar 5, 1993 6:00:00 AM"
}
```

----------
SOAP
------------

- WSDL url `http://localhost:8080/webservices-1.0/SoapServiceImpl?wsdl`
- Endpoint url `http://localhost:8080/webservices-1.0/SoapServiceImpl`
- All requests must be via `POST` method

Sample request
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.samples.tim.kz/">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:savePerson>
         <person>
            <age>25</age>
            <birthDate>1992-02-02</birthDate>
            <email>sample@m.ru</email>
            <firstName>John</firstName>
            <lastName>Snow</lastName>
         </person>
      </soap:savePerson>
   </soapenv:Body>
</soapenv:Envelope>
```

Sample response
```
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:savePersonResponse xmlns:ns2="http://soap.samples.tim.kz/">
         <person>
            <age>25</age>
            <birthDate>1992-02-02T00:00:00+06:00</birthDate>
            <email>sample@m.ru</email>
            <firstName>John</firstName>
            <id>194</id>
            <lastName>Snow</lastName>
         </person>
      </ns2:savePersonResponse>
   </soap:Body>
</soap:Envelope>
```