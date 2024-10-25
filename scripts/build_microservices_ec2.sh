#!/bin/bash

# Set the permissions for the PEM file
chmod 600 bankai404.pem

# Define an array of microservices
microservices=("eureka-server" "tourist" "city" "attraction" "plan")

# Remote server details
EC2_USER="ec2-user"
EC2_HOST="54.162.158.46"
PEM_FILE="bankai404.pem"

# Loop through each microservice
for microservice in "${microservices[@]}"
do
    echo "Building Docker image for $microservice microservice on EC2..."

    # Construct the SSH command to build the Docker image
    ssh_command="ssh -i $PEM_FILE $EC2_USER@$EC2_HOST "
    ssh_command+="\"cd /home/$EC2_USER/downloads/$microservice && "
    ssh_command+="docker build --tag=maghrebtrip/$microservice:latest -f Dockerfile .\""

    # Execute the SSH command
    echo "Running: $ssh_command"
    eval "$ssh_command"
done

echo "Docker images for all microservices have been built successfully."
