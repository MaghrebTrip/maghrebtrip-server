#!/bin/bash

# Run clean package for the parent project
cd maghrebtripservices || exit
echo "Packaging the parent project..."
mvn clean install -DskipTests

# Run clean install for feign clients
cd feign-clients || exit
echo "Packaging the feign clients..."
mvn clean install -DskipTests
cd ..

# Define an array of microservice directories
microservices=("eureka-server" "tourist" "city" "attraction" "plan" "feedback" "trip")

# Loop through each microservice directory
for microservice in "${microservices[@]}"
do
    # Navigate into the microservice directory
    cd "$microservice" || exit

    # Run Maven clean and package commands
    echo "Packaging $microservice microservice..."
    mvn clean package -DskipTests

    # Navigate back to the parent directory
    cd ..
done

echo "All microservices packaged successfully."
