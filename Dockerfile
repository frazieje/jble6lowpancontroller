FROM gradle:jdk8 as builder

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build -x test

FROM openjdk:8-jre-slim

EXPOSE 8080

COPY --from=builder /home/gradle/src/build/distributions/jble6lowpancontroller.tar /opt/

WORKDIR /opt

RUN tar -xvf jble6lowpancontroller.tar

WORKDIR /opt/jble6lowpancontroller

CMD bin/jble6lowpancontroller