package javadocExamples;


public class MyMainClass {

    public static void main(String[] args) {

        System.out.println("Outer class");
        System.out.println(OuterClass.staticOuterField);
        OuterClass.StaticNestedClass staticNesticObject = new OuterClass.StaticNestedClass();
        OuterClass outerObject = new OuterClass();
        System.out.println(outerObject.outerField);
        staticNesticObject.accessMembers(outerObject); nl();


        System.out.println("Inner class:");
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers(); nl();


        System.out.println("Static nested class:"); nl();
//        OuterClass.StaticNestedClass staticNestedObject = new OuterClass.StaticNestedClass();
//        staticNestedObject.accessMembers(outerObject);
//
//        System.out.println("Top-level class:");
//        TopLevelClass topLevelObject = new TopLevelClass();
//        topLevelObject.accessMembers(outerObject);
    }

    public static void nl(){
        System.out.println("------------");
    }
}
