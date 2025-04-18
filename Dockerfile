FROM gradle:jdk8 as javabuilder

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build -x test

FROM node:8-slim as nodebuilder

COPY ./web /opt/jble6lowpancontroller

WORKDIR /opt/jble6lowpancontroller

RUN npm install

RUN node build/build.js

FROM openjdk:8-jre-slim

COPY --from=javabuilder /home/gradle/src/build/distributions/jble6lowpancontroller.tar /opt/

WORKDIR /opt

RUN tar -xvf jble6lowpancontroller.tar && \
    rm jble6lowpancontroller.tar

WORKDIR /opt/jble6lowpancontroller

RUN mkdir web

COPY --from=nodebuilder /opt/jble6lowpancontroller/dist web/

EXPOSE 8080

CMD bin/jble6lowpancontroller -c /opt/jble6lowpancontroller/web/