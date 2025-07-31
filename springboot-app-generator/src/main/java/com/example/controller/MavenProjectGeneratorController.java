package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api/project")
public class MavenProjectGeneratorController {

    @PostMapping("/generate")
    public ResponseEntity<String> generateProject(@RequestParam String groupId, @RequestParam String artifactId){
        String baseDir = "generated-project/" + artifactId;
        File projectDir = new File(baseDir + "/src/main/java" +groupId.replace('.','/'));
        File resourceDir = new File(baseDir + "src/main/java/resources");

        projectDir.mkdirs();
        resourceDir.mkdirs();

        String pomComponent = generatePomXml(groupId,artifactId);
        try(FileWriter pomWriter = new FileWriter(baseDir + "/pom.xml")){
            pomWriter.write(pomComponent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Project generated at: "+ baseDir);

    }
    private String generatePomXml(String groupId, String artifactId) {
        return """
            <project xmlns="http://maven.apache.org/POM/4.0.0"
                     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                     xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                                         http://maven.apache.org/xsd/maven-4.0.0.xsd">
                <modelVersion>4.0.0</modelVersion>
                <groupId>%s</groupId>
                <artifactId>%s</artifactId>
                <version>1.0.0-SNAPSHOT</version>
                <packaging>jar</packaging>
                <dependencies>
                    <dependency>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-starter</artifactId>
                        <version>3.2.0</version>
                    </dependency>
                </dependencies>
                <build>
                    <plugins>
                        <plugin>
                            <groupId>org.springframework.boot</groupId>
                            <artifactId>spring-boot-maven-plugin</artifactId>
                        </plugin>
                    </plugins>
                </build>
            </project>
        """.formatted(groupId, artifactId);
    }
}