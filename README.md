# songr App 

The App has four Routes:
* the home route : http://localhost:8080/   
* the hello route : http://localhost:8080/hello and you can use it with  query parameter **?name=YourName**  
* the capitalize/{word} route : http://localhost:8080/capitalize/alaa it print the word capitalized.  
* the albums route : http://localhost:8080/albums it return three instances of the Albume class.  
  
* The home route has form the user can **Add the Album** to the Database: http://localhost:8080/  
* When click submit will go action to **/addalbum** end point and save the album to the databas, and Redirect to the **/allalbums** end point to **render all the albums** in the database. 
* To **Delete** an album : http://localhost:8080/delete/ID_For_the_Album 
* Add **/error** end point for render error message.  

## The Database
* start the sql server  
* type **psql**  
* **CREATE DATABASE albums;** create the database.    
* **\c albums;** Toconnect to the database  
* **\d** to check if the table created it will be **Album** table.    
* After adding albums to the table you can see the table content **SELECT * FROM Album;**
  
## The application.properties File 
server.port=8080  
spring.datasource.platform=postgres  
spring.datasource.url=jdbc:postgresql://localhost:5432/albums  
spring.datasource.username=alaa  
spring.datasource.password=  
spring.jpa.hibernate.ddl-auto=update  
spring.datasource.initialization-mode=always  
