public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        int target = 3;
        System.out.println(search(arr, target));
    }

    public static int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int leftSearch = orderAgnosticBinarySearch(arr, 0, peak, target);
        if(leftSearch != -1){
            return leftSearch;
        }
        else{
            return orderAgnosticBinarySearch(arr, peak+1, arr.length - 1, target);
        }
    }

    public static int peakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start!=end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid+1]){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }

    public static int orderAgnosticBinarySearch(int[] arr,int start, int end, int target){
        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target == arr[mid]){
                return mid;

            }
            if(isAsc){
                if(target < arr[mid]){
                    end = mid - 1;
                }
                else if( target > arr[mid]){
                    start = mid + 1;
                }
            }
            else{
                if(target < arr[mid]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}