package interviews;

/*
 * Click `Run` to execute the snippet below!
 */

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!
// Assumptions
// 1. 9*9 grid. (only +ve numbers)
// 2. Partially filled / fully filled (can b)
// (empty square is 0)
//
// check 1
// if the number is [1-9], return false.
// return (boolean - true or false)


// RowHashTabel
// (key (int), val (Set<Int>))
// {
//  0: (1,2,3),
//  1: (5,6)
// }

// ColnHashTable
// {
//
// }

// (i,j) (i for row, j is column)
// grid[i][j] (integer)
// rowHashTable.get(i)
// colmHashTable.get(j)

// 1 0 2 3
// 4 1 8 7
// 6 7 5 4

// (i,j)
// GridHashTable
// (i,j) -> key
// (i+2, j+2)

// (0,0) - (2, 2)

// (0 (row),1 (column)) - (2, 3)
// gridHashTable

// {
// i = (0,8)
// j = (0,8)
// (0,0)
// (0,3)
// (0,6)

// preprocessing
// [ key = (0,0), vlau(hashtable) = [ 5:1, ..]]
// for(int i=0; i<9; i+=3)
// for(j = 0; j<9; j+=3)
//
//.    // fill the hashmap

//     {5, 1, 7, 6, 9, 8, 2, 3, 4},
//     {2, 8, 9, 1, 3, 0, 7, 5, 0},
//     {3, 4, 6, 2, 7, 5, 8, 9, 1},
//     {6, 7, 2, 0, 4, 9, 3, 1, 5},
//     {1, 3, 8, 5, 2, 6, 9, 4, 0},
//     {9, 5, 4, 7, 0, 3, 6, 8, 2},
//     {4, 9, 5, 0, 6, 2, 1, 7, 8},
//     {7, 2, 3, 4, 8, 1, 5, 6, 9},
//     {8, 6, 1, 0, 5, 7, 4, 2, 3},
// };

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class ConfluentRound3 {
    public boolean isValidGrid(int[][] grid) {
        HashMap<Integer, Set<Integer>> rowHashMap = new HashMap<>();
        HashMap<Integer, Set<Integer>> columnHashMap = new HashMap<>();

        // initiazlie
        for (int i = 0; i < 9; i++) {
            rowHashMap.put(i, new HashSet<>());
            columnHashMap.put(i, new HashSet<>());
        }

        if (isValidSudoko(grid, rowHashMap, columnHashMap)) {
            // invalid sudok - return false.
            return false;
        }

        // HashMap<Integer, HashMap<Integer, Integer>> gridHashTable = new HashMap();

        return true;
    }

    public static boolean isValidSudoko(int[][] grid,
                                              HashMap<Integer, Set<Integer>> rowHashmap,
                                              HashMap<Integer, Set<Integer>> columnHashMap) {

        int row = grid.length;
        int cols = grid[0].length;
        // (n*m)
        // (n*m)
        // SC - (N*m) + (N*m) = O(N*M)

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                int value = grid[i][j];

                if (value > 9) {
                    return false;
                }

                if(rowHashmap.get(i).contains(value) || columnHashMap.get(j).contains(value)){
                    return false;
                }

                rowHashmap.get(i).add(value);
                columnHashMap.get(i).add(value);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
    }


}




