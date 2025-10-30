// Last updated: 10/30/2025, 4:54:19 PM
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i =0 ; i < nums.length ; i++){
            int moreNeeded = target - nums[i];
            if (mpp.containsKey(moreNeeded)){
                return new int[]{mpp.get(moreNeeded),i};
            }
            mpp.put(nums[i],i);
        }
        return null;
    }
}