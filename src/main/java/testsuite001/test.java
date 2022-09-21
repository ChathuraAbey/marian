package testsuite001;
import org.junit.Test;
import testsuite002.pet;



public class test {
    pet obj1 = new pet();

 @Test
 public void run()
 {

  obj1.method1();

  String test= obj1.method2();
  System.out.println(test);

   Boolean  foo=obj1.method3();
   System.out.println(foo);


   Integer a= obj1.method4();
   System.out.println(a);
 }

}


