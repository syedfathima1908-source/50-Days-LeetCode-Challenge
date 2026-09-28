# Intuition

We need to find the element that appears more than `n/2` times in the array.

We can use the **Boyer-Moore Voting Algorithm**. The idea is to keep a candidate element and a count. When the current element is the same as the candidate, we increase the count. Otherwise, we decrease it.

Since the majority element occurs more than all other elements combined, it will remain as the final candidate.

# Approach

1. Initialize `ele` as the candidate and `count` as `0`.
2. Traverse through the array.
3. If `count == 0`, make the current element the candidate.
4. If the current element is equal to the candidate, increment `count`.
5. Otherwise, decrement `count`.
6. After traversing the array, `ele` will be the majority element.

# Complexity

* Time complexity: `O(n)`
* Space complexity: `O(1)`

# Code

```java
class Solution {

    public int majorityElement(int[] nums) {

        int ele = 0;
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (count == 0) {
                ele = nums[i];
                count++;
            }
            else if (nums[i] == ele) {
                count++;
            }
            else {
                count--;
            }
        }

        return ele;
    }
}
```
