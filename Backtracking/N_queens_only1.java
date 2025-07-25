public class N_queens_only1 {
    public static boolean isSafe(char board[][], int row, int col) {
        //vertical up
        for(int i=row-1; i>=0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        //diagonal left
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        //diagonal right
        for(int i=row-1, j=col+1; i>=0 && j <board.length; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static boolean nQueens(char board[][], int row) {
        if(row == board.length) {
            // printBoard(board);
            count++;
            return true;
        }

        for(int j=0; j<board.length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if(nQueens(board, row+1)) {
                    return true;
                }
                board[row][j] = '.';
            }
        }
        return false;
    }
    static int count = 0;
    public static void printBoard(char board[][]) {
        System.out.println("---------my board----------");
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j]+" ");            
            }
            System.out.println();
        }
        
    }


    public static void main(String args[]) {
        int n = 4;
        char board[][] = new char[n][n];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                board[i][j] = '.';
            }
        }
        if(nQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("not solution exist :(");
        }
    }
}
