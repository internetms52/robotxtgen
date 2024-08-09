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
    <version>0.3.1</version>
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
        return RobotTextDataInstance.builder()
                .addUserAgentSection(
                        UserAgentSection.builder()
                                .userAgent("*")
                                .addDisallow("/private/")
                                .addAllow("/public/")
                                .crawlDelay(10)
                                .build()
                ).addUserAgentSection(
                        UserAgentSection.builder()
                                .userAgent("Googlebot")
                                .addDisallow("/google-specific/")
                                .build()
                ).addUserAgentSection(
                        UserAgentSection.builder()
                                .userAgent("Bingbot")
                                .addDisallow("/bing-specific/")
                                .build()
                ).addSiteMap("https://www.example.com/sitemap.xml")
                .host("www.example.com")
                .build();
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

## Support the Project
[!["Buy Me A Coffee"](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://www.buymeacoffee.com/rl8C1nu)

