package leetcode242;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null||t==null){
            return false;
        }
        if(s.length()!=t.length()){
            return false;
        }
        int[] arr1  = new int[26];
        int[] arr2  = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            arr1[c1-'a']++;
            arr2[c2-'a']++;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}