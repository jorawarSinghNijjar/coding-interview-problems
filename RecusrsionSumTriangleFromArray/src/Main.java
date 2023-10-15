import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Given an array of integers, print a sum triangle from it
//        such that the first level has all array elements.
//        From then, at each level number of elements is one less than the previous level
//        and elements at the level is be the Sum of consecutive two elements in the previous level.
//
//        Input : A = {1, 2, 3, 4, 5}
//        Output : [48]
//                 [20, 28]
//                 [8, 12, 16]
//                 [3, 5, 7, 9]
//                 [1, 2, 3, 4, 5]
//
//        Explanation :
//        Here,   [48]
        //        [20, 28] -->(20 + 28 = 48)
        //        [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
        //        [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
        //        [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)

        int[] A = {1, 2, 3, 4, 5};
        printTriangle(A);
    }

    static void printTriangle(int[] arr){
        //Base case
        if(arr.length < 1) return;

        // Creating new array which contains the
        // Sum of consecutive elements in
        // the array passes as parameter.
        int[] newArr = new int[arr.length - 1];

        for(int i=0; i < newArr.length; i++){
            newArr[i] = arr[i] + arr[i+1];
        }

        // Make a recursive call and pass
        // the newly created array
        printTriangle(newArr);

        // Print current array in the end so
        // that smaller arrays are printed first
        System.out.println(Arrays.toString(arr));
    }
}
