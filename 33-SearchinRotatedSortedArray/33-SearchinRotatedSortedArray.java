// Last updated: 12/8/2025, 12:04:31 PM
1class Solution {
2    public int search(int[] nums, int target) {
3
4        int low = 0;
5        int high = nums.length - 1;
6
7        while(low <= high ){
8            //calculate middle index
9            int mid = (low + high )/2;
10
11            //if the target is found,retunn index
12            if ( nums[mid] == target )
13                return mid;
14
15            //if left part is sorted
16            if(nums[low] <= nums[mid]){
17                //if target lies within sorted left part
18                if (nums[low] <= target && target < nums[mid]){
19                    high = mid - 1;
20
21                }
22                //else ,search in right half
23                else{
24                    low = mid + 1;
25                }
26            }
27            //else ,right part is sorted
28
29            else{
30
31                //if target lies within sorted right part
32                if(nums[mid] < target && target <= nums[high]){
33                    low = mid + 1;
34                }
35
36                //else ,serach is left half
37                else{
38                    high = mid - 1;
39                }
40            }    
41        }
42
43        return -1;
44        
45    }
46}