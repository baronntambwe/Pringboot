FROM gradle:latest as builder
ADD --chown=gradle:gradle . /app/gradle/src
WORKDIR /app/gradle/src
RUN gradle clean assemble

FROM java:8
RUN useradd -ms /bin/bash admin
VOLUME /tmp
COPY ./wait-for-it.sh ./wait-for-it.sh
RUN chown admin:admin ./wait-for-it.sh
RUN chmod a+x wait-for-it.sh
COPY --from=builder /app/gradle/src/build/libs/microservice-course-management-0.0.1.jar app.jar
RUN bash -c 'touch /app.jar'
USER admin
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/app.jar"]