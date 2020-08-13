
public class search_2D_matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        int init = matrix[x][y];
        while(x >= 0 && y >= 0 && x < m && y < n) {
            if(init > target) {
                init = matrix[x][y - 1];
            }else if (init < target) {
                init = matrix[x + 1][y];
            }else {
                return true;
            }
        }
        return false;
    }
}