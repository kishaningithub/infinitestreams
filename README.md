# Infinite streams in dropwizard
[![Build Status](https://travis-ci.org/kishaningithub/infinitestreams.svg?branch=master)](https://travis-ci.org/kishaningithub/infinitestreams)
[![Codecov](https://img.shields.io/codecov/c/github/kishaningithub/infinitestreams.svg)](https://codecov.io/gh/kishaningithub/infinitestreams)

Implementation of infinite sequences as REST services.

# Start Server

```
docker pull kishanb/infinitestreams:1.0.0
docker run -p 8080:8080 -p 8081:8081 kishanb/infinitestreams:1.0.0
```

# Stream of fibonacci nos

```
http://localhost:8080/fibonacci
http://localhost:8080/fibonacci?limit=10
```

# Stream of even nos

```
http://localhost:8080/even
http://localhost:8080/even?limit=10
```

# Dropwizard version

1.0.5

# Build

Run `./gradlew clean build`. The resulting JAR will be saved as `./build/libs/infinite-streams-<<version>>-all.jar`.

This example is using the [Gradle Shadow Plugin](https://github.com/johnrengelman/shadow) which is gradle
version of the [Maven Shade Plugin](http://maven.apache.org/plugins/maven-shade-plugin/).


# Run

`java -jar build/libs/infinite-streams-<<version>>-standalone.jar server`
