import java.util.*;

public class Jump2 {
  
// Approach 1 .  TC - O ( N ^ 2 )  .  SC - O ( N )
    public static int jump(int[] nums) {
        int n = nums.length;
        int[] minJumpsNeeded = new int[nums.length];
        Arrays.fill(minJumpsNeeded, 10001);
        minJumpsNeeded[n - 1] = 0;

        for(int i = n - 2 ; i >= 0 ; i--)
        {
            for(int jumpLen = 1 ; jumpLen <= nums[i]; jumpLen++)
            {
                int lastIndexReached = Math.min(n-1, i + jumpLen);
                minJumpsNeeded[i] = Math.min(minJumpsNeeded[i], 1 + minJumpsNeeded[lastIndexReached]);
            }
        }
        return minJumpsNeeded[0] == 10001 ? -1 : minJumpsNeeded[0] ;
    }

  //Approach 2  TC - O(N)   SC - O(1)
     public static int jump(int[] nums) {
        int n = nums.length - 1, jumps = 0;
        int maxPositionCanbeReached = 0, lastJumpedPosition = 0;
        for(int i = 0 ; i <= n; i++)
        {
            maxPositionCanbeReached = Math.max(maxPositionCanbeReached, i + nums[i]);
            if(i == lastJumpedPosition )
            {
                lastJumpedPosition = maxPositionCanbeReached;
                jumps++;
                if(lastJumpedPosition == n)   return jumps;
            }
        }
        return -1;
    }
    

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println( " minimum jums for {2,3,1,1,4} is " +  jump(nums));

        nums = new int[]{2, 1, 1, 0, 4};
        System.out.println( " minimum jums for {2, 1, 1, 0, 4} is " +  jump(nums));

        nums = new int[]{2, 1, 1, 1 , 1 ,1 , 1, 1, 1, 1, 1, 1, 4};
        System.out.println( " minimum jums for { 2, 1, 1, 1 , 1 ,1 , 1, 1, 1, 1, 1, 1, 4} is " +  jump(nums));

        nums = new int[]{12, 1, 1, 1 , 1 ,1 , 1, 1, 1, 1, 1, 1, 1};
        System.out.println( " minimum jums for {12, 1, 1, 1 , 1 ,1 , 1, 1, 1, 1, 1, 1, 1} is " +  jump(nums));
    }
}
