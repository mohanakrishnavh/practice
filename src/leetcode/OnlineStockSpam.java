package leetcode;

import java.util.Stack;

class StockSpanner {
    int index;
    Stack<int[]> stack;

    public StockSpanner() {
        index = 0;
        stack = new Stack<>();
    }

    public int next(int price) {
        index++;

        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }

        int span = stack.isEmpty() ? index : index - stack.peek()[1];
        stack.add(new int[]{price, index});

        return span;
    }
}

