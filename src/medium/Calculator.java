package medium;

import java.util.Stack;

public class Calculator {
    // Intuition - Process it all and keep it in form of a stack, then at the end sum them all.
    // Dry run - twice.
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int curNum = 0;
        char lastSeenOp = '+';

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);

            // is digit
            if (Character.isDigit(currentChar)) {
                curNum = curNum * 10 + Integer.parseInt(String.valueOf(currentChar));
            }

            // is a operation
            if (!Character.isDigit(currentChar) && currentChar != ' ' || i == s.length() - 1) {
                if (lastSeenOp == '+') {
                    stack.push(curNum);
                } else if (lastSeenOp == '-') {
                    stack.push(-curNum);
                } else if (lastSeenOp == '/') {
                    stack.push(stack.pop() / curNum);
                } else if (lastSeenOp == '*') {
                    stack.push(stack.pop() * curNum);
                }

                lastSeenOp = currentChar;
                curNum = 0;
            }
        }

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;

    }

    public static void main(String[] args) {
        String ut1 = "23+ 2/4 -10";
        System.out.println(calculate(ut1)); // 12

        String ut2 = "23+ 2*4 -10";
        System.out.println(calculate(ut2));
        // 21

        String ut3 = " 3 / 2";
        System.out.println(calculate(ut3));

    }


}
