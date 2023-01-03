package boj.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1012 {
    static int N, M;
    static int[][] g;
    static boolean[][] visited;
    static int count = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        boj1012();
    }

    /* 1012: 유기농 배추 */
    public static void boj1012() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            // 배추밭 정보
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);

            visited = new boolean[N][M];   // 방문 배열
            g = new int[N][M];             // 그래프 초기화

            // 배추 위치 정보
            while (K-- > 0) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                g[y][x] = 1;
            }

            count = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    // 방문하지 않았고, 값이 1인 좌표
                    if (!visited[i][j] && g[i][j]==1) {
                        visited[i][j] = true;
                        bfs(j, i);
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[y][x] = true;
        // bfs 수행시 구역 1개 증가
        count++;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i=0; i<4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                // 유효한 좌표이고 방문하지 않은 좌표이고 값이 1인 경우
                if (isValid(nx, ny) && !visited[ny][nx] && g[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static boolean isValid(int x, int y) {
        return 0<=x && x<M && 0<=y && y<N;
    }
}
