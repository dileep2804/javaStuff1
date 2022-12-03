public class ControlFlowStatements {
    public static void main(String[] args) {
        int a = 10;
        Integer b = 10;
        if(b == null){
            a++;
        } else {
            System.err.println("b is not null");
        }

        System.out.println(a);
        int num = 23432;

        switch (num){
            case 2343 :{
                System.out.println("first");
                break;
            }
            case 23432 :{
                System.out.println("second");
                break;
            }
        }


        boolean c = true;

        search:
        for(int i=0; i<10; i++){
            for(int j = 0; j<10; j++){
                if(i*j == 49) {
                    System.out.println("found for i="+i+" ,j="+j);
                    break search;
                }
                System.out.println("inner for loop");
            }
            System.out.println("outer for loop");
        }

    }
}
