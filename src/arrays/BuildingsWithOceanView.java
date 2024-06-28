package arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuildingsWithOceanView {
    // O(N)
    // Space - 2*O(N)
    public int[] findBuildings(int[] heights) {
        List<Integer> ans = new ArrayList<>();
        int n = heights.length;
        int minHeight = Integer.MIN_VALUE;

        for(int i = n-1; i>=0; i--){
            if(heights[i] > minHeight){
                ans.add(i);
                minHeight = Math.max(heights[i], minHeight);
            }
        }

        int[] buildings = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            buildings[i] = ans.get(ans.size()-i-1);
        }

        return buildings;
    }

}
