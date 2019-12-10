package leetcode703;

import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> priorityQueue;

    private int k ;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>( (v1,v2)->v1.compareTo(v2));
        this.k = k;
        for (int num : nums) {
            if(priorityQueue.size()>=k){
                if (priorityQueue.peek()-num<0) {
                    priorityQueue.poll();
                    priorityQueue.offer(num);
                }
            }else{
                priorityQueue.offer(num);
            }
        }
    }

    public int add(int val) {
        if(priorityQueue.size()>=k){
            if (val-priorityQueue.peek()>0) {
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
        }else{
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}



/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */