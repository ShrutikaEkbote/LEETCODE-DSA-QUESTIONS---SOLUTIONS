// Last updated: 12/8/2025, 5:54:10 PM
1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3        int n = nums.length;
4
5        // 1. Handle Edge Cases
6        if (n == 1) return nums[0];
7        if (nums[0] != nums[1]) return nums[0];
8        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
9
10        // 2. Initialize Binary Search (avoiding first and last index)
11        int low = 1;
12        int high = n - 2;
13
14        while (low <= high) {
15            int mid = (low + high) / 2;
16
17            // 3. Check if mid is the single element
18            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
19                return nums[mid];
20            }
21
22            // 4. Elimination Logic
23            // We want to verify if we are in the "Left Half" (where pairs are normal).
24            // Normal Pairs: (Even Index, Odd Index) -> (Value, Value)
25            
26            // If we are at an odd index, we should match the previous (left).
27            // OR if we are at an even index, we should match the next (right).
28            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || 
29                (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
30                
31                // We are in the safe left half, move right
32                low = mid + 1;
33            } else {
34                // We are in the disrupted right half, move left
35                high = mid - 1;
36            }
37        }
38        
39        return -1;
40    }
41}