public class Main {
    public static void main(String[] args) {
        // Find position of an element in an sorted array of infinite numbers
//        int[] arr = {2,5,10,20,25,40,52,59,60,61,62,63,64,65,70};
//        int[] arr = new int[5000];
        int[] arr = new int[30];
        for(int i=0; i < arr.length; i++) arr[i] = i;
        int target = 24;
        System.out.println(arr.length);
        System.out.println(searchInfinite(arr, target));
    }

    public static int searchInfinite(int[] nums, int target){
        int[] startEnd = findEnds(nums,target);
        int start = startEnd[0];
        int end = startEnd[1];
        return binarySearch(nums,start,end,target);
    }

    public static int[] findEnds(int[] nums, int target){

        int start = 0;
        int end = 1;
        while(target > nums[end]){
                int temp = end + 1;
                end = end + (end - start + 1) * 2;
                start = temp;
        }
        return new int[] {start,end};
    }


    public static int binarySearch(int[] nums, int start, int end, int target){
        int loopCount = 0;
        while(start <= end){
            loopCount++;
            System.out.printf("Loop-%s..\n",loopCount);
            int mid = start + (end-start) / 2;

            if(target < nums[mid]){
                end = mid - 1;
            }
            else if(target > nums[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}