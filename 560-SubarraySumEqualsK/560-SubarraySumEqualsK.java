// Last updated: 11/2/2025, 6:41:10 PM
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // handle subarrays starting from index 0
        for (int i = 0; i < n; i++) {
            preSum += nums[i];          // update prefix sum
            int remove = preSum - k;    // find prefix sum to remove
            cnt += mpp.getOrDefault(remove, 0); // add count of matching prefix sums
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1); // update map
        }
        return cnt;
    }
}
