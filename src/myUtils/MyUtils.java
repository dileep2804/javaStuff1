package myUtils;

import entity.Person;

import java.util.Collection;

/**
 * this class currently offers print methods for printing some basic requirements
 * (for ex.- Object type or subtype, Collection type or subtype
 */
public class MyUtils {
    public static void nl(){
        System.out.println("----------");
    }

//    public static void print(Object o){
//        System.out.println(o);
//    }

    public static void print(String message, Object o){
        System.out.println(message + ": " + o);
    }

    public static <E> void print(Collection<Person> coll){
        coll.forEach(e -> System.out.println(e.getName() + "(" + e.getAge() + ", "+ e.getEmailAddress() + ", "
                + e.getGender()+")"));
    }

    public static void print(String message, Collection<Person> coll){
        System.out.print(message + ":\n");
        coll.forEach(e -> System.out.println(e.getName() + "(" + e.getAge() + ", "+ e.getEmailAddress() + ", "
                + e.getGender()+")"));
    }
}
