# Intuition

The main idea is to traverse the matrix layer by layer, starting from the outer boundary and moving towards the center.

For each layer, we maintain four boundaries:

- `fr` → first row
- `lr` → last row
- `fc` → first column
- `lc` → last column

We traverse the matrix in four directions:

1. Left to Right across the first row
2. Top to Bottom down the last column
3. Right to Left across the last row
4. Bottom to Top up the first column

After traversing each side, we move the corresponding boundary inward.

The boundary checks ensure that we do not visit any element more than once when only one row or one column remains.

# Approach

First, initialize the four boundaries of the matrix.

For every iteration:

1. Traverse the first row from left to right and increment `fr`.
2. Traverse the last column from top to bottom and decrement `lc`.
3. Traverse the last row from right to left and decrement `lr`.
4. Traverse the first column from bottom to top and increment `fc`.

After each boundary update, we check whether the remaining boundaries are still valid. If `fr > lr` or `fc > lc`, we stop to avoid duplicate elements.

This process continues until the entire matrix has been traversed.

# Complexity

- Time complexity: O(n × m)
- Space complexity: O(n × m)

The time complexity is O(n × m) because every element is visited exactly once. The result list requires O(n × m) space to store all the elements.

# Code

```java
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int fr = 0;
        int lr = n - 1;
        int fc = 0;
        int lc = m - 1;

        List<Integer> ans = new ArrayList<>();

        while (fr <= lr && fc <= lc) {

            for (int j = fc; j <= lc; j++) {
                ans.add(matrix[fr][j]);
            }
            fr++;

            if (fr > lr || fc > lc)
                break;

            for (int i = fr; i <= lr; i++) {
                ans.add(matrix[i][lc]);
            }
            lc--;

            if (fr > lr || fc > lc)
                break;

            for (int j = lc; j >= fc; j--) {
                ans.add(matrix[lr][j]);
            }
            lr--;

            if (fr > lr || fc > lc)
                break;

            for (int i = lr; i >= fr; i--) {
                ans.add(matrix[i][fc]);
            }
            fc++;
        }

        return ans;
    }
}
