package javadoc.inheritance;

import java.util.Objects;

public class Subclass1 extends Superclass implements Cloneable{

    int subField1;
    String subField2;

    void method1(){
        System.out.println("Subclass1: method1");
        super.method1();
        System.out.println("super.field1 = "+ super.field1);

    }
    public int getSubField1() {
        return subField1;
    }

    public void setSubField1(int subField1) {
        this.subField1 = subField1;
    }

    public String getSubField2() {
        return subField2;
    }

    public void setSubField2(String subField2) {
        this.subField2 = subField2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subclass1)) return false;
        Subclass1 subclass1 = (Subclass1) o;
        return subField1 == subclass1.subField1 && subField2.equals(subclass1.subField2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subField1, subField2);
    }

    @Override
    public Subclass1 clone(){
        try {
            Subclass1 clone = (Subclass1) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Subclass1{" +
                "subField1=" + subField1 +
                ", subField2='" + subField2 + '\'' +
                '}';
    }














    public static void main(String[] args) {
        Subclass1 mySubclass1Obj = new Subclass1();
        mySubclass1Obj.method1();
        mySubclass1Obj.setSubField1(32);
        mySubclass1Obj.setSubField2("second");

        Subclass1 mySubclass1Obj2 = new Subclass1();
        mySubclass1Obj2.setSubField1(32);
        mySubclass1Obj2.setSubField2("second");

        System.out.println(mySubclass1Obj2.equals(mySubclass1Obj));

        Subclass1 newSubclassObj1 = mySubclass1Obj.clone();
        System.out.println(newSubclassObj1);
        System.out.println(newSubclassObj1.toString());
        System.out.println(newSubclassObj1.hashCode());

        System.out.println(newSubclassObj1.equals(mySubclass1Obj));
        System.out.println(newSubclassObj1.equals(mySubclass1Obj2));


    }

}
