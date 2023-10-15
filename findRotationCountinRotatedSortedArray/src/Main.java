public class Main {
    public static void main(String[] args) {
        int[] arr = {15,18,2,3,6,12};

        System.out.println(findRotationCount(arr));
    }

    private static int findRotationCount(int[] arr) {
        int pivot = findPivotIndex(arr);
        return pivot + 1;

    }

    private static int findPivotIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end-start) / 2;

            if(end > mid && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(start < mid && arr[mid] < arr[mid-1]){
                return mid - 1;
            }
            else if(arr[mid] < arr[start]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
}