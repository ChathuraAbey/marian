package testsuite002;

import org.junit.Test;

public class pet {
    @Test
    public void method1()
    {
        System.out.println("function 001 ");
    }


    public String method2()
    {
        String a= "function 002";
        System.out.println("function 002");
        return a;

    }

    public Boolean method3()
    {
        Boolean a = true;
        System.out.println("function 003");
        return  a;
    }


    public Integer method4()
    {
        int a=4+4;
        System.out.println("function 004");
        return a;
    }

}
