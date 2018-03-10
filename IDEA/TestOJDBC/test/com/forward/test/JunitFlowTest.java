package com.forward.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/*@BeforeClass他会在所有的方法运行前被执行，static修饰，测试类被运行就会被加载，在内存中只有一份实例，适合加载配置文件。*/
    /*@AfterClass 他会在所有方法运行结束后被执行，static修饰，用于资源的清理，如关闭数据库。*/

    /*@Before：会在每一个测试方法被运行前执行一次*/

    /*@After 会在每个测试方法被运行后执行一次*/

/*@Ignore 所修饰的测试方法会被测试运行器忽略*/
public class JunitFlowTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("this is setUpBeforeClass()...");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("this is tearDownAfterClass()...");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("this is setUp()...");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("this is tearDown()...");
    }

    @Test
    public void test() {
        System.out.println("this is test()...");
    }

    @Test
    public void test2() {
        System.out.println("this is test2()...");
    }

    @Test
    public void testDiv(){
        System.out.println("hello");
        assertEquals(3,3);
    }
}
/* @Test:将一个普通的方法修饰成为一个测试方法
@Test(expected=XX.class)
@Test(timeout=毫秒)
        * @BeforeClass：它会在所有的方法运行前被执行，static修饰
        * @AfterClass:它会在所有的方法运行结束后被执行，static修饰
        * @Before：会在每一个测试方法被运行前执行一次
        * @After：会在每一个测试方法运行后被执行一次
        * @Ignore:所修饰的测试方法会被测试运行器忽略
        * @RunWith:可以更改测试运行器 org.junit.runner.Runner*/