// Last updated: 12/8/2025, 1:57:18 PM
class Solution {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while(low <= high ){
            //calculate middle index
            int mid = (low + high )/2;

            //if the target is found,retunn index
            if ( nums[mid] == target )
                return mid;

            //if left part is sorted
            if(nums[low] <= nums[mid]){
                //if target lies within sorted left part
                if (nums[low] <= target && target < nums[mid]){
                    high = mid - 1;

                }
                //else ,search in right half
                else{
                    low = mid + 1;
                }
            }
            //else ,right part is sorted

            else{

                //if target lies within sorted right part
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }

                //else ,serach is left half
                else{
                    high = mid - 1;
                }
            }    
        }

        return -1;
        
    }
}