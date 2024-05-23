import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class getBeautifulSubsets {
    public static void main(String[] args) {
        System.out.println("x");
        System.out.println("count= " + beautifulSubsets(new int[]{2,4,6} , 2));
    }

    public static int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return generateSubsets(nums, 0 , k, new HashSet<>());
    }

    private static int generateSubsets(int[] nums, int start, int k, HashSet<Integer> temp) {
        if(start == nums.length) {
            return temp.isEmpty() ? 0 : 1;
        }

        int count = generateSubsets(nums, start + 1, k, temp);
        if(temp.contains(nums[start] - k)) { return count;}
        
        temp.add(nums[start]);
        count += generateSubsets(nums, start + 1, k, temp);
        temp.remove(nums[start]);
        return count;
    }

}
