public class Main {
    public static void main(String[] args) {
        int[] nums = {3,5,1};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
//        if(nums.length == 1){
//            return nums[0] == target ? 0 : -1;
//        }
        int pivot = findPivot(nums);
        // If no pivot is found, it is normal sorted array
        if(pivot == -1 ) return binarySearch(nums,target, 0, nums.length - 1);

        //If pivot == target
        if(nums[pivot] == target) return pivot;

        if(target == nums[0]) return 0;
        //If target > start
        if(target > nums[0]) {
            return binarySearch(nums, target,0, pivot - 1);
        }

        return  binarySearch(nums,target,pivot + 1, nums.length - 1);
    }

    public static int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mid < end && nums[mid] > nums[mid+1]){
                return mid;
            }
            else if(mid > start && nums[mid] < nums[mid-1]){
                return mid - 1;
            }
            else if(nums[mid] <= nums[start]){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target,int start, int end){

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target > nums[mid]){
                start = mid + 1;
            }
            else if(target < nums[mid]){
                end = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}