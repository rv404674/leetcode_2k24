package easy;

import java.util.HashMap;

public class LoggerRateLimiter {
    HashMap<String, Integer> msgTimeStampMap;

    public LoggerRateLimiter() {
        this.msgTimeStampMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!msgTimeStampMap.containsKey(message)) {
            msgTimeStampMap.put(message, timestamp + 10);
            return true;
        }

        if (timestamp < msgTimeStampMap.get(message)) {
            return false;
        }

        msgTimeStampMap.put(message, timestamp + 10);
        return true;
    }
}
