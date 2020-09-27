package leetcode424;

class Solution {
    public int characterReplacement(String s, int k) {

        //todo
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        String maxStr = "";
        Character prev = null;
        int copyK = k;
        boolean start = true;
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            if (start) {
                stringBuilder.append(aChar);
                prev = aChar;
                start = false;
            } else {
                if (prev == aChar) {
                    stringBuilder.append(aChar);
                } else {
                    if (copyK > 0) {
                        copyK--;
                        stringBuilder.append(aChar);
                    } else {
                        String s1 = stringBuilder.toString();
                        if (s1.length() > maxStr.length()) {
                            maxStr = s1;
                        }
                    }
                }
            }
        }
        return maxStr.length();
    }
}