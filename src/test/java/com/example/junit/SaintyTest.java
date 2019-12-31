package com.example.junit;

import org.junit.*;

public class SaintyTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.print("before class...\n");
    }
    @Before
    public void before(){
        System.out.print("before ...\n");
    }

    @After
    public void after(){
        System.out.print("after ...\n");
    }
    @Test
    public void someTest(){
        System.out.print("test ...\n");
    }

    @Test
    public void Test2(){
        System.out.print("test2 ...\n");
    }
    @AfterClass
    public static void afterClass(){
        System.out.print("after class...\n");
    }



}
