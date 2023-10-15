import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers(nums);
        System.out.println(result.toString());
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            if(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
            else{
                i++;
            }
        }
        System.out.println("After Sorting Array : " + Arrays.toString(nums));
        if(nums[0] != 1) result.add(1);

        for(int j=1; j < nums.length; j++){
            if(nums[j] != j+1){
                result.add(j+1);
            }
        }
        return result;

    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}