package hashtable;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// ["TimeMap","set","set","get","set","get","get"]
// [[],["a","bar",1],["x","b",3],["b",3],["foo","bar2",4],["foo",4],["foo",5]]
class TimeStampNode {
    int timeStamp;
    String value;

    public TimeStampNode(int timeStamp, String value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}

public class TimeBasedKeyValStore {
    HashMap<String, List<TimeStampNode>> hashMap;

    public TimeBasedKeyValStore() {
        hashMap = new HashMap();
    }

    // //  set rahul verma 10
    public void set(String key, String value, int timestamp) {
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList());
        }

        hashMap.get(key).add(new TimeStampNode(timestamp, value));

    }

    public String get(String key, int timestamp) {
        // doesnt exist
        if (!hashMap.containsKey(key)) {
            return "";
        }

        List<TimeStampNode> values = hashMap.get(key);
        int index = binarySearch(timestamp, values);
        if (index == -1) {
            return "";
        }

        return values.get(index).value;
    }

    int binarySearch(int timeStamp, List<TimeStampNode> values) {
        int lo = 0;
        int hi = values.size() - 1;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (values.get(mid).timeStamp <= timeStamp) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

//  set rahul verma 10
//  set rahul singh 15
//  set rahul sharma 20

// BRUTE
//  HashMap
//  rahul -> [ (10, verma), (15, singh), (20, sharma)]

//  get rahul 11 -> verma
//  get rahul 16 -> singh


//  Set + Get = 10^5
