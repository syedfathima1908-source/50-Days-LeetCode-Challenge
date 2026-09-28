# Intuition

An element must appear more than `n/3` times to be a majority element.

There can be **at most two elements** that appear more than `n/3` times. So, instead of keeping track of every element, we only need two candidates and their counts.

We use the extended **Boyer-Moore Voting Algorithm** to find these two possible candidates.

# Approach

1. Maintain two candidates `ele1` and `ele2` with counts `c1` and `c2`.
2. Traverse the array:

   * If `c1 == 0` and the current element is not `ele2`, make it `ele1`.
   * Else if `c2 == 0` and the current element is not `ele1`, make it `ele2`.
   * If the current element matches `ele1`, increment `c1`.
   * If it matches `ele2`, increment `c2`.
   * Otherwise, decrement both counts.
3. The first pass gives us the two possible candidates.
4. The counts obtained in the first pass are not their actual frequencies, so we reset `c1` and `c2`.
5. Traverse the array again and count the actual occurrences of both candidates.
6. Add a candidate to the answer only if its frequency is greater than `n/3`.

# Complexity

* Time complexity: `O(n)`
* Space complexity: `O(1)` excluding the output list.

# Code

```java
class Solution {

    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;

        ArrayList<Integer> ans = new ArrayList<>();

        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        int c1 = 0;
        int c2 = 0;

        for (int i = 0; i < n; i++) {

            if (c1 == 0 && nums[i] != ele2) {
                ele1 = nums[i];
                c1++;
            }
            else if (c2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                c2++;
            }
            else if (nums[i] == ele1) {
                c1++;
            }
            else if (nums[i] == ele2) {
                c2++;
            }
            else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == ele1) {
                c1++;
            }

            if (nums[i] == ele2) {
                c2++;
            }
        }

        if (c1 > n / 3) {
            ans.add(ele1);
        }

        if (c2 > n / 3) {
            ans.add(ele2);
        }

        return ans;
    }
}
```
