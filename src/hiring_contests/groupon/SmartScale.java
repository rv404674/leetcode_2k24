package hiring_contests.groupon;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// https://www.geeksforgeeks.org/minimum-number-of-distinct-elements-after-removing-m-items/
class ItemWithCount {
    int itemId;
    int count;

    public ItemWithCount(int itemId, int count){
        this.itemId = itemId;
        this.count = count;
    }
}

class ItemWithCountComparator implements Comparator<ItemWithCount> {
    @Override
    public int compare(ItemWithCount o1, ItemWithCount o2){
        return Integer.compare(o1.count, o2.count);
    }
}



class Result {

    /*
     * Complete the 'deleteProducts' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ids
     *  2. INTEGER m
     */

    public static int deleteProducts(List<Integer> ids, int m) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(Integer id: ids){
            hm.put(id, hm.getOrDefault(id, 0) + 1);
        }

        // create ItemWithCount list;
        List<ItemWithCount> items = new ArrayList();
        for(Map.Entry<Integer, Integer> entrySet: hm.entrySet()){
            items.add(new ItemWithCount(entrySet.getKey(), entrySet.getValue()));
        }

        ItemWithCountComparator comparator = new ItemWithCountComparator();
        items.sort(comparator);

        for(ItemWithCount item: items){
            if(item.count <= m){
                m -= item.count;
                hm.remove(item.itemId);
            }
        }

        return hm.size();

    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int idsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ids = IntStream.range(0, idsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.deleteProducts(ids, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
