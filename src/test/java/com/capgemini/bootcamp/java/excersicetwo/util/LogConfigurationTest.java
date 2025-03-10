package com.capgemini.bootcamp.java.excersicetwo.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogConfigurationTest {
    @Test
    void createLogManager() {
        LogConfiguration logConfiguration = new LogConfiguration();
        assertNull(logConfiguration.processLog("bad/path/to/file.txt"));
    }
}