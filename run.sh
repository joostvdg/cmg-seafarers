#!/usr/bin/env bash
echo "SENTRY_DSN=${SENTRY_DSN}"
mvn clean compile quarkus:dev