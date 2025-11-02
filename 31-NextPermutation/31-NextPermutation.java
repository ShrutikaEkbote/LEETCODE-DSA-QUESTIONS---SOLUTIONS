// Last updated: 11/2/2025, 2:28:04 PM
class Solution {
    public void nextPermutation(int[] nums) {

        // Set index to -1 
        int index = -1;

        //find the first decreasing element from end 
        for(int i = nums.length - 2;i >= 0; i--){
            // if smaller found

            if(nums[i] < nums[i+1]){
                //store index
                index = i ;
                break;
            }

        }

        //if no index found
        if(index == -1){
            //reverse the entire array
            reverse(nums,0,nums.length - 1);
            return;
        }

        for(int i = nums.length - 1 ; i > index; i--){
            //swap them

            if(nums[i] > nums[index]){
                swap(nums,i,index);
                break;
            }
        }

        reverse(nums,index + 1,nums.length - 1);
        
    }

    private void reverse(int[] arr,int start,int end){
        while (start < end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}