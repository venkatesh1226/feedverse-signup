# Step 1: Use a base image with Java (specify the Java version you need)
FROM openjdk:17

# Step 2: Add a volume pointing to /tmp
VOLUME /tmp

# Step 3: Make port 8008 available to the world outside this container
EXPOSE 8008

# Step 4: Add the application's jar to the container
ADD target/authenticator-0.0.1-SNAPSHOT.jar myapplication.jar

# Step 5: Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapplication.jar"]
