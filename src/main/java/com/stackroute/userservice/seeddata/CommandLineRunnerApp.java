package com.stackroute.userservice.seeddata;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

//         Running Logic on Startup in Spring. Create seed data to pre-fill the database with track
//information whenever the application starts. Use both approaches:
//CommandLineRunner (Find out how it differs from ApplicationRunner)
@Component
public class CommandLineRunnerApp implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(com.stackroute.userservice.seeddata.CommandLineRunnerApp.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("App started in command line .", Arrays.toString(args));
    }
}