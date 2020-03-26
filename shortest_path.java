/**
 * shortest_path
 */
public class shortest_path {

    public static int min(int x, int y) {
        return x <= y? x : y;
    }
    public static int minPathSum(int[][] grid) {
        // if(m < 0 || n < 0) {
        //     return Integer.MAX_VALUE;
        // }else if(m == 0 && n == 0) {
        //     return grid[0][0];
        // }else {
        //     return min(minPathSum(grid, m -1, n), minPathSum(grid, m, n - 1)) + grid[m][n];
        // }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int cost[][] = { {1, 1, 1}, 
                         {10, 80, 2}, 
                         {40, 1, 1} }; 
                           
        System.out.print(minPathSum(cost)); 
    }
}