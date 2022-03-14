#TAG=${1}
#docker tag cmg-seafarers:${TAG} registry.heroku.com/catan-map-generator-seafarers/web:${TAG}
#docker push registry.heroku.com/catan-map-generator-seafarers/web:${TAG}
heroku container:push web --app catan-map-generator-seafarers
heroku container:release web -a catan-map-generator-seafarers
