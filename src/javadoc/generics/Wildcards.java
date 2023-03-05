package javadoc.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Wildcards {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3,4,5);
        printList(l1);


    }

    private static void printList(List<?> l){
        for(Object o : l){
            System.out.println(o);
        }
        System.out.println("----------");
    }

    void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
        Number temp = l1.get(0);
        //l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
        // got a CAP#2 extends Number;
        // same bound, but different types
        //l2.set(0, temp);	    // expected a CAP#1 extends Number,
        // got a Number
    }


    //solution
    void count(List<?> l){
        System.out.println(l.size());
    }

    //2 --> no cuz does not gurantee primitive
    <T> void swap(T[] arr){
        T t = arr[0];
        arr[0] = arr[1];
        arr[1] = t;
    }
    //4--> to encure type safely at compile time
    //7--> yes
    public static void print(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }

    //9 --> no
    //10 --> no cuz Node<Shape> is not super type of Node<Circle>
    //11 --> yes
    //12 -->
}
