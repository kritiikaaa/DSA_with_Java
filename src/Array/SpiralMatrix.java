package Array;


// We need to print the elements of a 2-D Matrix in spiral order
public class SpiralMatrix {

    public static void printSpiral(int[][] matrix){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while(startRow <= endRow && startCol <= endCol){
            // Top row
            for(int j = startCol; j <= endCol; j++){
                System.out.print(matrix[startRow][j] + " ");
            }
            startRow++;

            // Right column
            for(int i = startRow; i <= endRow; i++){
                System.out.print(matrix[i][endCol] + " ");
            }
            endCol--;

            // Bottom row
            if(startRow <= endRow) {
                for(int j = endCol; j >= startCol; j--){
                    System.out.print(matrix[endRow][j] + " ");
                }
                endRow--;
            }

            // Left column
            if(startCol <= endCol) {
                for(int i = endRow; i >= startRow; i--){
                    System.out.print(matrix[i][startCol] + " ");
                }
                startCol++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printSpiral(matrix);
    }
}
