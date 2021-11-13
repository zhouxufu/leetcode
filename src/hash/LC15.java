package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC15 {

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                return Collections.emptyList();
            }
            List<List<Integer>> res  =new ArrayList<>();
            Map<Integer, List<Set<Integer>>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j+=i+1) {
                    int key = nums[i] + nums[j];
                    List<Set<Integer>> lists = map.get(key);
                    if (lists == null) {
                        lists = new ArrayList<>();
                        map.put(key, lists);
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                List<List<Integer>> sets = map.get(-num);
                if (sets==null) {
                    continue;
                }
                for (List<Integer> set : sets) {
                    if (!set.contains(i) && set.size()==2) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[set.get(0)]);
                        list.add(nums[set.get(1)]);
                        res.add(list);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = {-1,0,1,2,-1,-4};
        final List<List<Integer>> lists = s.threeSum(arr);
        System.out.println(lists);

    }
}
