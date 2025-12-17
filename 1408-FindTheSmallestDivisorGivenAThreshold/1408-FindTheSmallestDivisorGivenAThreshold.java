// Last updated: 12/17/2025, 5:10:24 PM
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        if (nums.length > threshold) return -1;

        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();

        while (low <= high){
            int mid = (low + high)/2;
            if(sumByD(nums,mid) <= threshold){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    //helper function
    private int sumByD(int[] nums,int div){
        int sum = 0;
        for(int num : nums){
            sum += Math.ceil((double) num /div);
        }

        return sum;
    }
}