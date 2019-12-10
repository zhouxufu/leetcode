package leetcode20;


import java.util.*;

/**
 * 利用栈解决 校验括号
 * @author 17640
 */
class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Character> map = new HashMap<>();
        map.put('[',']');
        map.put('{','}');
        map.put('(',')');

        Stack<Character> queue = new Stack<>();
        for (char aChar : chars) {
            if(map.values().contains(aChar)){
                if(queue.isEmpty()){
                    return false;
                }
                if (aChar !=map.get(queue.pop())) {
                    return false;
                }
            }else{
                queue.push(aChar);
            }
        }
        return true;
    }
}