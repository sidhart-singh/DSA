package Arrays;

import java.util.Arrays;

public class NumMatrix {
    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int[][] matrixCopy = new int[matrix.length + 1][matrix[0].length + 1];

        // for(int[] row : matrix) System.out.println(Arrays.toString(row));
        // System.out.println();

        for(int row = 0; row < matrix.length; row++){
            // row-wise prefix
            int prefix = 0;
            for(int col = 0; col < matrix[0].length; col++){
                
                // matrixCopy[row + 1][col + 1] = current prefixSum + above(prefix of above row till the same col) : 
                // prefixSum of previous row till the current col + 
                // prefixSum of current row till previous col + 
                // the current element

                // need another variable to maintain prefix sum of current row
                prefix += matrix[row][col];
                matrixCopy[row + 1][col + 1] = prefix + matrixCopy[row][col + 1];
            }
            // System.out.println(Arrays.toString(matrixCopy[row]));
        }

        // for(int[] row : matrixCopy) System.out.println(Arrays.toString(row));
        sumMatrix = matrixCopy;
    }

    
    public int sumRegion(int row1, int col1, int row2, int col2) {
      
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1] - sumMatrix[row2 + 1][col1] + sumMatrix[row1][col1];
    
    }
}
