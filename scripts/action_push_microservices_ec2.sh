#!/bin/bash

# Set the permissions for the PEM file
cd scripts || exit
chmod 600 bankai404.pem
cd ..

# Define an array of microservices and their respective resource files
declare -A microservices
microservices=(
    ["eureka-server"]=""
    ["tourist"]=""
    ["city"]="cities.csv"
    ["attraction"]="hotels.csv monuments.csv restaurants.csv"
    ["plan"]=""
    # ["feedback"]=""
    # ["trip"]=""
)

# Loop through each microservice
for microservice in "${!microservices[@]}"
do
    echo "Processing $microservice microservice..."

    # Build the scp command
    scp_command="scp -i scripts/bankai404.pem "

    # Add the JAR file to the scp command
    scp_command+="maghrebtripservices/$microservice/target/$microservice.jar "

    # Add the resource files to the scp command, if they exist
    if [[ -n "${microservices[$microservice]}" ]]; then
        IFS=' ' read -r -a resource_files <<< "${microservices[$microservice]}"
        for resource_file in "${resource_files[@]}"
        do
            scp_command+="maghrebtripservices/$microservice/target/classes/$resource_file "
        done
    fi

    # Add the destination to the scp command
    scp_command+="ec2-user@54.162.158.46:/home/ec2-user/downloads/$microservice"

    # Execute the scp command
    echo "Running: $scp_command"
    eval "$scp_command"
done

echo "All microservices have been processed successfully."