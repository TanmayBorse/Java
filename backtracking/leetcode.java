package backtracking;

public class leetcode {

    public static void main(String[] args) {
        char[][] board ={ 
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
        System.out.println(solve(board));

        for(char [] row : board){
            for(char num : row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


    static boolean solve(char[][] board){

        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyleft = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(board[i][j] == '.'){

                    row = i;
                    col = j;
                    emptyleft = false;
                    break;
                }
            }
            if(emptyleft == false){
                break;
            }
        }

        if(emptyleft == true){
            return true;
        }

        for(char num = '1'; num <= '9' ; num++){
            if(isSafe(board, row, col, num)){
                
                board[row][col] = num;
                if(solve(board)){
                    return true;
                }
                else{
                    board[row][col] = '.';
                }
            }
        }
            
        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col, char number) {
        
        for(int r = 0; r < board.length; r++){
            if(board[row][r] == number){
                return false;
            }
        }

        for (int c = 0; c < board.length; c++) {
            if (board[c][col] == number) {
                return false;
            }
        }

        int sqrt = (int) (Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if(board[i][j]== number){
                    return false;
                }
            }
            
        }
        return true;
    }

}