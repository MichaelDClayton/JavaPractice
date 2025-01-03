package arraysandstrings;

public class RotateArray90ClockWise {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5,6,7,8},
                {1,2,3,4,5,6,7,8},
                {1,2,3,4,5,6,7,8},
                {1,2,3,4,5,6,7,8},
                {1,2,3,4,5,6,7,8},
                {1,2,3,4,5,6,7,8},
                {1,2,3,4,5,6,7,8},
                {1,2,3,4,5,6,7,8}};
        rotateMatrix90(matrix);
        printMatrix(matrix);
    }

    private static void rotateMatrix90(int[][] matrix) {
        /*
         * [1,2,3]              [1,1,1]
         * [1,2,3]   becomes    [2,2,2]
         * [1,2,3]              [3,3,3]
         */
        for(int i =0;i<matrix.length;i++){
            for(int j = i;j< matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i =0;i< matrix.length;i++){
            int left = 0;
            int right = matrix.length-1;
            while(left <=right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }


    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
