# KafkaLogger
---
test for kafka-log4j-appender & kafka-clients 

### KafkaLogger.java
````package com.tgtest.log4jkafka;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class KafkaLogger {
    private static final Logger logger = Logger.getLogger(KafkaLogger.class);

    public static void main(String[] argv) {
        System.out.println("KafkaLogger Started");

        logger.debug("Debug message at KafkaLogger.main," );
        logger.info("Info message at KafkaLogger.main" );
        logger.warn("Warn message at KafkaLogger.main");
        logger.error("Error message at KafkaLogger.main" );

        System.out.println("Exiting KafkaLogger.main");
        LogManager.shutdown();
    }
}
````

### log4j.properties
````
# Root logger option
log4j.rootLogger=DEBUG, stdout, kafka
log4j.logger.kafka=WARN
log4j.logger.org.apache.kafka=WARN

# Redirect log messages to console
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

log4j.appender.kafka=org.apache.kafka.log4jappender.KafkaLog4jAppender
log4j.appender.kafka.brokerList=192.168.40.83:9092
log4j.appender.kafka.topic=kafkalogger
log4j.appender.kafka.layout=org.apache.log4j.PatternLayout
log4j.appender.kafka.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
log4j.appender.kafka.level=INFO
````

### pom.xml
````
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>tgtest-log4jappender</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.apache.kafka</groupId>
            <artifactId>kafka-log4j-appender</artifactId>
            <version>1.0.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.kafka</groupId>
            <artifactId>kafka-clients</artifactId>
            <version>2.8.0</version>
        </dependency>
    </dependencies>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>
</project>
````
