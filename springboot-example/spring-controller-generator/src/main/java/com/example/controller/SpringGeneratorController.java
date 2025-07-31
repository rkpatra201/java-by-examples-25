package com.example.controller;

import com.example.models.SpringProjectRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class SpringGeneratorController {
    @PostMapping("/generate/project")
    public ResponseEntity<String> generateProject(@RequestBody SpringProjectRequest request) {
        try {

            String basePath = "/Users/biswajitjena/Biswajit_dir/java-core-practice/java-by-example-25/springboot-example/spring-controller-generator/generated-projects/" + request.getArtifactId();

//            String basePath = System.getProperty("user.dir") + "/generated-projects/" + request.getArtifactId();
//            String basePath = "generated-projects/" + request.getArtifactId();
            File baseDir = new File(basePath);
            boolean created = baseDir.mkdirs();
            System.out.println("Base directory: " + baseDir.getAbsolutePath());
            System.out.println("Was directory created? " + created);
            System.out.println("Does directory now exist? " + baseDir.exists());
            baseDir.mkdirs();

            // Create directories
            new File(basePath + "/src/main/java").mkdirs();
            new File(basePath + "/src/test/java").mkdirs();

            // Create pom.xml
            String pomContent = generatePomContent(request.getGroupId(), request.getArtifactId());
            Files.write(Paths.get(basePath + "/pom.xml"), pomContent.getBytes());
            File pomFile = new File(basePath + "/pom.xml");
            System.out.println("pom.xml created? " + pomFile.exists());
            System.out.println("pom.xml absolute path: " + pomFile.getAbsolutePath());

            return ResponseEntity.ok("Project generated at " + basePath);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error generating project: " + e.getMessage());
        }
    }

    private String generatePomContent(String groupId, String artifactId) {
        return "<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                "         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0\n" +
                "         http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
                "    <modelVersion>4.0.0</modelVersion>\n" +
                "    <groupId>" + groupId + "</groupId>\n" +
                "    <artifactId>" + artifactId + "</artifactId>\n" +
                "    <version>0.0.1-SNAPSHOT</version>\n" +
                "    <properties>\n" +
                "        <maven.compiler.source>17</maven.compiler.source>\n" +
                "        <maven.compiler.target>17</maven.compiler.target>\n" +
                "    </properties>\n" +
                "</project>";
    }

}
