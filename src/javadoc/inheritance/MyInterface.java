package javadoc.inheritance;

public interface MyInterface {

    double PI = 3.14;

    default public void m1(){
        System.out.println("myInterface: m1");
    }
}