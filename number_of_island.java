/**
 * number_of_island
 */
public class number_of_island {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    num += findSize(grid, i, j);
                }
            }
        }
        return num;
    }

    private int findSize(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0) {
            return 0;
        }
        if (j >= grid[0].length || j < 0) {
            return 0;
        }
        if (grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        findSize(grid, i + 1, j);
        findSize(grid, i, j + 1);
        findSize(grid, i, j - 1);
        findSize(grid, i - 1, j);
        return 1;
    }
}