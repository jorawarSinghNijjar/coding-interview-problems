import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        int n = nums.length / 2;
        System.out.println(Arrays.toString(shuffle(nums,n)));
    }
    public static int[] shuffle(int[] nums, int n) {
        if(n <=1 ) return nums;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i=0; i < nums.length; i++){
            if(i < n){
                arr1[i] = nums[i];
            }
            else{
                arr2[i % n] = nums[i];
            }
        }

        for(int j=0, k=0,l=0; j < nums.length; j++){
            if(j % 2 == 0){
                nums[j] = arr1[k];
                k++;
            }
            else{
                nums[j] = arr2[l];
                l++;
            }
        }

        return nums;

    }
}