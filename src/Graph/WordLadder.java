package Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Node {
    String element;
    int level;

    public Node(String element, int level) {
        this.element = element;
        this.level = level;
    }
}

class WordLadderSolution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(beginWord, 1));
        visited.add(beginWord);

        String allChars = "abcbdefghijklmnopqrstuvwxyz";

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            if (curNode.element.equals(endWord)) {
                return curNode.level;
            }

            for (int i = 0; i < curNode.element.length(); i++) {
                for (char c : allChars.toCharArray()) {
                    // NOTE: use char array to manipulate it and then do stuff.
                    char[] array = curNode.element.toCharArray();
                    array[i] = c;

                    String newString = new String(array);
                    if (wordSet.contains(newString) == false || visited.contains(newString) == true) {
                        continue;
                    }

                    visited.add(newString);
                    q.offer(new Node(newString, curNode.level + 1));
                }
            }

        }

        return 0;
    }

}

public class WordLadder {
    public static void main(String[] args) {
        WordLadderSolution solution = new WordLadderSolution();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(solution.ladderLength("hit", "cog", wordList));
    }
}
