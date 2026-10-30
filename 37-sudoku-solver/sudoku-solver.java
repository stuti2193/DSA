class Solution {

    public boolean isSafe(char[][] board, int row, int col, int number) {

        // check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == (char)(number + '0')) {
                return false;
            }
        }

        // check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == (char)(number + '0')) {
                return false;
            }
        }

        // check 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == (char)(number + '0')) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean helper(char[][] board, int row, int col) {

        // base case
        if (row == 9) {
            return true;
        }

        int nrow, ncol;

        if (col != 8) {
            nrow = row;
            ncol = col + 1;
        } else {
            nrow = row + 1;
            ncol = 0;
        }

        // skip filled cells
        if (board[row][col] != '.') {
            return helper(board, nrow, ncol);
        }

        // try numbers 1 to 9
        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, col, i)) {
                board[row][col] = (char)(i + '0');

                if (helper(board, nrow, ncol)) {
                    return true;
                }

                // backtrack
                board[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}