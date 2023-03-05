package javadoc.numbers;

public class M_Numbers {

    public static void main(String[] args) {

        numbers();
        String s1 = "100";
        String decimal1 = "10.123";
        String octal1 = "0100";
        String hexaDecimal1 = "0x8A";
        //String binary1 = "0b100"; // not valid

        String[] arr = {s1, octal1, hexaDecimal1};

        for(String s : arr){
            Integer i1 = Integer.decode(s);
            System.out.println(i1);
        }

        System.out.println(Integer.parseInt("100", 16));

        utilizeMathClass();

    }

    private static void utilizeMathClass(){
        double d1 = Math.exp(10);
        System.out.println(Math.log(0));
        System.out.println(d1);

        System.out.println(Math.sin(3.1415));

        System.out.println(Math.toRadians(180));

        System.out.println(Math.random()/1000);
    }

    private static void numbers(){
        Double d = 32.23;
        System.out.println(d.byteValue());

        String decimal1 = "12.567";

        Double i = Double.valueOf(decimal1);
        System.out.println(i);

        Integer i1 = Integer.valueOf(decimal1.substring(0,decimal1.indexOf(".")));
        System.out.println(i1);

        float f = Float.parseFloat(decimal1);
        System.out.println(f);
    }

}
