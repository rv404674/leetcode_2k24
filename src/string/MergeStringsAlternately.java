package string;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i =0;
        int j=0;

        while(i<word1.length() && j<word2.length()){
            stringBuilder.append(word1.charAt(i));
            stringBuilder.append(word2.charAt(j));

            i++;
            j++;
        }

        while(i<word1.length()){
            stringBuilder.append(word1.charAt(i++));
        }

        while(j<word2.length()){
            stringBuilder.append(word2.charAt(j++));
        }

        return stringBuilder.toString();
    }
}
