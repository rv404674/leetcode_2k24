package Adhoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AncestralNames {
    public static List<String> sortRoman(List<String> names) {
        return new ArrayList<>();


    }

    public static List<String> getAncestrolNames(List<String> names){
        List<String> ancestralNames = new ArrayList<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);


        for(String name: names){
            String[] tokens = name.split(" ");
            String romanName = tokens[0];
            String romanForm = tokens[1];

            int total = 0;
            for(int i=0; i<romanForm.length() - 1; i++){
                if(hashMap.get(romanForm.charAt(i)) < hashMap.get(romanForm.charAt(i+1))){
                    total = total + hashMap.get(romanForm.charAt(i)) - hashMap.get(romanForm.charAt(i+1));
                } else {
                    total = total + hashMap.get(romanForm.charAt(i)) + hashMap.get(romanForm.charAt(i+1));
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(romanName);
            stringBuilder.append(" ");
            stringBuilder.append(Integer.toString(total));

            ancestralNames.add(stringBuilder.toString());
        }

        return ancestralNames;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Smith IX");
        names.add("Johnson II");
        names.add("Williams IV");
        names.add("Brown I");
        names.add("Wilson III");
        names.add("Adams III");

        System.out.println(getAncestrolNames(names));
    }
}
