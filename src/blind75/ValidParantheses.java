package blind75;

import java.util.Stack;

public class ValidParantheses {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '[' || c == '(' || c == '{')
                    stack.push(c);
                else {
                    if (stack.isEmpty())
                        return false;

                    char topChar = stack.pop();
                    if (c == ']' && topChar != '[') {
                        return false;
                    } else if (c == ')' && topChar != '(') {
                        return false;
                    } else if (c == '}' && topChar != '{') {
                        return false;
                    }
                }

            }

            if (!stack.empty())
                return false;

            return true;
        }

    }
}
