// Last updated: 12/9/2025, 12:16:13 PM
1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        //find max element 
4        int maxPile = Arrays.stream(piles).max().getAsInt();
5
6        //initialize low and high pointers
7        int low = 1,high = maxPile;
8        int ans = maxPile;
9
10        while(low <= high){
11            int mid = (low + high)/2;
12            long totalH = calculateTotalHours(piles,mid);
13
14            if(totalH <= h){
15                ans = mid;
16                high = mid - 1;
17            }
18
19            else{
20                low = mid + 1;
21            }
22        }
23
24        return ans;
25        
26    }
27
28    private long calculateTotalHours(int[] piles, int speed){
29        long totalH = 0;
30        for(int bananas : piles){
31            totalH += (int)Math.ceil((double)bananas / speed);
32        }
33        return totalH;
34    }
35}