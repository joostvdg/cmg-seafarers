docker tag cmg-seafarers registry.heroku.com/catan-map-generator-seafarers/web
docker push registry.heroku.com/catan-map-generator-seafarers/web
heroku container:release web -a catan-map-generator-seafarers
