package backtracking;

public class NQueen {
    public static void main(String[] args) {
        int n =4;

        boolean[][] board = new boolean[n][n];

        System.out.println(queens(board, 0));
        
    }

    static int queens(boolean[][] board, int row){

        if(row == board.length){
            display(board);
            System.out.println();
            return 1;            
        }

        int count = 0;

        for (int col = 0; col < board.length; col++) {
            
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += queens(board, row+1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        
        // check for vertical checks

        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        // check for left side diagonal checks
        
        int minleft = Math.min(row, col);
        for (int i = 1; i <= minleft; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }

        // check for right diagonal checks

        int rigthmin = Math.min(row, board.length - col -1);
        for (int i = 1; i <= rigthmin; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {
       
        for(boolean[] row : board){
            for(boolean element : row){

                if(element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
