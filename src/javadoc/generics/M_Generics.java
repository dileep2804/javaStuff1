package javadoc.generics;

import entity.Person;
import javadoc.inheritance.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NaturalNumber<T extends String & CharSequence>{
    private T n;
    NaturalNumber(T n){ this.n = n;}

    NaturalNumber() {
    }

    boolean isEven(){
        return false;
    }

    public void setN(T n) {
        this.n = n;
    }
}
public class M_Generics {
    public static void main(String[] args) {
        personUse();
        naturalNumberUse();
        rawUse();
        List<Integer> intList = new ArrayList<>();

        List l1 = new ArrayList();
        l1.add("Dileep");
        l1.add(21);
        l1.add(7.02);
        String myName = (String) l1.get(0);

        System.out.println(l1);

    }

    private static void naturalNumberUse() {
        NaturalNumber naturalNumber1 = new NaturalNumber();
//        naturalNumber1.setN(12);

//        NaturalNumber<Short> naturalNumber2 = new NaturalNumber<>();
//        naturalNumber2.setN((short) 2);

        System.out.println(naturalNumber1.isEven());
//        System.out.println(naturalNumber2.isEven());

        NaturalNumber<String> myObject = new NaturalNumber<>();


    }

    private static void rawUse(){
        List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(intList);

        ((List)intList).add("df");
        System.out.println(intList);

        List rawList = intList;
        rawList.add("Dileep");
        rawList.add('K');

        String s = (String) rawList.get(5);

        System.out.println(rawList);

        List<Integer> intList2 = rawList;
        System.out.println(intList2);


    }

    public static <T extends Comparable<T>> int countGreaterThen(T[] arr, T ele){
        int count = 0;
        for(T e : arr){
            if(e.compareTo(ele) > 0) ++count;
        }
        return count;
    }
    private static void personUse(){
        Person[] p = new Person[2];
        p[1]=new Person();
        p[0]=new Person();

        Arrays.stream(p).forEach(System.out::println);

        System.out.println(countGreaterThen(new Integer[]{1,2,3,4,5}, 2));
        System.out.println(countGreaterThen(p,new Person()));
    }

}
