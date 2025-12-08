// Last updated: 12/8/2025, 6:07:59 PM
1class Solution {
2    public int findPeakElement(int[] nums) {
3        // Set left and right bounds
4        int low = 0; 
5        int high = nums.length - 1;
6
7        // Binary search loop
8        while (low < high) {
9            // Find mid point
10            int mid = (low + high) / 2;
11
12            // If mid element is greater than the next element,
13            // we are on a downward slope. The peak is either at mid or to the left.
14            if (nums[mid] > nums[mid + 1]) {
15                high = mid;
16            } 
17            // If mid element is smaller than the next element,
18            // we are on an upward slope. The peak must be to the right.
19            else {
20                low = mid + 1;
21            }
22        }
23
24        // When low == high, we have found the peak
25        return low;
26    }
27}