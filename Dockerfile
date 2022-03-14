#######################################
## Stage 1 : build with maven builder image with native capabilities
FROM quay.io/quarkus/ubi-quarkus-native-image:22.0-java17 AS build
COPY --chown=quarkus:quarkus mvnw /code/mvnw
COPY --chown=quarkus:quarkus .mvn /code/.mvn
COPY --chown=quarkus:quarkus pom.xml /code/
USER quarkus
WORKDIR /code
RUN ./mvnw -B org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline
COPY src /code/src
RUN ./mvnw package -Pnative

#######################################
## Stage 2 : create the docker final image
FROM quay.io/quarkus/quarkus-micro-image:1.0
WORKDIR /work/
COPY --from=build /code/target/*-runner /work/cmg-seafarers

## This is a fake SENTRY DSN, replace ENV with actual Value
ENV SENTRY_DSN=https://public:private@host:port/1
ENV PORT=8080

# set up permissions for user `1001`
RUN chmod 775 /work /work/cmg-seafarers \
  && chown -R 1001 /work \
  && chmod -R "g+rwX" /work \
  && chown -R 1001:root /work

EXPOSE 8080
USER 1001

CMD exec "./cmg-seafarers" "-Dquarkus.http.port=${PORT}" "-Dquarkus.http.host=0.0.0.0"