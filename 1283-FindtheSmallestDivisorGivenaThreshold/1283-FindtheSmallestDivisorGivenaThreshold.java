// Last updated: 12/9/2025, 4:24:47 PM
1class Solution {
2    public int smallestDivisor(int[] nums, int threshold) {
3        if (nums.length > threshold) return -1;
4
5        int low = 1;
6        int high = Arrays.stream(nums).max().getAsInt();
7
8        while (low <= high){
9            int mid = (low + high)/2;
10            if(sumByD(nums,mid) <= threshold){
11                high = mid - 1;
12            }else{
13                low = mid + 1;
14            }
15        }
16
17        return low;
18    }
19
20    //helper function
21    private int sumByD(int[] nums,int div){
22        int sum = 0;
23        for(int num : nums){
24            sum += Math.ceil((double) num /div);
25        }
26
27        return sum;
28    }
29}