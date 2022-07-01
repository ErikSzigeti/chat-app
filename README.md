The application can be built from the main directory with : ./mvnw clean install
The program can be run from the target directory with : java -jar -Dspring.profiles.active=dev chat-app-0.0.1-SNAPSHOT.jar

For this project I have chosen a classical unit testing style.

For easier deploy and testing I have chosen an embedded ActiveMQ and embedded H2 database with an active console. This can be reached here : http://localhost:8080/h2-console 

user : sa  
password: password

I have also made an export from PostMan so the possible controller routes are easier to try out.