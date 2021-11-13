package 剑指offer;

public class Offer10 {
    static  class Solution {
        public int numWays(int n) {
            int a = 1;
            int b = 1;
            if(n <=1){
                return 1;
            }
            int c = 0;
            for(int i=2;i<=n;i++){
                c=(a+b)%1000000007;
                a=b;
                b=c;
            }
            return c;
        }
    }

    public static void main(String[] args) {
        Solution s  =new Solution();
        final int i = s.numWays(7);
        System.out.println();
    }

}
