package com.example.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.context.TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:test/applicationContext.xml")
@TestExecutionListeners(
        value = SysOutTestExecutionListener.class,
        mergeMode = MERGE_WITH_DEFAULTS)
public class TestExecutsionListener {
    @Test
    public void someTest() throws Exception {
        System.out.println("executing someTest>>>>");
    }
    @Test
    public void someOtherTest() throws Exception {
        System.out.println("executing someOtherTest>>>>>>");
    }
}
