#!/bin/bash

# Set the permissions for the PEM file
cd scripts || exit
chmod 600 bankai404.pem

# Define the EC2 instance details
ec2_user="ec2-user"
ec2_host="54.162.158.46"
pem_file="bankai404.pem"
remote_directory="/home/ec2-user/downloads"

# SSH into the EC2 instance and run Docker Compose
ssh -tt -i $pem_file $ec2_user@$ec2_host << EOF
cd $remote_directory
docker-compose down
docker-compose up -d
EOF

echo "Docker Compose has been executed on the EC2 instance."
