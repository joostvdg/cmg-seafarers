TAG=${1}
echo "TAG=${TAG}"
docker build -t cmg-seafarers:${TAG} .
# docker build -t cmg-seafarers --progress plain .