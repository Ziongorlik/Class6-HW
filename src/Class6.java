import org.testng.Assert;
import org.testng.annotations.*;

import java.io.PrintStream;

public class Class6 {

    // Exercise-1
    @AfterClass
    public void afterClass(){
        System.out.println("@AfterClass");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("@BeforeClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("@BeforeMethod");
    }

    @Test
    public void test(){
        System.out.println("@Test");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("@AfterMethod");
    }

    // Exercise-2
    @Test
    public void exercise2(){
        int x = 1;
        int y = 2;
        Assert.assertNotEquals(x,y);
    }

    // Exercise-3
    @Test(priority = 1)
    public void exercise3Test1(){
        System.out.println("A");
    }

    @Test(priority = 2)
    public void exercise3Test2(){
        System.out.println("B");
    }

    @Test(priority = 3)
    public void exercise3Test3(){
        System.out.println("C");
    }

    // Exercise-4
    @Test
    public void exercise4(){
        PrintStr printStr = new PrintStr();
        printStr.printString("I'm printing the string!!");
    }

}
