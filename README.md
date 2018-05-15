# Infinite streams in dropwizard

[![Build Status](https://travis-ci.org/kishaningithub/infinitestreams.svg?branch=master)](https://travis-ci.org/kishaningithub/infinitestreams)
[![Codecov](https://img.shields.io/codecov/c/github/kishaningithub/infinitestreams.svg)](https://codecov.io/gh/kishaningithub/infinitestreams)
[![Latest release](https://img.shields.io/github/release/kishaningithub/infinitestreams.svg)](https://github.com/kishaningithub/infinitestreams/releases)

Implementation of infinite sequences as REST services.

## Start Server

```bash
docker pull kishanb/infinitestreams:<<latest release>>
docker run -p 8080:8080 -p 8081:8081 kishanb/infinitestreams:<<latest release>>
```

## Stream of fibonacci nos

```bash
curl 'http://localhost:8080/fibonacci'
curl 'http://localhost:8080/fibonacci?limit=10'
```

## Stream of even nos

```bash
curl 'http://localhost:8080/even'
curl 'http://localhost:8080/even?limit=10'
```

## Dropwizard version

1.3.2

## Build

Run `./gradlew clean build`. The resulting JAR will be saved as `./build/libs/infinite-streams-<<version>>-all.jar`.

This example is using the [Gradle Shadow Plugin](https://github.com/johnrengelman/shadow) which is gradle
version of the [Maven Shade Plugin](http://maven.apache.org/plugins/maven-shade-plugin/).

## Run

```bash
java -jar build/libs/infinite-streams-all.jar server
```
