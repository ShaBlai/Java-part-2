package com.javatunes.personnel;
import org.junit.*;

public class LifecyleTest {

    @Before
    public void beforeTest() throws Exception {
        System.out.println("Before test runs");
    }

    @After
    public void afterTest() throws Exception {
        System.out.println("After test runs");

    }

    @BeforeClass
    public static void beforeTestRun() throws Exception {
        System.out.println("Before class runs");

    }

    @AfterClass
    public static void afterTestRun() throws Exception {
        System.out.println("After class runs");

    }

    @Test
    public void name() {
        System.out.println("test Something");
    }

    @Test
    public void names() {
        System.out.println("test Something Else");
    }

}
