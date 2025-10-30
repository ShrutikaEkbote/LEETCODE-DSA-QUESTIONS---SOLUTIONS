// Last updated: 10/30/2025, 4:53:56 PM
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length - 1 ,target);
    }


    public static int binarySearch(int[]nums,int low,int high,int target){
        if(low > high ) return - 1;
        int mid = (low+high)/2;
        if(nums[mid] == target) return mid;
        else if (target > nums[mid])
            return binarySearch(nums,mid+1,high,target);
        return binarySearch(nums,low,mid-1,target);
    }
}