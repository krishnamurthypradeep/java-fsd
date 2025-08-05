package com.myapp.fsd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaFullStackApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaFullStackApplication.class, args);
    }

}


// On every push/ pull request
// Checkout the code
// Set up Java
// Builds The Jar
// Builds Docker Image
// Publish it to Docker Hub

// Git
// Junit
// Maven
// CI Server (Github Actions)