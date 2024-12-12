/*
 * +-----+-----+-----+
 * |  0  |     |     |
 * +-----+-----+-----+
 * |     |     |     |
 * +-----+-----+-----+
 * |     |     |  T  |
 * +-----+-----+-----+
 * 
 *  0 is current position in maze and T is target. we need to reach target from current posion
 *  then  number of ways to reach their is the problem
 */

package backtracking;

import java.util.ArrayList;

public class maze {

    public static void main(String[] args) {

        // System.out.println(count(3,3));

       // path("", 3,3);

       // System.out.println(pathRetDiagonal(" ", 3, 3));

        boolean[][] board = {
            {true, true, true},
            {true, false, true},
            {true, true, true}
    };

    pathRestrictions("", board, 0, 0);

    }
/*****************************************************************************************************************/
// NUMBER OF WAYS TO REACH THE TARGET 

/*
 *  if we move right then col gets decrease by 1
 *  if we move down then row get decrease by 1
 *  if any of row or column rach 1 then return 1
 */
    static int count(int row, int col){

        if(row == 1 || col == 1){
            return 1;
        }

        int left = count(row , col -1);
        int down = count(row -1, col);
        return left+down;
    }
/*****************************************************************************************************************/

    /*
     *  PRINT PATHS, IF MOVING RIGHT THEN R
     *  IF MOVING DOWN THEN U
     */
    static void path(String p, int row, int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }

        if(row > 1){
            path(p+'D', row-1, col);
        }

        if(col > 1){
            path(p+'R', row, col-1);
        }
    }
/*****************************************************************************************************************/

// WHAT IF WE CAN TRAVEL DIAGONALY ALSO

    static ArrayList<String> pathRetDiagonal(String p, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (row > 1 && col > 1) {
            list.addAll(pathRetDiagonal(p + 'T', row-1, col-1));
        }

        if (row > 1) {
            list.addAll(pathRetDiagonal(p + 'D', row-1, col));
        }

        if (col > 1) {
            list.addAll(pathRetDiagonal(p + 'R', row, col-1));
        }

        return list;
    }
/*****************************************************************************************************************/
// if maze has some restricted area

    static void pathRestrictions(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        if (r < maze.length - 1) {
            pathRestrictions(p + 'D', maze, r+1, c);
        }

        if (c < maze[0].length - 1) {
            pathRestrictions(p + 'R', maze, r, c+1);
        }
    }
    
}
