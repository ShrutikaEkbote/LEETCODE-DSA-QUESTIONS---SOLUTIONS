// Last updated: 12/8/2025, 1:55:50 PM
1class Solution {
2    public boolean search(int[] nums, int target) {
3        int low = 0, high = nums.length - 1;
4
5        while (low <= high) {
6            int mid = (low + high) / 2;
7
8            // If mid element is the target
9            if (nums[mid] == target) return true;
10
11            // Handle duplicates: cannot determine sorted side
12            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
13                low++;
14                high--;
15                continue;
16            }
17
18            // Left half is sorted
19            if (nums[low] <= nums[mid]) {
20                if (nums[low] <= target && target <= nums[mid]) {
21                    high = mid - 1; // Search left
22                } else {
23                    low = mid + 1;  // Search right
24                }
25            }
26            // Right half is sorted
27            else {
28                if (nums[mid] <= target && target <= nums[high]) {
29                    low = mid + 1;  // Search right
30                } else {
31                    high = mid - 1; // Search left
32                }
33            }
34        }
35
36        return false; // Not found
37    }
38}