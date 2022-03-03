package leetcode;

import java.util.Stack;

class LC0901_OnlineStockSpan {
    int index;
    Stack<int[]> stack;

    public LC0901_OnlineStockSpan() {
        index = 0;
        stack = new Stack<>();
    }

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek()[1] <= price) {
            stack.pop();
        }

        int span = stack.isEmpty() ? ++index : ++index - stack.peek()[0];
        stack.add(new int[]{index, price});

        return span;
    }
}

