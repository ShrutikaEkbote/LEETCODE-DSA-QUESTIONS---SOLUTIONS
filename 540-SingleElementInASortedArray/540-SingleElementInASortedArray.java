// Last updated: 12/8/2025, 6:08:53 PM
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // 1. Handle Edge Cases
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        // 2. Initialize Binary Search (avoiding first and last index)
        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            // 3. Check if mid is the single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // 4. Elimination Logic
            // We want to verify if we are in the "Left Half" (where pairs are normal).
            // Normal Pairs: (Even Index, Odd Index) -> (Value, Value)
            
            // If we are at an odd index, we should match the previous (left).
            // OR if we are at an even index, we should match the next (right).
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || 
                (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                
                // We are in the safe left half, move right
                low = mid + 1;
            } else {
                // We are in the disrupted right half, move left
                high = mid - 1;
            }
        }
        
        return -1;
    }
}