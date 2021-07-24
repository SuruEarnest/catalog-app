# Catalog-app
The backend API for product catalog management

#Database:
MySQL was used as the database,I advise that the reviewer install mysql on his/her local machine and create 
a database (catalog_db) with the credentials specified in the application-local.properties.

#Swagger Documentations:
When the app is running locally on port 8083 as specified in the application properties,
swagger docs will be accessible in the link below

http://localhost:8083/swagger-ui.html

#Extra Notes:
1.It's also important to create run/debug application configurations in IntelliJ IDE

2.set VM options to -Dspring.profiles.active=local in IntelliJ IDE

When you do the two steps above,the application will pick the 
application-local.properties file during startup.
 
All the relevant database and application settings have been specified in application-local.properties