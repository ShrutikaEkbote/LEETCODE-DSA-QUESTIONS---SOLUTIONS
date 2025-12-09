// Last updated: 12/9/2025, 3:48:25 PM
1class Solution {
2    public int minDays(int[] bloomDay, int m, int k) {
3        // Edge case: If total flowers needed is more than available flowers
4        // Cast to long to prevent integer overflow since m and k can be large
5        long required = (long) m * k;
6        if (required > bloomDay.length) {
7            return -1;
8        }
9
10        // Find the search space (minimum and maximum bloom day)
11        int minDay = Integer.MAX_VALUE;
12        int maxDay = Integer.MIN_VALUE;
13
14        for (int bloom : bloomDay) {
15            minDay = Math.min(minDay, bloom);
16            maxDay = Math.max(maxDay, bloom);
17        }
18
19        // Binary Search variables
20        int low = minDay;
21        int high = maxDay;
22        int result = -1;
23
24        while (low <= high) {
25            int mid = low + (high - low) / 2; // Safer calculation for mid
26
27            if (isPossible(bloomDay, mid, m, k)) {
28                result = mid;     // We can make bouquets, try to find a smaller day
29                high = mid - 1;
30            } else {
31                low = mid + 1;    // Not enough bouquets, we need to wait longer
32            }
33        }
34
35        return result;
36    }
37
38    // Helper function to check if it is possible to make m bouquets by 'day'
39    private boolean isPossible(int[] bloomDay, int day, int m, int k) {
40        int count = 0;      // Consecutively bloomed flowers
41        int bouquets = 0;   // Total bouquets formed
42
43        for (int bloom : bloomDay) {
44            if (bloom <= day) {
45                count++;
46                // If we have k adjacent flowers, form a bouquet
47                if (count == k) {
48                    bouquets++;
49                    count = 0; // Reset count for the next bouquet
50                }
51            } else {
52                // Chain is broken
53                count = 0;
54            }
55        }
56
57        return bouquets >= m;
58    }
59}