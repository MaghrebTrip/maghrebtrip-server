#!/bin/bash

# Define an array of microservice directories
microservices=("eureka-server" "tourist" "city" "attraction" "plan")

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