// Last updated: 10/30/2025, 4:54:00 PM
class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Try both directions: left (-1) and right (+1)
                if (simulate(nums, i, -1)) count++;
                if (simulate(nums, i, +1)) count++;
            }
        }

        return count;
    }

    private boolean simulate(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] arr = nums.clone();  // work on a copy
        int curr = start;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir; // move in current direction
            } else {
                arr[curr]--;   // decrease value
                dir = -dir;    // reverse direction
                curr += dir;   // move in new direction
            }
        }

        // check if all elements are 0
        for (int num : arr) {
            if (num != 0) return false;
        }
        return true;
    }
}
