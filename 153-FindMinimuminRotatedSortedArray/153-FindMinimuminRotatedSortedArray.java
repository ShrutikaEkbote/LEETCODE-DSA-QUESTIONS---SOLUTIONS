// Last updated: 12/8/2025, 3:54:24 PM
1class Solution {
2    public int findMin(int[] nums) {
3
4        int low = 0,high = nums.length - 1;
5
6        while( low < high ){
7            int mid = low + (high - low)/2;
8
9            if(nums[mid] > nums[high]){
10                low = mid + 1;
11            }else {
12                high = mid;
13            }
14        }
15
16        return nums[low];
17        
18    }
19}