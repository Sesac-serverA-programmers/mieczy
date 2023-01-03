package boj.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class boj2667 {
    static String[] map;
    static boolean[][] visited;
    static int N;
    static int count = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String args[]) throws IOException {
        boj2667();
    }

    /* 2667: 단지번호붙이기 */
    public static void boj2667() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 방문 배열
        visited = new boolean[N][N];

        // 정답 배열
        ArrayList<Integer> answer = new ArrayList<>();

        // 그래프 간선 정보 저장
        map = new String[N];
        for (int i=0; i<N; i++) {
            map[i] = br.readLine();
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                // 방문하지 않았고, 값이 1인 좌표
                if (!visited[i][j] && map[i].charAt(j)=='1') {
                    visited[i][j] = true;
                    answer.add(bfs(j, i));
                }
            }
        }

        // 단지별 집의 수 정렬
        Collections.sort(answer);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x).append("\n");
        }
        System.out.println(answer.size());
        System.out.println(sb);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[y][x] = true;
        count = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i=0; i<4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                // 유효한 좌표이고 방문하지 않은 좌표이고 값이 1인 경우
                if (isValid(nx, ny) && !visited[ny][nx] && map[ny].charAt(nx) == '1') {
                    visited[ny][nx] = true;
                    q.add(new int[]{nx, ny});
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isValid(int x, int y) {
        return 0<=x && x<N && 0<=y && y<N;
    }
}