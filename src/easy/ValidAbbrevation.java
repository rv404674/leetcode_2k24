package easy;

public class ValidAbbrevation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null)
            return false;

        int wordIndex = 0;
        int abbrIndex = 0;

        while (wordIndex < word.length() && abbrIndex < abbr.length()) {
            char c1 = word.charAt(wordIndex);
            char c2 = abbr.charAt(abbrIndex);

            if (c1 == c2) {
                wordIndex++;
                abbrIndex++;
            } else if (Character.isDigit(c2) && c2 != '0') {
                int skip = 0;
                while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    skip = skip * 10 + (abbr.charAt(abbrIndex) - '0');
                    abbrIndex++;
                }

                wordIndex += skip;
            } else {
                return false;
            }

        }

        return wordIndex == word.length() && abbrIndex == abbr.length();
    }


    public static void main(String[] args) {
        String word = "substitution";
        String abbr = "12";

        System.out.println(validWordAbbreviation(word, abbr));

    }
}
