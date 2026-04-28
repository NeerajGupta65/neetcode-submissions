class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, result);
        return result;
    }

    public void solve(char[][] board, int row, List<List<String>> result) {

        // Base case: all queens placed
        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        // Try placing queen in each column
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';

                solve(board, row + 1, result);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col) {

        // Check same column (upwards)
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            list.add(new String(board[i]));
        }

        return list;
    }
}
