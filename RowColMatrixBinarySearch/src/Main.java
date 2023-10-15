import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 8, 9, 10},
                {11, 13, 15, 18},
                {20, 22, 23, 28},
                {30, 33, 39, 40}
        };
        int target = 22;
        System.out.println(Arrays.toString(searchIndex(matrix, target)));
    }

    private static int[] searchIndex(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[row].length - 1;

        while(row < matrix.length && col >=0){
            if(matrix[row][col] == target){
                return new int[]{row,col};
            }
            else if(matrix[row][col] < target){
                row++;
            }
            else{
                col--;
            }
        }
        return new int[]{-1,-1};
    }
}