package easy;


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result =0;
        while(n!=0){
            System.out.println(            Integer.toBinaryString(n));

            result+=n&1;
            n=n>>>1;
        }
        return result;
    }

    public static void main(String[] args) {
//        long i =Long.parseLong("11111111111111111111111111111101", 2);
        int i =Integer.parseUnsignedInt("1111111111111111111111111111101", 2);
//        Solution solution  =new Solution();
//        solution.hammingWeight(-i);
//        System.out.println(i);

        i = -i;

        System.out.println(            Integer.toBinaryString(i>>>1));
        System.out.println(            Integer.toBinaryString(i>>1));

    }


}