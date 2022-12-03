package javadocExamples;

public class OuterClass {
    int x = 5;

    String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    class InnerClass {
        // static int innerClassInt = 10; // throw exception
        static final int innerClassInt = 10;
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    static void firstLevelMethod(){
        int x = 10;

        class LocalClassInsideStaticMethod{
            int x = 15;
            int myVar;
            private void sampleMethod(OuterClass outherClassObject){
                // outherField = "can access it" // will throw exception
                int x = 20;
                staticOuterField = "modified Static outer field";
                System.out.println("x="+x);
                System.out.println("this.x = "+this.x);
                System.out.println("OuterClass.firstLevelMethod.x ="+ outherClassObject.x);
            }
        }
    }

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }
}

