package Chapter1;

public class RotateMatrix1_7 {

    public static void fillMatrix(int[][]matrix){
        int counter = 0;
        for (int i = 0; i < matrix[0].length; i++){
            for (int j = 0; j < matrix.length;j++){
                matrix[i][j] = counter;
                counter++;
            }
        }
    }

    public static void displayMatrix(int[][]matrix){
        for (int i = 0; i < matrix[0].length; i++){
            String row = " ";
            for (int j = 0; j < matrix.length;j++){
               row+= String.valueOf(matrix[i][j]) + ",";
            }
            System.out.println(row);
        }
    }

    public static void rotateMatrix(int[][]matrix){
        int layers = matrix.length / 2;
        int n = matrix.length;

        for (int x = 0; x < layers; x++){

            for (int y = x ; y < n-x-1; y++){

                int auxOne = matrix[x][y];
                int auxTwo = matrix[y][n-1-x];
                int auxThree = matrix[n-1-x][n-1-y];
                int auxFour = matrix[n-1-y][x];

                matrix[x][y] = auxFour;
                matrix[y][n-1-x] = auxOne;
                matrix[n-1-x][n-1-y] = auxTwo;
                matrix[n-1-y][x] = auxThree;
            }
        }
    }

    public static void main(String args[]){

        int[][] matrix = new int[4][4];
        fillMatrix(matrix);
        displayMatrix(matrix);
        System.out.println(("###############################"));
        rotateMatrix(matrix);
        displayMatrix(matrix);
    }
}
