//package Adhoc;
//
//public class RevealCards {
//
//    // Assumptions
//// 1. all lower chars
//// 2. max ascii - 122
//    class Solution {
//
//        static String decrypt(String word) {
//            String ans = "";
//            int prev = 0;
//            for(int i=0; i<word.length(); i++){
//                char c = word.charAt(i);
//
//                if(i==0){
//                    char temp = (char)((int)c - 1);
//                    ans.(temp);
//                    prev = (int)c;
//                    continue;
//                }
//
//                int asciLeft = (int) c - prev;
//                while(asciLeft < 97){
//                    asciLeft+=26;
//                }
//
//                prev += asciLeft;
//                ans.append((char)asciLeft);
//            }
//
//            return ans;
//
//        }
//
//        public static void main(String[] args) {
//            // debug your code below
//            String word = "dnotq";
//            String result = decrypt(word);
//            System.out.println("Decrypted word: " + result);
//        }
//    }
//
//
//}
