package com.tgtest.log4jkafka;

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
