import java.util.*;

public class Main {

    static int maxIndex = 0;
    public static void main(String[] args) {
        int[] nums = { 1,1,1,1,1,1,1,1,1,1};
        calculateMax(nums , 0);
        calculateMax(nums , 1);
        calculateMax(nums , 2);
        calculateMax(nums , 3);
        calculateMax(nums , 4);
        calculateMax(nums , 5);
        calculateMax(nums , 6);
        calculateMax(nums , 7);
        calculateMax(nums , 8);
        calculateMax(nums , 9);


        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println( " Max value- " + getMax(nums));
        System.out.println("BREAK");


    }

    public static void calculateMax(int[] nums, int index)
    {
        if(index == 0) return;
        if(nums[index] > nums[maxIndex ])
        {
            maxIndex = 0;
            int temp = nums[index];
            nums[index] = nums[maxIndex ];
            nums[maxIndex ] = temp;
        }
        else if(nums[index] == nums[maxIndex])
        {
            maxIndex++;
            int temp = nums[index];
            nums[index] = nums[maxIndex];
            nums[maxIndex] = temp;

        }
    }

    public static int getMax(int[] nums)
    {
        Random r = new Random();
        int randomIndex = r.nextInt(maxIndex + 1);
        System.out.print(" randomIndex= " + randomIndex);
        return nums[ randomIndex];
    }




}

