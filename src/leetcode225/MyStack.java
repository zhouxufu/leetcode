package leetcode225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue = null;

    private Queue<Integer>  temp = null;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<> ();
        temp = new LinkedList<> ();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queue.size()==0) {
            throw new RuntimeException("stack is empty");
        }
        while (queue.size()>1){
            temp.add(queue.poll());
        }
       int result =  queue.poll();
        queue =temp ;
        temp = new LinkedList<>();
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (queue.size()==0) {
            throw new RuntimeException("stack is empty");
        }
        while (queue.size()>1){
            temp.add(queue.poll());
        }
        int result =  queue.peek();
        temp.add(result);
        queue =temp;
        temp = new LinkedList<>();
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
       return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */