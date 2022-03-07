package algorithmWithLeetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands200 {
    private static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[] X_DELTA = {1, 0, -1, 0,};
    static int[] Y_DELTA = {0, 1, 0, -1};

    public static void main(String[] args) {
        String[][] grid = {{"1", "1", "1", "1", "0"},
                {"1", "1", "0", "1", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "0", "0", "0"}};
        int res = findIslands(grid);
        System.out.println(res);
    }

    private static int findIslands(String[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }
        int numOfIslands = 0;
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j].equals("1") && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    private static void bfs(String[][] grid, int x, int y, boolean[][] visited) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Coordinate curCoordinate = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = curCoordinate.x + X_DELTA[i];
                int newY = curCoordinate.y + Y_DELTA[i];
                if (!isValid(newX, newY, grid, visited)) {
                    continue;
                }
                queue.offer(new Coordinate(newX, newY));
                visited[newX][newY] = true;
            }
        }
    }

    private static boolean isValid(int newX, int newY, String[][] grid, boolean[][] visited) {
        if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
            return false;
        }
        if (visited[newX][newY]) {
            return false;
        }

        return grid[newX][newY].equals("1") ? true : false;

    }

}
