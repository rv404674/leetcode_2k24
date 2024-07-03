package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Element {
    String curString;
    int lastDigit;

    public Element(String curString, int lastDigit) {
        this.curString = curString;
        this.lastDigit = lastDigit;
    }
}

public class SequentialDigits {
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> sequentialDigits = new ArrayList<>();
        List<Element> elements = new ArrayList<>();
        int start = 12;
        int lastDigit = 3;

        while(start < 89){
            elements.add(new Element(Integer.toString(start), lastDigit));
            start += 11;
            lastDigit++;
        }

        for(Element element: elements){
            int curValue = Integer.parseInt(element.curString);
            if(curValue >= low){
                sequentialDigits.add(curValue);
                recurse(element.curString + element.lastDigit, lastDigit+1, low, high, sequentialDigits);
            }
        }


        if(high >= 89){
            sequentialDigits.add(89);
        }

        sequentialDigits.sort(null);
        return sequentialDigits;
    }

    public static void recurse(String curString, int lastDigit, int low, int high, List<Integer> sequentialDigits){
        int curInt = Integer.parseInt(curString);
        if(curInt < low || curInt > high){
            return;
        }

        sequentialDigits.add(curInt);

        recurse(curString+ Integer.toString(lastDigit), lastDigit+1, low, high, sequentialDigits);
    }

    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));
    }
}
