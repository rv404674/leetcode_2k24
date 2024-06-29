package hashtable;

import java.util.HashSet;

// Really good hashtable problem.
// See this to get an idea
// https://www.youtube.com/watch?v=TjFXEUCMqI8
public class ValidSudoko {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i=0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    continue;
                }

                Character c = board[i][j];
                // Quite intuitive to figure out.
                int boxIndex = 3*(i/3) + (j/3);
                if(rows[i].contains(c) || cols[j].contains(c) || boxes[boxIndex].contains(c)){
                    return false;
                }

                rows[i].add(c);
                cols[j].add(c);
                boxes[boxIndex].add(c);
            }
        }


        return true;
    }

}
