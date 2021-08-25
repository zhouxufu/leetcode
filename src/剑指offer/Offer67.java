package 剑指offer;

public class Offer67 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        final int i = solution.strToInt("-91283472332");
        System.out.println(i);
    }


    static class Solution {
        public int strToInt(String str) {
            int i = 0;
            boolean negative = false;
            int result = 0;

            while (str.length() > i && str.charAt(i) == ' ') {
                i++;
            }
            if (i > str.length() - 1) {
                return 0;
            }
            char c = str.charAt(i);
            if (c == '-' || c == '+') {
                if (c == '-') {
                    negative = true;
                }
                i++;
            }
            while (i < str.length()) {
                char c1 = str.charAt(i++);
                int num = c1 - '0';
                if (num < 0 || num > 9) {
                    break;
                }
                int maxValue = Integer.MAX_VALUE;
                if (negative) {
                    if (result > (maxValue/ 10)  ||result == (maxValue/ 10) && num >=8 ) {
                        return Integer.MIN_VALUE;
                    }

                } else {
                    if (result > (maxValue) / 10 || result == (maxValue/ 10) &&num >= 7 ) {
                        return Integer.MAX_VALUE;
                    }
                }
                result = result * 10 + num;
            }
            return negative ? -result : result;
        }
    }
}


