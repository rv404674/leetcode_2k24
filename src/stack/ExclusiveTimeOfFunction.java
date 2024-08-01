package stack;


import java.util.List;
import java.util.Stack;

// Dry Run once.
// NOTE:
// Assumption - the logs are sorted based on the times
// Valid input
// This wont be a input (0:start), (1,start), (0- end) - INVALID
// Valid (0:start), (1:start), (1:end)..

class ExclusiveTimeOfFunctionSolution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int lastExecutedTimestamp = 0;
        int[] executionTimes = new int[n];

        for (String log : logs) {
            // 0:start:0"
            String[] tokens = log.split(":");
            int functionId = Integer.parseInt(tokens[0]);
            String type = tokens[1];
            int curTime = Integer.parseInt(tokens[2]);

            if (type.equals("start")) {
                // if the stack is not empty.
                // it means same function has been called before. Add the time for it.
                if (!stack.isEmpty()) {
                    executionTimes[stack.peek()] += curTime - lastExecutedTimestamp;
                }

                lastExecutedTimestamp = curTime;
                stack.add(functionId);
            } else {
                executionTimes[stack.peek()] += curTime - lastExecutedTimestamp + 1;
                lastExecutedTimestamp = curTime + 1;
                stack.pop();
            }
        }

        return executionTimes;
    }
}

public class ExclusiveTimeOfFunction {
}
