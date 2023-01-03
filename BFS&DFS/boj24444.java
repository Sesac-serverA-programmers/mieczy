package boj.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class boj24444 {
    static ArrayList<Integer>[] g;
    static boolean[] visited;
    static int[] answer;
    public static int count = 0;

    public static void main(String args[]) throws IOException {
        boj24444();
    }

    /* 24444: 알고리즘 수업 - 너비 우선 탐색1 */
    public static void boj24444() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2])-1;   // 0-base

        visited = new boolean[V];   // 방문 배열
        answer = new int[V];    // 정답 배열

        // 그래프 초기화
        g = new ArrayList[V];
        for (int i=0; i<V; i++) {
            g[i] = new ArrayList<>();
        }

        // 그래프 간선 정보 저장
        while (E-- > 0) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            g[u-1].add(v-1); // 0-base
            g[v-1].add(u-1); // 양방향
        }

        // 그래프 정점 순서 정렬
        for (int i=0; i<V; i++) {
            Collections.sort(g[i]);
        }

        bfs(start);    // bfs 탐색

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x).append("\n");
        }
        System.out.println(sb);
        return;

    }
    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        answer[node] = ++count;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i=0; i<g[current].size(); i++) {
                int next = g[current].get(i);
                if (!visited[next]) {   // 방문하지 않았다면 방문
                    q.add(next);
                    visited[next] = true;
                    answer[next] = ++count;
                }
            }
        }
    }
}
