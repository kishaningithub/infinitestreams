FROM openjdk:8-jre-alpine
RUN rm -rf /myapp && mkdir /myapp
WORKDIR /myapp
ADD build/libs/infinitestreams-all.jar /myapp
ENTRYPOINT java -jar infinitestreams-all.jar server
EXPOSE 8080 8081