package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api/project")
public class MavenProjectGeneratorController {

    @PostMapping("/generate")
    public ResponseEntity<String> generateProject(@RequestParam String groupId, @RequestParam String artifactId){
        try{
            String baseDir = "generated-project/" + artifactId;
            File projectDir = new File(baseDir + "/src/main/java" +groupId.replace('.','/'));
            File resourceDir = new File(baseDir + "src/main/java/resources");

            projectDir.mkdirs();
            resourceDir.mkdirs();

            String pomComponent = generatePomXml(groupId,artifactId);
            try(FileWriter pomWriter = new FileWriter(baseDir + "/pom.xml")){
                pomWriter.write(pomComponent);
            }
            return ResponseEntity.ok("Project generated at: "+ baseDir);

        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to generate project at: "+ e.getMessage());
        }
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
