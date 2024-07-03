package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// TODO:
// Appr1 - Recursion + comprator (solved 18/35 tc)
// Appr2 - Use memoization (try it yourself). O(n2) - TLE (30/35 passed).
// Either take and include the profit or not take.

// Appr3 - To find the next index, use BS. - (Onlogn).
// NOTE: also draw a recrusive tree yourself.

class Job {
    int starTime;
    int endTime;
    int profit;

    public Job(int starTime, int endTime, int profit) {
        this.starTime = starTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}

class JobComparator implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.starTime, o2.starTime);
    }
}

public class MaxProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for(int i=0; i<profit.length; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        sortBasedOnStartTime(jobs);
        int[] dp = new int[profit.length+1];
        Arrays.fill(dp, -1);

        return computeProfit(0, jobs.get(0).endTime, dp, jobs);
    }

    public int computeProfit(int index, int lastEndTime, int[] dp, List<Job> jobs){
        if(index >= jobs.size()){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        // If you are at last job, and you are taking it.
        int take = jobs.get(index).profit;
        int nextJobIndex = getNextIndexOptimized(index, jobs);
        if(nextJobIndex != -1){
            take = take + computeProfit(nextJobIndex, jobs.get(nextJobIndex).endTime, dp, jobs);
        }

        int notTake = computeProfit(index+1, lastEndTime, dp, jobs);

        dp[index] = Math.max(notTake, take);
        return dp[index];
    }

    public void sortBasedOnStartTime(List<Job> jobs){
        JobComparator comparator = new JobComparator();
        jobs.sort(comparator);
    }

    public int getNextIndex(int index, List<Job> jobs){
       for(int i = index; i<jobs.size(); i++){
           if(jobs.get(i).starTime >= jobs.get(index).endTime){
               return i;
           }
       }

       return -1;
    }

    // Binary Search
    public int getNextIndexOptimized(int index, List<Job> jobs){
        int lo = index+1;
        int hi = jobs.size()-1;
        int ans = -1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(jobs.get(index).endTime <= jobs.get(mid).starTime){
                hi = mid-1;
                ans = mid;
            } else {
                lo = mid+1;
            }
        }

        return ans;
    }

}
