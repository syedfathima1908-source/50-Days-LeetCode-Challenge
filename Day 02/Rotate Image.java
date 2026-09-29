# Intuition

To rotate the matrix 90 degrees clockwise, we can divide the problem into two steps:
1. Transpose the matrix.
2. Reverse every row.

This allows us to rotate the matrix in-place without using an extra matrix.

# Approach

First, transpose the matrix by swapping `matrix[i][j]` with `matrix[j][i]`.

Then, reverse each row using two pointers. After these two operations, the matrix is rotated 90 degrees clockwise.

# Complexity

- Time complexity: O(n²)
- Space complexity: O(1)

# Code

```java
class Solution {

    public void reverse(int[] arr) {
        int f = 0;
        int l = arr.length - 1;

        while (f < l) {
            int temp = arr[f];
            arr[f] = arr[l];
            arr[l] = temp;
            f++;
            l--;
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse every row
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }
}
--
