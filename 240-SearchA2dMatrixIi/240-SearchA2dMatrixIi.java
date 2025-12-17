// Last updated: 12/17/2025, 5:10:32 PM
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Handle edge cases (empty matrix)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;        // Number of rows
        int m = matrix[0].length;     // Number of columns

        int row = 0;           // Start at first row
        int col = m - 1;       // Start at last column (top-right)

        // Traverse while within matrix bounds
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Found target
            } else if (matrix[row][col] < target) {
                row++; // Move down
            } else {
                col--; // Move left
            }
        }

        return false; // Target not found
    }
}