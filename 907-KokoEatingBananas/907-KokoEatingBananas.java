// Last updated: 12/17/2025, 5:10:27 PM
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find max element 
        int maxPile = Arrays.stream(piles).max().getAsInt();

        //initialize low and high pointers
        int low = 1,high = maxPile;
        int ans = maxPile;

        while(low <= high){
            int mid = (low + high)/2;
            long totalH = calculateTotalHours(piles,mid);

            if(totalH <= h){
                ans = mid;
                high = mid - 1;
            }

            else{
                low = mid + 1;
            }
        }

        return ans;
        
    }

    private long calculateTotalHours(int[] piles, int speed){
        long totalH = 0;
        for(int bananas : piles){
            totalH += (int)Math.ceil((double)bananas / speed);
        }
        return totalH;
    }
}