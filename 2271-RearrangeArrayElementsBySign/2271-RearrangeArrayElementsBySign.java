// Last updated: 11/2/2025, 2:27:51 PM
class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums){
            if (num > 0)
                pos.add(num);
            else
                neg.add(num);    
        }

        //step 2: merge alternatively (positive first)
        int[] res = new int[nums.length];
        int p = 0,n =0;

        for (int i = 0; i < nums.length; i++){
            if (i % 2 == 0){
                res[i] = pos.get(p++);
            }else{
                res[i] = neg.get(n++);
            }
        }

        return res;
    }
}