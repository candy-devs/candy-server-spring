./gradlew bootBuildImage
docker tag candyss:latest rollrat/candyss:latest
docker push rollrat/candyss:latest