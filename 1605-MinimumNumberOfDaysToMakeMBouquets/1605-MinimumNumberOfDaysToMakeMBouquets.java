// Last updated: 12/17/2025, 5:10:23 PM
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Edge case: If total flowers needed is more than available flowers
        // Cast to long to prevent integer overflow since m and k can be large
        long required = (long) m * k;
        if (required > bloomDay.length) {
            return -1;
        }

        // Find the search space (minimum and maximum bloom day)
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int bloom : bloomDay) {
            minDay = Math.min(minDay, bloom);
            maxDay = Math.max(maxDay, bloom);
        }

        // Binary Search variables
        int low = minDay;
        int high = maxDay;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Safer calculation for mid

            if (isPossible(bloomDay, mid, m, k)) {
                result = mid;     // We can make bouquets, try to find a smaller day
                high = mid - 1;
            } else {
                low = mid + 1;    // Not enough bouquets, we need to wait longer
            }
        }

        return result;
    }

    // Helper function to check if it is possible to make m bouquets by 'day'
    private boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int count = 0;      // Consecutively bloomed flowers
        int bouquets = 0;   // Total bouquets formed

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;
                // If we have k adjacent flowers, form a bouquet
                if (count == k) {
                    bouquets++;
                    count = 0; // Reset count for the next bouquet
                }
            } else {
                // Chain is broken
                count = 0;
            }
        }

        return bouquets >= m;
    }
}