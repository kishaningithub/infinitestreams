FROM openjdk:8-jre-alpine
ENV APP_VERSION 1.0.0
RUN rm -rf /myapp && mkdir /myapp
WORKDIR /myapp
ADD build/libs/dropwizard-gradle-infinite-streams-${APP_VERSION}-standalone.jar /myapp
ENTRYPOINT java -jar dropwizard-gradle-infinite-streams-${APP_VERSION}-standalone.jar server
EXPOSE 8080 8081