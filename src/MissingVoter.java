import java.util.HashSet;
import java.util.Scanner;

public class MissingVoter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));

        int testCases = scanner.nextInt();
        while (testCases > 0) {
            int n = scanner.nextInt();
            String input1 = scanner.next();
            String input2 = scanner.next();

            String[] party1 = input1.split(" ");
            String[] party2 = input2.split(" ");

            int ans = -1;

            HashSet<Integer> party2HashSet = new HashSet<>();
            for (String temp : party2) {
                party2HashSet.add(Integer.parseInt(temp));
            }


            for (String temp : party1) {
                int party1Voter = Integer.parseInt(temp);
                if (!party2HashSet.contains(party1Voter)) {
                    ans = party1Voter;
                }
            }

            System.out.println(ans);
            testCases--;
        }
    }
}
