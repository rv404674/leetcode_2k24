package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// TODO:
// Appr1 - Recursion + comprator (solved 18/35 tc)
// Appr2 - Use memoization (try it yourself).
// Optimized approaches
// Video - 1 https://www.youtube.com/watch?v=LL0tVxlAeV4
// Video - 2 https://www.youtube.com/watch?v=JLoWc3v0SiE

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

        int notTake = computeProfit(index+1, lastEndTime, dp, jobs);

        int nextJobIndex = getNextIndex(jobs.get(index).endTime, jobs);
        int take = jobs.get(nextJobIndex).profit + computeProfit(nextJobIndex, jobs.get(nextJobIndex).endTime, dp, jobs);

        dp[index] = Math.max(notTake, take);
        return dp[index];
    }

    public void sortBasedOnStartTime(List<Job> jobs){
        JobComparator comparator = new JobComparator();
        jobs.sort(comparator);
    }

    public int getNextIndex(int endTime, List<Job> jobs){
        int lo = 0;
        int hi = jobs.size();
        int ans = -1;
        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(jobs.get(mid).starTime >= mid){
                ans = mid;
                break;
            } else {
                lo = mid+1;
            }
        }

        return ans;
    }

}
