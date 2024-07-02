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

// Problem - https://gist.github.com/neerajkumar/58d7a8c48dfb2675c2c444524f511a0a

class Result {

    /*
     * Complete the 'programmerStrings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int programmerStrings(String s) {
        // loop1 - iterate from left
        int[] programmerCountMap = new int[26];
        String origString = "programmer";
        for(Character c: origString.toCharArray()){
            programmerCountMap[c-'a']++;
        }

        // loop1 - iterate from left.
        int leftEndingIndex = 0;
        int[] processingMap = new int[26];
        for(int i=0; i<s.length(); i++){
            processingMap[s.charAt(i) - 'a']++;
            if(isMatch(programmerCountMap, processingMap)){
                leftEndingIndex = i;
                break;
            }
        }

        System.out.println(leftEndingIndex);

        // loop2 - iterate from right
        int[] processingMap2 = new int[26];
        int rightEndingIndex = 0;
        for(int i = s.length() - 1; i>=leftEndingIndex; i--) {
            processingMap2[s.charAt(i) - 'a']++;
            if(isMatch(programmerCountMap, processingMap2)) {
                rightEndingIndex = i;
                break;
            }
        }

        if(leftEndingIndex == rightEndingIndex){
            return 0;
        }

        return rightEndingIndex - leftEndingIndex -1;
    }

    public static boolean isMatch(int[] originalMap, int[] currentMap){
        for(int i=0; i<26; i++){
            if(originalMap[i] != currentMap[i]){
                return false;
            }
        }

        System.out.println("Returned true");
        return true;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.programmerStrings(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

"""
