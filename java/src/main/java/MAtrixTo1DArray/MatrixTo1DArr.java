package MAtrixTo1DArray;

public class MatrixTo1DArr {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1},
        };

        int n = matrix.length;
        int m = matrix[0].length;

        int[] arr = new int[n*m];

        for (int row = 0; row  < n; row ++) {
            for (int col = 0; col < m; col++) {
                // Where i is the row and j is the column
                arr[row * m + col] = matrix[row][col];
            }
        }

        System.out.println(arr);
    }
}
