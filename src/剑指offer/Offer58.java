package 剑指offer;

public class Offer58 {


    public static void main(String[] args) {
        Solution solution = new Solution();

        final String abdc = solution.reverseLeftWords("abcdefg", 2);
        System.out.println(abdc);
    }
    public static class Solution {
        public String reverseLeftWords(String s, int n) {
            if( s==null||n==0){
                return s;
            }
            int num = n%s.length() ;
            if(num==0 ){
                return s;
            }
            char[] arr  = new char[s.length()];
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                arr[(i+s.length()-n)%s.length()] = c;
            }
            return new String(arr,0,s.length());

        }
    }
}
