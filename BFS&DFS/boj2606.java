package boj.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj2606 {
    static ArrayList<Integer>[] g;
    static boolean[] visited;
    static int count = 0;

    public static void main(String args[]) throws IOException {
        boj2606();
    }

    /* 2606: 바이러스 */
    public static void boj2606() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 방문 배열
        visited = new boolean[N];

        // 그래프 초기화
        g = new ArrayList[N];
        for (int i=0; i<N; i++) {
            g[i] = new ArrayList<>();
        }

        // 그래프 간선 정보 저장
        while (M-- > 0) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            g[u-1].add(v-1); // 인덱스이므로 -1
            g[v-1].add(u-1); // 양방향
        }

        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int node) {
        // 방문 처리
        visited[node] = true;
        // 노드 방문
        for (int i=0; i<g[node].size(); i++) {
            int nextNode = g[node].get(i);  // 갈 수 있는 정점
            if (!visited[nextNode]) {   // 방문하지 않았다면 방문
                count++;
                dfs(nextNode);
            }
        }
    }
}