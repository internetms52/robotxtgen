# robotxtgen

robot.txt generator

## Overview
A Maven plugin for generating robots.txt files. 
It enables a 'robots.txt as code' approach through custom class-based content definition.

## components
1. API：robots.txt generate api
2. Maven Plugin： robotxtgen-api with maven-plugin integration.

## Getting Started
Follow these steps to integrate and use the robotxtgen-maven-plugin in your project:
### Step 1: Add the API Dependency
```xml
<dependency>
    <groupId>io.github.internetms52</groupId>
    <artifactId>robotxtgen-api</artifactId>
    <version>0.2.1</version>
</dependency> 
```
### Step 2: Implement the Configuration Class
```java 
import io.github.internetms52.robotxt.api.RobotTextConfigProvider;
import io.github.internetms52.robotxt.api.RobotTextDataInstance;

public class MyRobotTextConfig implements RobotTextConfigProvider {
    @Override
    public RobotTextDataInstance robotTextDataInstance() {
        // Implement this method to return your RobotTextDataInstance
        // This is where you define the content of your robots.txt
        List<UserAgentSection> userAgentSectionList = new ArrayList<>();
        List<String> disallow = new ArrayList<>();
        disallow.add("/private/");
        List<String> allow = new ArrayList<>();
        allow.add("/public/");
        userAgentSectionList.add(new UserAgentSection(
                "*",
                disallow,
                allow,
                10,
                null,
                null
        ));
        List<String> sitemaps = new ArrayList<>();
        sitemaps.add("https://www.example.com/sitemap.xml");
        return new RobotTextDataInstance(
                userAgentSectionList,
                sitemaps,
                "www.example.com"
        );
    }
}
```
### Step 3: Add the Maven Plugin
```xml
<plugin>
    <groupId>io.github.internetms52</groupId>
    <artifactId>robotxtgen-maven-plugin</artifactId>
    <version>0.2.1</version>
    <configuration>
        <configClass>com.example.MyRobotTextConfig</configClass>
    </configuration>
    <executions>
        <execution>
            <goals>
                <goal>generate-robotstxt</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
### Step 4: Run the Build
By default, the plugin generates the robots.txt file in the `target` directory.
```
mvn clean compile 
```


