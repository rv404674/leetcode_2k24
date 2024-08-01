package stack;

import java.util.Stack;

class Pair {
    int element;
    int count;

    public Pair(int element, int count) {
        this.element = element;
        this.count = count;
    }
}

public class StockSpanner {
    Stack<Pair> stack;

    public StockSpanner(Stack<Pair> stack) {
        this.stack = stack;
    }

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek().element <= price) {
            ans += stack.peek().count;
            stack.pop();
        }

        stack.add(new Pair(price, ans));
        return ans;
    }
}
