package com.forward.test;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalTest {
    @Test(expected = ArithmeticException.class)
    public void testDiv(){
        assertEquals(3,3/0);
    }

    @Ignore("十分简单了")
    @Test(timeout = 2000)
    public void testWhile(){
        while(true){
            System.out.println("run forever......");
        }
    }


    //性能测试，读取文件
    @Test(timeout = 3000)
    public void testReadFile1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Ignore("超时了")
    //性能测试，读取文件
    @Test(timeout = 2000)
    public void testReadFile2(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHello(){
    }
}
