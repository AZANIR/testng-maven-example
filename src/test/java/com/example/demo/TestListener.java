package com.example.demo;

import io.testomat.testng.TestomatioListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Custom TestNG listener that extends TestomatioListener
 * to report test results to Testomatio platform
 */
public class TestListener implements ITestListener {
    
    private final TestomatioListener testomatioListener = new TestomatioListener();
    
    @Override
    public void onTestStart(ITestResult result) {
        testomatioListener.onTestStart(result);
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        testomatioListener.onTestSuccess(result);
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        testomatioListener.onTestFailure(result);
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        testomatioListener.onTestSkipped(result);
    }
    
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        testomatioListener.onTestFailedButWithinSuccessPercentage(result);
    }
    
    @Override
    public void onStart(ITestContext context) {
        testomatioListener.onStart(context);
    }
    
    @Override
    public void onFinish(ITestContext context) {
        testomatioListener.onFinish(context);
    }
} 