public class NQueens {

    private int n;
    private boolean[][] board;

    public NQueens(int n) {
        this.n = n;
        this.board = new boolean[n][n];
    }

    public void solve() {
        solve(0);
    }

    private void solve(int col) {
        if (col == n) {
            // All queens have been placed successfully
            printBoard();
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col)) {
                // Place the queen at (row, col)
                board[row][col] = true;

                // Recursively solve for the next column
                solve(col + 1);

                // Backtrack
                board[row][col] = false;
            }
        }
    }

    private boolean isSafe(int row, int col) {
        // Check if the queen is attacking any of the queens that have already been placed
        for (int i = 0; i < col; i++) {
            if (board[row][i]) {
                return false;
            }
        }

        // Check if the queen is attacking any of the queens that are diagonally placed
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        // Check if the queen is attacking any of the queens that are diagonally placed
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }

    private void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        NQueens queens = new NQueens(n);
        queens.solve();
    }
}