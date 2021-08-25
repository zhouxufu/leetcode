package 剑指offer;

import java.util.Stack;

public class Offer30 {


    static class MinStack {
        Stack stack = null;
        Stack minStack = null;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack();
            minStack = new Stack();
        }

        public void push(int x) {
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                if ((int) minStack.peek() >= x) {
                    minStack.push(x);
                } else {
                    minStack.push(minStack.peek());
                }
            }
            stack.push(x);
        }

        public void pop() {
            minStack.pop();
            stack.pop();
        }

        public int top() {
            return (int) stack.peek();
        }

        public int min() {
            return (int) minStack.peek();
        }
    }


}
