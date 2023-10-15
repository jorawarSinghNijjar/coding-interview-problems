import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5,8,2,6,9,0,0,0,0};
        int insertIndex = 2;
        int insertNum = 4;
        System.out.println(Arrays.toString(rightShift(nums, insertIndex, insertNum)));
    }

    private static int[] rightShift(int[] arr, int insertIndex, int insertNum) {
        int temp = arr[insertIndex];
        arr[insertIndex] = insertNum;
        int temp2 = 0;
        for(int i=insertIndex; i < arr.length-1; i++){
            if(i!=insertIndex){
                temp = temp2;
            }
            temp2 = arr[i + 1];
            arr[i+1] = temp;
        }
        return arr;
    }
}