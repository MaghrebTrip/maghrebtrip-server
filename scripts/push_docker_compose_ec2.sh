#!/bin/bash

# Set the permissions for the PEM file
chmod 600 bankai303.pem

# Define the destination directory on the EC2 instance
remote_directory="/home/ec2-user/downloads"

# Define the EC2 instance details
ec2_user="ec2-user"
ec2_host="100.25.156.241"
pem_file="bankai303.pem"

# Path to the local docker-compose.yml file
local_compose_file="maghrebtripservices/docker-compose.yml"

# Path to the remote docker-compose.yml file
remote_compose_file="$remote_directory/docker-compose.yml"

# Copy the docker-compose.yml file to the EC2 instance
scp -i $pem_file $local_compose_file $ec2_user@$ec2_host:$remote_compose_file

# SSH into the EC2 instance and run Docker Compose
ssh -i $pem_file $ec2_user@$ec2_host << EOF
cd $remote_directory
docker-compose down
docker-compose up -d
EOF

echo "Docker Compose has been executed on the EC2 instance."
