# syntax=docker/dockerfile:experimental
#######################################
## Stage 1 : build with maven builder image with native capabilities
FROM quay.io/quarkus/centos-quarkus-maven:19.0.2 AS build
COPY pom.xml /usr/src/app/pom.xml
RUN mvn -f /usr/src/app/pom.xml dependency:go-offline -B
COPY src /usr/src/app/src
USER root
RUN chown -R quarkus /usr/src/app
USER quarkus
RUN   mvn -f /usr/src/app/pom.xml -Pnative clean package -e
# --mount=type=cache,target=/home/quarkus/.m2/
#######################################
## Stage 2 : create the docker final image
FROM registry.access.redhat.com/ubi8/ubi-minimal
# This is a fake SENTRY DSN, replace ENV with actual Value
ENV SENTRY_DSN=https://public:private@host:port/1
ENV PORT=8080
WORKDIR /work/
COPY --from=build /usr/src/app/target/*-runner /work/cmg-seafarers
RUN chmod 775 /work
### Have to use ENTRYPOINT exec to avoid issues with parameter interpolation and avoid an entrypoint.sh script
# see: https://joostvdg.github.io/blogs/docker-graceful-shutdown/
#ENTRYPOINT
### Heroku expect a CMD command, so we have to use it
# https://stackoverflow.com/questions/55913408/no-command-specified-for-process-type-web-on-heroku
CMD exec "./cmg-seafarers" "-Dquarkus.http.port=${PORT}" "-Dquarkus.http.host=0.0.0.0"
#######################################
