package work;

public class M_String {
    public static void main(String[] args) {
        boolean b = true;
        String s = m1();
        System.out.println(s);

        String trueValue = String.valueOf(true);
        String falseValue = String.valueOf(false);
        System.out.println(trueValue + ", " + falseValue);
    }
    static String m1(){
        return String.valueOf(Boolean.TRUE);
    }
}

