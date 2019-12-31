package com.example.junit;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class SysOutTestExecutionListener implements TestExecutionListener {
    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        System.out.println("in prepareTestInstance for class:"+ testContext.getTestInstance());
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        System.out.println("in beforeTestMethod for class:"+ testContext.getTestMethod().getName());
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        System.out.println("in afterTestClass for class:"+ testContext.getTestClass());
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        System.out.println("in afterTestMethod for class:"+ testContext.getTestMethod().getName());
    }

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        System.out.println("in beforeTestClass for class:"+ testContext.getTestClass());
    }
}
