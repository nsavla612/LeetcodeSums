// https://leetcode.com/problems/split-array-largest-sum/description/
class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0, answer = -1;
        for(int num : nums)
        {
            low = Math.max(num, low);
            high += num;
        }
       
        while(low < high)
        {
            int mid = low + ( high - low) / 2;
            int cuts = getCuts(nums, mid);
            if(cuts <= k-1)
            {
                high = mid;
            }
            else
            {
                answer = low;
                low = mid + 1;
            }
        }
        return high;

    }

    public int getCuts(int[] nums,  int targetSum)
    {
        int currentSum = 0, cuts = 0;
        for(int num : nums)
        {
            cuts = currentSum + num > targetSum ? cuts + 1 : cuts ;
            currentSum = currentSum + num <= targetSum ? currentSum + num : num;
        }
        return cuts ;
    }
}
