package com.capgemini.bootcamp.java.excersicetwo.util;

import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.logging.Level;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductAspectTest {
    private ProductAspect productAspect;

    @Mock
    private LogManager logManager;

    @Mock
    private JoinPoint joinPoint;

    @BeforeEach
    void configuration(){

        productAspect = new ProductAspect(logManager);
    }

    @Test
    void getControllerFunction() {
        productAspect.getControllerFunction();
    }

    @Test
    void createControllerFunctions() {
        productAspect.createControllerFunctions();
    }

    @Test
    void getServiceFunction() {
        productAspect.getServiceFunction();
    }

    @Test
    void createServiceFunctions() {
        productAspect.createServiceFunctions();
    }

    @Test
    void getFunctions() {
        productAspect.getFunctions();
    }

    @Test
    void createFunctions() {
        productAspect.createFunctions();
    }

    @Test
    void beforeGet() {

        doNothing().
                when(logManager).createLog(any(Level.class), anyString());

        productAspect.beforeGet(joinPoint);
        verify(logManager, new Times(1)).createLog(any(Level.class), anyString());
    }

    @Test
    void beforeCreate() {

        doNothing().
                when(logManager).createLog(any(Level.class), anyString());

        productAspect.beforeCreate(joinPoint);
        verify(logManager, new Times(1)).createLog(any(Level.class), anyString());
    }
}