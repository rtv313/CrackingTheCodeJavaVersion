package Chapter1;

public class ZeroMatrix1_8 {

    public static void fillRowColumn(int[][]matrix,int row,int column){
        int columnLength = matrix.length;
        int rowLength = matrix[0].length;

        for(int i = 0;i < rowLength; i++){
            matrix[row][i] = 0;
        }

        for(int i = 0;i < columnLength; i++){
            matrix[i][column] = 0;
        }
    }

    public static void zeroMatrix(int[][]matrix){

        int[][] matrixClone = new int[matrix.length][matrix[0].length];
        // Clone Matrix
        for (int i = 0 ; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                matrixClone[i][j] = matrix[i][j];
            }
        }

        // Fill rows and columns
        for (int i = 0 ; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
               if(matrixClone[i][j]==0){
                   // Fill Matrix
                   fillRowColumn(matrix,i,j);
               }
            }
        }
    }

    public static void main(String args[]){
        int [][]matrix ={{1,1,1,1},
                         {1,0,1,0},
                         {1,1,1,0},
                         {1,1,1,0},};

        RotateMatrix1_7.displayMatrix(matrix);
        System.out.println("#######################");
        zeroMatrix(matrix);
        RotateMatrix1_7.displayMatrix(matrix);
    }
}
