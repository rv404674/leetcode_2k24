package Adhoc;

public class DecryptAMessage {

    // Was thinking correclty.
    // givenNo = (origNo + prevNo) - 26*4times.
    // origNo = (givenNo - prevNo) + 26*4times.
    static String decrypt(String word) {
        if (word.isEmpty()) {
            return "";
        }

        int prevNo = (int) word.charAt(0);
        StringBuilder ans = new StringBuilder(String.valueOf((char) (prevNo - 1)));

        for (char c : word.substring(1).toCharArray()) {
            int originalAscii = (int) c - prevNo;
            while (originalAscii < 97) {
                originalAscii += 26;
            }

            ans.append((char) originalAscii);
            prevNo += originalAscii;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        // debug your code below
        String word = "dnotq";
        String result = decrypt(word);
        System.out.println("Decrypted word: " + result);
    }
}
