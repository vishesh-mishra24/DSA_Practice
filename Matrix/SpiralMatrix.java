import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dir = 0; // 0: right, 1: down, 2: left, 3: up
        int top = 0, down = m - 1, left = 0, right = n - 1;
        List<Integer> result = new ArrayList<>();

        while (top <= down && left <= right) {
            if (dir == 0) { // Move right
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            } else if (dir == 1) { // Move down
                for (int i = top; i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) { // Move left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            } else if (dir == 3) { // Move up
                for (int i = down; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }

            dir = (dir + 1) % 4; // Cycle direction
        }

        return result;
    }
}
