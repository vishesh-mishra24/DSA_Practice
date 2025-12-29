import java.util.*;

public class Solution {

    public int snakesAndLadders(int[][] board) {

        int n = board.length;
        int target = n * n;

        // Queue for BFS (cell, moves)
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[target + 1];

        q.offer(1);          // Start at cell 1
        visited[1] = true;

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int curr = q.poll();

                // Reached last cell
                if (curr == target) return moves;

                // Try dice throws 1 to 6
                for (int dice = 1; dice <= 6 && curr + dice <= target; dice++) {

                    int next = curr + dice;
                    int[] pos = getCoordinates(next, n);

                    // If board cell has snake/ladder, move to it
                    if (board[pos[0]][pos[1]] != -1) {
                        next = board[pos[0]][pos[1]];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1; // unreachable
    }

    // Convert number to board coordinates
    private int[] getCoordinates(int num, int n) {

        int row = (num - 1) / n;
        int col = (num - 1) % n;

        int r = n - 1 - row;

        // Row direction alternates (zig-zag)
        int c = (row % 2 == 0) ? col : (n - 1 - col);

        return new int[]{r, c};
    }
}
