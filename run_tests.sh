#!/bin/bash

# Script for running tests with Testomatio Reporter

# Setting up Testomatio API key (optional)
# If you have a real Testomatio API key, uncomment the following line and replace YOUR_API_KEY with your key
# export TESTOMATIO_API_KEY="YOUR_API_KEY"

# Running tests with Maven
mvn clean test

# Output completion message
echo "Tests completed. Results reported to console." 