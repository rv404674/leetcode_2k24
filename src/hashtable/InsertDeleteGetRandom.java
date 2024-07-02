package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

class RandomizedSet{
    List<Integer> list;

    // (element, index);
    HashMap<Integer, Integer> hashMap;
    Random random;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.hashMap = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if(this.hashMap.containsKey(val)){
            return false;
        }

        // insert
        list.add(val);
        hashMap.put(val, this.list.size()-1);

        return true;
    }

    public boolean remove(int val) {
        if(!this.hashMap.containsKey(val)){
            return false;
        }

        // Deleting from end in an array is O(1).
        // Intelligently do that.
        int index = hashMap.get(val);
        int lastElement = list.get(list.size()-1);

        swap(index, list.size()-1);
        this.hashMap.put(lastElement, index);

        this.list.remove(list.size()-1);
        this.hashMap.remove(val);


        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return this.list.get(randomIndex);
    }

    public void swap(int p, int q){
        int temp = list.get(p);
        list.set(p, list.get(q));
        list.set(q, temp);
    }

}
public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.getRandom());
    }
}
