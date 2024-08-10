package dp;

import java.util.Arrays;
import java.util.List;

class Movie {
    int startTime;
    int endTime;

    public Movie(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

public class Solution {
    public int computeMaxMovies(List<Movie> movies){
        movies.sort((a,b) -> Integer.compare(a.startTime, b.startTime));
        int[] dp = new int[movies.size()];
        Arrays.fill(dp, -1);

        return

    }


    public
}
public class MovieFestivalsGfg {

}
