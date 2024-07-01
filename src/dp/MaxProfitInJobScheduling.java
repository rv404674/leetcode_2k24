package dp;

import java.util.ArrayList;
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
    int mxProfit = -1;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for(int i=0; i<profit.length; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        sortBasedOnStartTime(jobs);

        for(int i=0; i<jobs.size(); i++){
            computeProfit(i, jobs.get(i).endTime, jobs.get(i).profit, jobs);
        }
        return mxProfit;
    }

    public void computeProfit(int index, int lastEndTime, int curProfit, List<Job> jobs){
        mxProfit = Math.max(curProfit, mxProfit);

        if(index == jobs.size()){
            return;
        }

        for(int i=index; i<jobs.size(); i++){
            if(jobs.get(i).starTime >= lastEndTime){
                computeProfit(i+1, jobs.get(i).endTime, curProfit + jobs.get(i).profit, jobs);
            }
        }

    }

    public void sortBasedOnStartTime(List<Job> jobs){
        JobComparator comparator = new JobComparator();
        jobs.sort(comparator);
    }


}
