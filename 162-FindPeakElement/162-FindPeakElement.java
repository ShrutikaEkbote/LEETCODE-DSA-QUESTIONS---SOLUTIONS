// Last updated: 12/8/2025, 6:09:01 PM
class Solution {
    public int findPeakElement(int[] nums) {
        // Set left and right bounds
        int low = 0; 
        int high = nums.length - 1;

        // Binary search loop
        while (low < high) {
            // Find mid point
            int mid = (low + high) / 2;

            // If mid element is greater than the next element,
            // we are on a downward slope. The peak is either at mid or to the left.
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } 
            // If mid element is smaller than the next element,
            // we are on an upward slope. The peak must be to the right.
            else {
                low = mid + 1;
            }
        }

        // When low == high, we have found the peak
        return low;
    }
}