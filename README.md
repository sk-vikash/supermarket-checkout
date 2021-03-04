# Supermarket Checkout Application

## Overview

Repo contains java application for a supermarket checkout that calculates the total price for a number of items with and without discount given.

For demonstration purpose, a CSV file `data.json` is present inside directroy /src/main/resources containing detail of individual unit.

## Requirements

* Maven (3.5.4)
* Open JDK 1.8

## Installation

Clone the repository. Execute the Maven install goal to build the target .jar file.

## Technologies Used

* Open Java 1.8
* Spring dependency
* Maven
* Jetbrains IntelliJ IDEA CE

## Operation

The service operation is normally automated but can be manually operated

* Navigate root directory of this project
* Execute `mvn sortpom:sort` to sort the pom.xml
* Execute `mvn clean compile package` to generate the jar artifacts.
* Execute `java -jar target/sku-mgmt-1.0-SNAPSHOT.jar` from the command line to run the application.
* Execute `mvn test` for test coverage and check `index.html` generate inside `target` directory 

