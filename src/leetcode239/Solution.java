package leetcode239;

import java.util.*;

/**
 * 滑动窗口最大值 解法一
 */
class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        int[] result = new int[nums.length - k + 1];
        if (nums.length == 0) {
            return nums;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (v1, v2) -> v2 - v1);
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(nums[i]);
        }
        //窗口第一个
        result[0] = priorityQueue.peek();
        for (int i = 0; i < nums.length - k; i++) {
            priorityQueue.remove(nums[i]);
            priorityQueue.offer(nums[k + i]);
            result[i + 1] = priorityQueue.peek();
        }
        return result;
    }
}

/**
 * 滑动窗口最大值 解法一
 */
class Solution2 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length * k == 0) {
            return nums;
        }
        if (length * k == 1) {
            return nums;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[length - k + 1];
        int logicWindowPop = 0;
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            while (deque.size() > 0 && num > deque.peek()) {
                deque.remove();
                logicWindowPop++;
            }
            deque.offer(num);
        }
        result[0] = deque.peek();
        for (int i = k; i < nums.length; i++) {
            int num = nums[i];
            if (logicWindowPop > 0) {
                logicWindowPop--;
            } else {
                deque.remove();
                ArrayDeque<Integer> tmpQueue = new ArrayDeque<>();
                int size = deque.size();
                for (int j = 1; j < size; j++) {
                    if (deque.getFirst() <= deque.getLast()) {
                        logicWindowPop++;
                        deque.removeFirst();
                    } else {
                        tmpQueue.addFirst(deque.pollLast());
                    }
                }
                while (tmpQueue.size() > 0) {
                    deque.addLast(tmpQueue.poll());
                }
            }
            while (deque.size() > 0 && num >= deque.peek()) {
                deque.remove();
                logicWindowPop++;
            }
            deque.offer(num);
            result[i - k + 1] = deque.peek();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-95, 92, -85, 59, -59, -14, 88, -39, 2, 92, 94, 79, 78, -58, 37, 48, 63, -91, 91, 74, -28, 39, 90, -9, -72, -88, -72, 93, 38, 14, -83, -2, 21, 4, -75, -65, 3, 63, 100, 59, -48, 43, 35, -49, 48, -36, -64, -13, -7, -29, 87, 34, 56, -39, -5, -27, -28, 10, -57, 100, -43, -98, 19, -59, 78, -28, -91, 67, 41, -64, 76, 5, -58, -89, 83, 26, -7, -82, -32, -76, 86, 52, -6, 84, 20, 51, -86, 26, 46, 35, -23, 30, -51, 54, 19, 30, 27, 80, 45, 22


        };
        //7777
        maxSlidingWindow(arr, 10);
    }
}