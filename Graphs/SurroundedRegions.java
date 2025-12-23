class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        // 1️⃣ Add all BORDER 'O' to queue
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') q.offer(new int[]{i, 0});
            if (board[i][n - 1] == 'O') q.offer(new int[]{i, n - 1});
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') q.offer(new int[]{0, j});
            if (board[m - 1][j] == 'O') q.offer(new int[]{m - 1, j});
        }

        // 2️⃣ BFS from border and mark safe 'O' as '#'
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O')
                continue;

            board[r][c] = '#';  // mark as safe

            for (int[] d : dirs) {
                q.offer(new int[]{r + d[0], c + d[1]});
            }
        }

        // 3️⃣ Flip surrounded 'O' to 'X' and restore '#'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
}
