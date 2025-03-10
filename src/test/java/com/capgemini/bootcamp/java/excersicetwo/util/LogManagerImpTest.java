package com.capgemini.bootcamp.java.excersicetwo.util;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.io.IOException;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

class LogManagerImpTest {
    @Spy
    LogManager logManager;

    @Test
    void createLog() throws IOException {
        LogManager logManager = new LogManagerImp("test.log");
        logManager.createLog(Level.INFO, "Test");
    }

    @Test
    void createLogException() {
        assertThrows(Exception.class, () -> new LogManagerImp("invalid/path/to/file/test.log"));
    }
}