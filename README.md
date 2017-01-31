# Infinite streams in dropwizard;

Implementation of infinite sequences as REST services.

# Stream of even nos
http://localhost:8080/even
http://localhost:8080/even?limit=10

# Stream of fibonacci nos
http://localhost:8080/fibonacci
http://localhost:8080/fibonacci?limit=10

# Dropwizard version

1.0.5

# Build

Run `./gradlew clean oneJar`. The resulting JAR will be saved as `./build/libs/infinite-streams-<<version>>-standalone.jar`.

This example is using the [Gradle OneJar Plugin](https://github.com/rholder/gradle-one-jar) which will create
a JAR file of the project including all dependencies, similar to the [Maven Assembly Plugin](http://maven.apache.org/plugins/maven-assembly-plugin/)
or the [Maven Shade Plugin](http://maven.apache.org/plugins/maven-shade-plugin/).


# Run

`java -jar build/libs/infinite-streams-<<version>>-standalone.jar server`