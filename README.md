# HTTP NOTIFICATION SYSTEM: SUBSCRIBER
This application is part of an HTTP notification system developed using the Java Spring Framework. 
This is the subscriber of the application and receives messages from the publisher.
See subscriber application [here](https://github.com/mugambbo/hello-server).  

# Requirements
-   Java SDK 8+
-   Gradle 7.1.1
-   Running publisher application

# Run
The easiest way to start an instance of the Subscriber is through github:
```
git clone https://github.com/mugambbo/hello-subscriber
cd hello-subscriber
./gradlew bootRun
```

This will start an instance of the subscriber on port 9000

# Endpoints
Important: Content-Type: application/json header must be present to use API.
The most common HTTP status codes are returned on exception thrown.

## Post Message
```
/{test1} [POST]
Content-Type: application/json
{
    "key": object
}
```

When it succeeds, a 200 status code is returned along with the data object in the body of the response.
```
{
    "key": object
}
```

#Test
While the publisher and subscriber are running, execute the following in your terminal:
curl -X POST -H "Content-Type: application/json" -d '{ "url": "http://localhost:9000/test1"}' http://localhost:8000/subscribe/topic1 curl -X POST -H "Content-Type: application/json" -d '{ "url": "http://localhost:9000/test2"}' http://localhost:8000/subscribe/topic1 curl -X POST -H "Content-Type: application/json" -d '{"message": "hello"}' http://localhost:8000/publish/topic1