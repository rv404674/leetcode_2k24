package interviews;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'sortRoman' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY names as parameter.
     */

    public static int convertRomanToInt(String name){
        int total = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        for(int i=0; i<name.length(); i++) {
            int currentValue = hashMap.get(name.charAt(i));

            if(i+1< name.length() && hashMap.get(name.charAt(i+1)) > currentValue){
                total -= currentValue;
            } else {
                total += currentValue;
            }

        }

        return total;
    }

    public static List<String> sortRoman(List<String> names) {
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                String[] arr1 = s1.split(" ");
                String[] arr2 = s2.split(" ");

                int areNamesEqual = arr1[0].compareTo(arr2[0]);
                if(areNamesEqual == 0){
                    int val1 = convertRomanToInt(arr1[1]);
                    int val2 = convertRomanToInt(arr2[1]);
                    return Integer.compare(val1, val2);
                } else {
                    return areNamesEqual;
                }

            }
        });

        return names;

    }

}
public class TwilioHackerRankTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int namesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> names = IntStream.range(0, namesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.sortRoman(names);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

