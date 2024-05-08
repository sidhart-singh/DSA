package Backtracking;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x, y, distance, count2, count3;

    public Point(int x, int y, int distance, int count2, int count3) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.count2 = count2;
        this.count3 = count3;
    }
}

public class test {

    static boolean isValid(int x, int y, int R, int C, int[][] visited, int[][] maze) {
        return x >= 0 && x < R && y >= 0 && y < C && visited[x][y] != 1 && maze[x][y] != 1;
    }

    static int shortestPath(int[][] maze, int startX, int startY, int targetX, int targetY, int R, int C) {
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        int[][] visited = new int[R][C];

        Queue<Point> q = new LinkedList<>();
        if (maze[startX][startY] == 2) {
            q.add(new Point(startX, startY, 0, 1, 0));
        } else if (maze[startX][startY] == 3) {
            q.add(new Point(startX, startY, 0, 0, 1));
        } else {
            q.add(new Point(startX, startY, 0, 0, 0));
        }

        visited[startX][startY] = 1;
        int lastans = -1;
        int min3 = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Point current = q.poll();

            if (current.x == targetX && current.y == targetY) {

                if (current.count2 <= 2 && current.count3 == 0) {
                    return current.distance;
                } else if (current.count3 > 1 && min3 > current.count3) {
                    lastans = current.distance;
                    min3 = current.count3;
                }
            }

            for (int i = 0; i < 4; ++i) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (isValid(nx, ny, R, C, visited, maze)) {
                    int newDistance = current.distance + 1;

                    if (maze[nx][ny] == 3) {
                        q.add(new Point(nx, ny, newDistance, current.count2, current.count3 + 1));
                    } else if (maze[nx][ny] == 2) {
                        q.add(new Point(nx, ny, newDistance, current.count2 + 1, current.count3));
                    } else {
                        q.add(new Point(nx, ny, newDistance, current.count2, current.count3));
                    }

                    visited[nx][ny] = 1;
                }
            }
        }

        return lastans;
    }

}