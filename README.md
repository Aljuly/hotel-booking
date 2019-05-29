# Hotel booking

> REST Spring Boot application

## Table of contents

* [General info](#general-info)
* [Features](#features)
* [Technologies](#technologies)
* [Running the application](#running-the-application)
* [Documentation](#documentation)
* [Status](#status)


## General info

This is Hotel Booking management system. This system allows user to register, view available rooms, make bookings for the specified dates. Also user can select some additional hotel services.   

## Features

This booking service allow to do the next:
 
1. View list of available rooms (room have a number, category, price, additional options like breakfast, cleaning with additional cost) for specified dates.
2. View rooms filtered by category.
3. Create user.
4. User can book the room for specified days.
5. User can view his booking.
6. User can get the total price of the booking (room for dates period + cost of additional options).
7. View all bookings for the hotel.

## Technologies

* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* [H2](https://www.h2database.com/) - Open-Source Embedded in-memory database management system
* [git](https://git-scm.com/) - Free and Open-Source distributed version control system 
* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)
* [Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

## Running the application

- Clone the Git repository.
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

## Documentation

* [Postman Collection](https://documenter.getpostman.com/view/5427906/S1TN8h7L) - online, with code auto-generated snippets in cURL
* [Swagger](http://localhost:8088/swagger-ui.html) - Documentation & Testing


## Status

Project is: _in progress_
