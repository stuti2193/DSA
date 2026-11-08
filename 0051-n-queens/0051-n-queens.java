import java.util.*;

class Solution {

    public boolean isSafe(int row, int col, char[][] board) {

        // vertical check (no need for horizontal in optimized version)
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void saveBoard(char[][] board, List<List<String>> allBoards) {
        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            String row = "";
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
            newBoard.add(row);
        }

        allBoards.add(newBoard);
    }

    public void helper(char[][] board, List<List<String>> allBoards, int row) {

        if (row == board.length) {
            saveBoard(board, allBoards);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';

                helper(board, allBoards, row + 1);

                // backtrack
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        // initialize board
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        helper(board, allBoards, 0);
        return allBoards;
    }
}