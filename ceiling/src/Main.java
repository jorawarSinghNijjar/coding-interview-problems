public class Main {
    public static void main(String[] args) {
        int[] arr = {2,5,11,13,18,20};
        int target = 12;
        System.out.println(findCeiling(arr,target));
    }

    private static int findCeiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == arr[mid]){
                return mid;
            }
            else if(target > arr[mid]){
                start = mid+1;
            }
            else {
                end = mid - 1;
            }
        }
        return arr[start];
    }
}