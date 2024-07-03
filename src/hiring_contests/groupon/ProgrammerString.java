package hiring_contests.groupon;

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
            // NOTE: should be greather than, not equal to.
            if(originalMap[i] > currentMap[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(programmerStrings("progxrammerrxproxgrammer"));

    }

}
