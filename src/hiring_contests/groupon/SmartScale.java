package hiring_contests.groupon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Problem Statemet - https://www.geeksforgeeks.org/minimum-number-of-distinct-elements-after-removing-m-items/
// Smart Scale (asked in groupon) - OA.

class ItemWithCount {
    int id;
    int count;

    public ItemWithCount(int id, int count) {
        this.id = id;
        this.count = count;
    }
}

class ItemWithCountComparator implements Comparator<ItemWithCount> {

    @Override
    public int compare(ItemWithCount o1, ItemWithCount o2) {
        return Integer.compare(o1.count, o2.count);
    }
}

class SmartScale {

    /*
     * Complete the 'deleteProducts' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ids
     *  2. INTEGER m
     */

    public static int deleteProducts(List<Integer> ids, int m) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for(int i: ids){
            hashmap.put(i, hashmap.getOrDefault(i, 0) + 1);
        }

        List<ItemWithCount> items = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: hashmap.entrySet()){
            items.add(new ItemWithCount(entry.getKey(), entry.getValue()));
        }

        items.sort(new ItemWithCountComparator());

        for(ItemWithCount item: items){
            if(item.count <= m){
                m -= item.count;
                hashmap.remove(item.id);
            }
        }

        return hashmap.size();
    }

}
