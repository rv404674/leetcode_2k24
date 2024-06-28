package string;

public class ValidPalindrom2 {
    public boolean validPalindrome(String s) {
        int n = s.length();
        if(n==1){
            return true;
        }

        int left = 0;
        int right = n -1;
        while(left < right){
            // skip left and skip right;
            if(s.charAt(left) != s.charAt(right)){
                return expandAroundIndices(s, left+1, right) || expandAroundIndices(s, left, right-1);
            }

            left +=1;
            right -=1;
        }

        return true;
    }

    public static boolean expandAroundIndices(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i+=1;
            j-=1;
        }

        return true;
    }

}
