class Solution {
    public boolean isValidSudoku(char[][] board) {
        // parse columns
        for (int i = 0; i < 9; i++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (!isDigit(board[i][j])) {
                    continue;
                }
                if (columnSet.add(getInt(board[i][j])) == false) {
                    return false;
                }
            }
        }

        // parse lines
        for (int j = 0; j < 9; j++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (!isDigit(board[i][j])) {
                    continue;
                }
                if (rowSet.add(getInt(board[i][j])) == false) {
                    return false;
                }
            }
        }

        // 0 - 2 | 3 - 5 | 6 - 8
        // 0 - 2 | 0 - 2 | 0 - 2
        // ----
        // 0 - 2 | 3 - 5 | 6 - 8
        // 3 - 5 | 3 - 5 | 3 - 5 
        // ----
        // 0 - 2 | 3 - 5 | 6 - 8
        // 6 - 8 | 6 - 8 | 6 - 8

        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                if (!validSquare(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validSquare(int rowI, int colJ, char[][] board) {
        int rowBoundry = rowI + 2;
        int colBoundry = colJ + 2;
        Set<Integer> squareSet = new HashSet<>();
        for (int i = rowI; i <= rowBoundry; i++) {
            for (int j = colJ; j<= colBoundry;j++) {
                if (!isDigit(board[i][j])) {
                    continue;
                }
                if (squareSet.add(getInt(board[i][j])) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isDigit(char c) {
        return 0 <= c - '0' && c - '0' <= 9 ? true : false;
    }

    private int getInt(char c) {
        return c - '0';
    }
}
