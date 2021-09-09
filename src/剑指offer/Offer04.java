package 剑指offer;

public class Offer04 {

    public static void main(String[] args) {

        int[][] arr  = new int[][]{{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        Solution solution = new Solution();


        final boolean numberIn2DArray = solution.findNumberIn2DArray(arr, 5);
        System.out.println();
    }

    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if(matrix==null||matrix.length==0){
                return false;
            }
            for(int i=0;i<matrix.length;i++){
                int[] arr = matrix[i];
                int maxIdx=arr.length;
                int curMaxIdx = arr.length;
                for(int j=0;j<curMaxIdx;j++){
                    if(arr[j]==target){
                        return true;
                    }
                    if(target>arr[j] && j+1 <curMaxIdx){
                        maxIdx = j+1;
                    }else{
                        break;
                    }
                }
                curMaxIdx = maxIdx;
            }
            return false;
        }
    }
}
