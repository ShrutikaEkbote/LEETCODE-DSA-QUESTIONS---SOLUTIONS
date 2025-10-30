// Last updated: 10/30/2025, 4:54:09 PM
class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;

        int xorr = 0;
        for(int i = 0; i < n ;i++){
            xorr = xorr ^ nums[i];
        }

        return xorr;
    }
}