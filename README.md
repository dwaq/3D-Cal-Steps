3D-Cal-Steps
============

Java program used to easily calculate the the modified step-per-mm value for a 3D printer. 

This is for a desktop app. In the future I would like to make a web-based app as well.

There is no error checking. Feel free to enter any characters you want into the text boxes, but only numbers (and decimal points) will allow the "Calculate" button to produce the new steps-per-mm value.

####Running on Linux####
1. Install the java compiler:

  `sudo apt-get update`

  `sudo apt-get install openjdk-6-jdk`

2. Compile it using `javac`

  `javac CalSteps.java`
  
3. Run it using `java`

  `java CalSteps`

This work is licensed under a Creative Commons Attribution 3.0 Unported License.
