class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Loop through each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If the cell is not empty, validate it
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j)) {
                        return false; // If any cell is invalid, return false
                    }
                }
            }
        }
        return true; // If all cells are valid, return true
    }

    // Function to check if the cell at board[row][col] is valid
    private boolean isValid(char[][] board, int row, int col) {
        char num = board[row][col];

        // Check the row for duplicates
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == num) {
                return false;
            }
        }

        // Check the column for duplicates
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 sub-box for duplicates
        int boxRowStart = 3 * (row / 3);
        int boxColStart = 3 * (col / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int r = boxRowStart + i;
                int c = boxColStart + j;
                if ((r != row || c != col) && board[r][c] == num) {
                    return false;
                }
            }
        }

        // If no duplicates found, return true
        return true;
    }
}
