package leetcodePractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringPractice {
    public static void main(String[] args) {
        chaloTest();
        StringPractice obj = new StringPractice();
        obj.doStuff(3, new int[]{0,1}, "RRDDLU");
    }

    static void chaloTest(){
        int n = 6;
        int[] arr = {1,2,5,7,9,10};

        int[] preSum = new int[n];
        preSum[0] = arr[0];

        int[] sufSum = new int[n];
        sufSum[n-1] = arr[n-1];

        for(int i=1; i<n; i++){
            preSum[i] = preSum[i-1] + arr[i];
            sufSum[n-1-i] = sufSum[n-i] + arr[n-1-i];
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(preSum));
        System.out.println(Arrays.toString(sufSum));

        int ans = Integer.MAX_VALUE;

        for(int i=1; i<n; i++){
            System.out.println("i="+i);
            int curl = getStuffDone(0,i-1,preSum,sufSum,arr);
            int curr = getStuffDone(i,n-1,preSum,sufSum,arr);

            if(curr + curl < ans) ans = curr + curl;
            System.out.println(curl +", "+ curr);
        }

        System.out.println(ans);

    }

    private static int getStuffDone(int l, int r, int[] preSum, int[] sufSum, int[] arr){
        if(l==r) return 0;
        if(r-l==1) return arr[r]-arr[l];

        System.out.println("l="+l+", r="+r);
        int m = (l+r)/2;
        int reqL = (m-l)*arr[m] - (preSum[m-1] - ((l==0) ? 0 :preSum[l-1]));
        int reqR = (preSum[r] - preSum[m]) - (r-m)*arr[m];

        System.out.println("reqL="+reqL+" reqR="+reqR);
        return reqL + reqR;
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

    private  void doStuff1(){
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

    private void doStuff(int n, int[] startPos, String s) {
        int res[] = new int[s.length()];

        for(int i=0; i<s.length(); i++){
            String sub = s.substring(i);
            int x=startPos[0], y=startPos[1];
            int ans = 0;
            for(char c : sub.toCharArray()){
                y+= c=='R' ? 1 : c=='L' ? -1 : 0;
                x+= c=='D' ? 1 : c=='U' ? -1 : 0;
                if(x<0 || y<0 || x>=n || y>=n) break;
                ans++;
            }
            res[i] = ans;
        }
        System.out.println(Arrays.toString(res));
    }
}
