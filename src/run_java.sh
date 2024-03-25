#!/bin/bash

# Name of the Java file (without the .java extension)
JAVA_FILE="Control"

# Compile the Java program
javac ${JAVA_FILE}.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    # Run the compiled Java program
    java ${JAVA_FILE}
else
    echo "Compilation failed. Exiting..."
fi
