package hiring_contests;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


class PerfectPairs {

    /*
     * Complete the 'getPerfectPairsCount' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

//    public static long getPerfectPairsCount(List<Integer> arr) {
//        // Write your code here
//        int ans = 0;
//        int n = arr.size();
//        long i = 0;
//        long j = 0;
//        arr.sort(null);
//
//        while (i < n && j < n) {
//            if (i == j) j++;
//            else if (i < j && 2 * Math.abs(v[i] < Math.abs(v[j]))) i++;
//            else if (i < j && 2 * Math.abs(arr.get((int) i)) >= Math.abs(v[j])) {
//                res += (j - i);
//                j++;
//            }
//        }
//
//        return res;
//    }

    // closest Numberes
    public static void closestNumbers(List<Integer> numbers) {
        List<int[]> ans = new LinkedList<>();

        numbers.sort(null);
        int mnDiff = Integer.MAX_VALUE;
        int n = numbers.size();

        for (int i = 0; i < n - 1; i++) {
            int temp = numbers.get(i + 1) - numbers.get(i);
            mnDiff = Math.min(mnDiff, temp);
        }

        for (int i = 0; i < n - 1; i++) {
            int temp = numbers.get(i + 1) - numbers.get(i);
            if (temp == mnDiff) {
                System.out.println(numbers.get(i) + " " + numbers.get(i + 1));
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> ut1 = Arrays.asList(-9, 6, -2, 1);
        System.out.println(getPerfectPairsCount(ut1));

        List<Integer> ut2 = Arrays.asList(4, 10, -7, 10, 33);
        System.out.println(getPerfectPairsCount(ut2));
    }

    public static long getPerfectPairsCount(List<Integer> arr) {
        int ans = 0;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                long mn = Math.min(Math.abs(arr.get(i) - arr.get(j)), Math.abs(arr.get(i) + arr.get(j)));
                long mx = Math.max(Math.abs(arr.get(i) - arr.get(j)), Math.abs(arr.get(i) + arr.get(j)));
                long absMn = Math.min(Math.abs(arr.get(i)), Math.abs(arr.get(j)));
                long absMx = Math.max(Math.abs(arr.get(i)), Math.abs(arr.get(j)));

                if (mn <= absMn && mx >= absMx) {
                    ans++;
                }
            }
        }

        return ans;
    }


}

//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine().replaceAll("\\s+$", "");
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        long result = Result.getPerfectPairsCount(arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
