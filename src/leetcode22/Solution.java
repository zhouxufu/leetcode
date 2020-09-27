package leetcode22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        doGen(list, 2 * n, n, n, "");
        return list;
    }


    private void doGen(List<String> list, int n, int left, int right, String s) {
        if (s.length() == n) {
            list.add(s);
            return;
        }
        if (left > 0 && left >= right) {
            doGen(list, n, left-1, right, s + "(");
        } else {
            if (left > 0) {
                doGen(list, n, left-1, right, s + "(");
            }
            doGen(list, n, left, right-1, s + ")");
        }
    }
}