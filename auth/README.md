# Authenticate Site  
Has a One-to-Many Relationship, User and posts.  
Use Bcrypt to hash all passwords stored on the site.  
Add login / logout functionality using server sessions.  
  
# The End Points   
* **/hello** route : It is the Main page, has a var bar to move through the application.  
* **/signup** route : To sign up to the application then redirect to the **/login**.  
* **/login** route : To login to the application and redirect to **/**, If the password not correct then redirect to **/login** again.  
* **/** route : It is the home page, It render the user name and the posts which is in the application, and let the user add post, and logout.  
* **/post** route : when click on Add post button then add this post and redirect to **/** again.  
* **/logout** route : End the session and redirect to **/hello** again.  
