package string;

public class CountAndSay {
    public static String countAndSay(int n) {
        String lastRLE = "1";
        for(int i=2; i<=n; i++){
            lastRLE = getRLE(lastRLE);
        }

        return lastRLE;

    }

    public static String getRLE(String s){
        if(s.equals("1")){
            return "11";
        }

        // 1 = 11
        // 111221 -> 31 22 11
        StringBuilder stringBuilder = new StringBuilder();
        Character lastChar = s.charAt(0);
        int k = 0;

        for(Character c : s.toCharArray()){
            if(lastChar == c){
                k++;
            } else {
                stringBuilder.append(k);
                stringBuilder.append(lastChar);

                k=1;
                lastChar = c;
            }

        }

        stringBuilder.append(k);
        stringBuilder.append(lastChar);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(6));
    }
}
