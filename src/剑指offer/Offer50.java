package 剑指offer;

public class Offer50 {


    public static void main(String[] args) {
        String leetcode  ="leetcode";
        Solution s= new Solution();
        final char c = s.firstUniqChar(leetcode);
        System.out.println();
    }

   static class Solution {
        public char firstUniqChar(String s) {

            if(s==null||s.length()==0){
                return ' ';
            }
            int[] arr = new int[128];
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                arr[c] = ++arr[c];
            }
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(arr[c] ==1){
                    return (char)c;
                }
            }
            return ' ';
        }
    }
}
