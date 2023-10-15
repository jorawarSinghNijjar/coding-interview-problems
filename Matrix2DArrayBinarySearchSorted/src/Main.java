import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                //0   1   2   3
                {1,   2,  3,  4},
                {5,   6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };

        int target = 12;
        System.out.println(Arrays.toString(searchIndex(matrix, target)));
    }

    private static int[] searchIndex(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows == 1){
            return binarySearch1DArray(matrix, 0, 0,cols-1, target);
        }

        int rowStart = 0;
        int rowEnd = rows - 1;
        int colMid = (cols - 1) / 2;
        // Reducing search space by eliminating rows where target possibility is 0
        while(rowStart + 1 < rowEnd){
            int rowMid = rowStart + (rowEnd - rowStart) / 2;

            if(target == matrix[rowMid][colMid]){
                return new int[]{rowMid,colMid};
            }
            if(target < matrix[rowMid][colMid]){
                rowEnd = rowMid;
            }
            else{
                rowStart = rowMid;
            }
        }

        // After eliminating extra rows we are left with only 2 rows and thus 6 cases are possible:

        if(target == matrix[rowStart][colMid]) return new int[]{rowStart,colMid};
        if(target == matrix[rowStart + 1][colMid]) return new int[]{rowStart + 1,colMid};

        if(target <= matrix[rowStart][colMid - 1]){
            return binarySearch1DArray(matrix,rowStart,0, colMid - 1,target);
        }
        else if(target >= matrix[rowStart][colMid + 1] && target <= matrix[rowStart][cols-1]){
            return binarySearch1DArray(matrix,rowStart,colMid + 1, cols - 1,target);
        }
        if(target <= matrix[rowStart + 1][colMid - 1 ]){
            return binarySearch1DArray(matrix,rowStart + 1,0, colMid - 1,target);
        }
        else {
            return binarySearch1DArray(matrix, rowStart + 1,colMid + 1, cols - 1,target);
        }
    }

    private static int[] binarySearch1DArray(int[][] matrix, int row, int colStart, int colEnd, int target) {
        while(colStart <= colEnd){
            int colMid = colStart + (colStart - colEnd) / 2;

            if(target == matrix[row][colMid]){
                return new int[] {row,colMid};
            }
            if(target < matrix[row][colMid]){
                colEnd = colMid - 1;
            }
            else{
                colStart = colStart + 1;
            }
        }
        return new int[]{-1,-1};
    }
}