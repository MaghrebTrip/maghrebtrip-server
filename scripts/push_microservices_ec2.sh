#!/bin/bash

# Set the permissions for the PEM file
chmod 600 bankai303.pem

# Define an array of microservices and their respective resource files
declare -A microservices
microservices=(
    ["eureka-server"]=""
    ["tourist"]=""
    ["city"]="cities.csv"
    ["attraction"]="hotels.csv monuments.csv restaurants.csv"
    ["plan"]=""
    ["feedback"]=""
    ["trip"]=""
    ["auth"]=""
)

# Loop through each microservice
for microservice in "${!microservices[@]}"
do
    echo "Processing $microservice microservice..."

    # Build the scp command
    scp_command="scp -i bankai303.pem "

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

    # Add the Dockerfile to the scp command
    scp_command+="maghrebtripservices/$microservice/Dockerfile "

    # Add the destination to the scp command
    scp_command+="ec2-user@100.25.156.241:/home/ec2-user/downloads/$microservice"

    # Execute the scp command
    echo "Running: $scp_command"
    eval "$scp_command"

    # Modify Dockerfile to use files directly in the folder
    ssh_command="ssh -i bankai303.pem ec2-user@100.25.156.241 "
    ssh_command+="\"sed -i 's|target/$microservice.jar|$microservice.jar|; "
    ssh_command+="s|target/classes/||g' /home/ec2-user/downloads/$microservice/Dockerfile\""

    # Execute the ssh command to modify the Dockerfile on the remote server
    echo "Modifying Dockerfile on remote server for $microservice microservice..."
    eval "$ssh_command"
done

echo "All microservices have been processed successfully."