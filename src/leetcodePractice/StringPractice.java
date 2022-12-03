package leetcodePractice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringPractice {
    public static void main(String[] args) {
        StringPractice obj = new StringPractice();
        obj.doStuff();
    }

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] a = new int[boxes.length()];
        for(int i=0; i<a.length; i++){
            a[i] = boxes.charAt(i) - '0';
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = getLeft(a,i) + getRight(a,i);
        }

        return ans;
    }
    private int getLeft(int[] a, int i){
        int ans = 0;
        for(int j = 1; i-j>=0; j++){
            ans += j*a[i-j];
        }
        return ans;
    }
    private int getRight(int[] a, int i){
        int ans = 0, n = a.length;
        for(int j=1; i+j<n; j++){
            ans+= j*a[i+j];
        }
        return ans;
    }

    private  void doStuff(){
        Map<String,Integer> mp = new HashMap<>();
        mp.put("aman",18);
        mp.put("shailendra", 20);
        mp.put("dileep",21);
        mp.put("ankit", 15);
        mp.put("boby",22);
        mp.put("manoj",24);

        mp.keySet().removeIf(key -> "dileep".equals(key));
        System.out.println(mp);

        Iterator<Map.Entry<String,Integer>> it = mp.entrySet().iterator();
        while(it.hasNext()){
            if(it.next().getKey().equals("boby")) it.remove();
        }
        System.out.println(mp);


        Iterator<String> it2 = mp.keySet().iterator();
        while (it.hasNext()){
            if(mp.get(it.next()) == 20) it.remove();
        }
        System.out.println(mp);
        /*
        for(String s : mp.keySet()){
            if("dileep".equals(s)){
                mp.remove(s);
            }
            System.out.println(s + "-> "+ mp.get(s));
        }

         */
    }
}
