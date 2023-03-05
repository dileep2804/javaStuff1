package javadoc.strings;

import java.util.HashSet;
import java.util.Set;

public class StringsUse {

    public static void main(String[] args) {
        StringsUse obj = new StringsUse();

        obj.countPoints("B0B6G0R6R0R6G9");
        obj.replaceDigits("a1c1e1");

        String s = "Hey there! How are you?";

        char y = 'y';
        int firstI = s.indexOf(y);
        System.out.println(firstI);


    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String ans = "";
        for(String temps : arr){
            ans = (new StringBuilder(temps)).reverse().toString();
            ans += " ";
        }
        return ans.substring(0,ans.length()-1);

    }

    public int countPoints(String rings) {
        int n = rings.length();

        Set<Integer>[] arr = new Set[n];
        for(int i=0; i<n; i++) arr[i] = new HashSet<>();

        for(int i=0; i<n; i+=2){
            arr[rings.charAt(i+1) - '0'].add(rings.charAt(i)-'R');
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
            if(arr[i].size() == 3) {
                ans++;
            }
        }

        return ans;
    }

    public String replaceDigits(String s) {
        StringBuilder s1 = new StringBuilder("");
        char c1 = 'c' + 1;
        System.out.println(c1);

        for(int i=1; i<s.length(); i+=2){
            char c = (char) (s.charAt(i-1) + (s.charAt(i)-'0'));
            s1.append(s.charAt(i-1));
            s1.append(c);
        }
        System.out.println(s1);
        return s1.toString();
    }
}
