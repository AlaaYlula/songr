# songr App 

The App has Many Routes:
* the home route : http://localhost:8080/   
* the /hello route : http://localhost:8080/hello and you can use it with  query parameter **?name=YourName**  
* the /capitalize/{word} route : http://localhost:8080/capitalize/alaa it print the word capitalized.  
* the /newalbums route : http://localhost:8080/newalbums it return three instances of the Albume class.  
## Album
* The **/albums** route : http://localhost:8080/albums  has form the user can **Add the Album** to the Database   
* When click submit will go action to **/album** end point and save the album to the database, and Redirect to the **/albums** end point to *render all the albums* in the database. 
* The **/allalbums** route : http://localhost:8080/allalbums render the Album table content as Json Format  
* The **/album/{id}** : http://localhost:8080/album/ID_For_the_Album the data about one particular album as JSON Format   
* The **/albumDetails** route : has option to choose the album you want more details about.  
* The **/album/details** route : render the details for that album.  
* The **/deletealbum** route : when click on delete button will delete the album and redirect to the **/albums** end point.    
* To **Delete** an album : http://localhost:8080/delete/ID_For_the_Album  
* Add **/error** end point for render error message.  
## Song  
* The **/songs** route: http://localhost:8080/songs has form the user can *Add the Song* to the Database and choose the Album to add this song to it.     
* When click Add will go action to **/song** end point and save the song to the database and added to the album, and Redirect to the **/songs** end point to *render all the songs* in the database.  
* The **/allsongs** route : http://localhost:8080/allsongs render the Song table content as Json Format  
* The **/album/{id}** : http://localhost:8080/album/ID_For_the_AlbumYouWantoAddTheSongto  Add Song(as JSON Format) to the particular Album and add it to the Song database(**POST** using postman) 
* The **/deletesong** route : when click on delete button will delete the song and redirect to **/songs**  
* To **Delete** a song : http://localhost:8080/deletesong/ID_For_the_Song  


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
