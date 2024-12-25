class Solution {
    public int maxRotateFunction(int[] nums) {
        int allSum = 0;
        int len = nums.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * nums[i];
            allSum += nums[i];
        }
        int max = F;
        for (int i = 0; i < len ; i++) {
            F = F + allSum - len * nums[len -i -1];
            max = Math.max(F, max);
        }
        return max;   
    }
}

/*

F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) 
F(0) =           (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6)
F(1) - F(0) =         4  +      3  +      2) -  (3 * 6)
F(1) - F(0) =  (4 + 3 + 2 + 6) - (4 * 6)
F(1) - F(0) =  SUM - (N * 6)
F(1) - F(0) =  SUM - (N * ARR[n-1])
F(k) - F(k-1) =  SUM - (N * ARR[n-k-1])

*/
