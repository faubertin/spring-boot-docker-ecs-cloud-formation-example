## Running from an IDE
In your IDE, run the class com.example.Application (in src/main/java)

## Testing the REST endpoints

```
curl -X POST http://localhost:8080/fooEntities -H "Content-Type: application/json" -d "{ \"bar\": \"test value\" }"
curl -X GET http://localhost:8080/fooEntities
```

## Building the executable jar

To build the executable jar, run in a terminal
```
./mvnw package
```

To test the executable jar, run
```
java -jar target/spring-boot-docker-ecs-cloud-formation-example-0.0.1-SNAPSHOT.jar
```

## Docker - Building and deploying
### One-off setup
* Install Docker
* In AWS, open IAM and
  * Create a new user which represents yourself as a developer (e.g. yourname-dev)
  * Generate an access key, copy-paste the key ID and secret to a text file
  * Grant the permission "AmazonEC2ContainerRegistryFullAccess" to the user
* Open a terminal and type `aws configure`, enter the access key ID and secret 
* Open the pom.xml and copy the artifactId of this project
* Go to AWS EC2 Container Registry
  * Create a new repository and give the artifactId as a repository name
  * Copy the `aws ecr get-login --region $region`
* In a terminal
  * Run the `aws ecr get-login --region $region`
  * Copy the output of the command
  * Paste the output into the terminal and run it
  * Ensure that a file ~/.docker/config.json has been created with some credentials for your Docker repository
* In the pom.xml replace the property docker.registry by your registry


### Building an image

Run in a terminal
```
./mvnw docker:build
```
To test the image run `docker images`, copy the ID of the image and run
```
docker run -p 8080:8080 -t $imageId
```
To stop the container run `docker ps`, copy the ID of the container and run:
```
docker stop $containerId
```

### Deploying to ECR 

Run in a terminal
```
./mvnw docker:build -DpushImage
```