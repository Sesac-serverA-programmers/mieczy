package boj.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class boj1260 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] g;
    static boolean[] visitedD;
    static boolean[] visitedB;

    public static void main(String args[]) throws IOException {
        boj1260();
    }

    /* 1260: DFS와 BFS */
    public static void boj1260() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2])-1;   // 0-base

        // dfs/bfs 방문 배열
        visitedD = new boolean[V];
        visitedB = new boolean[V];

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

        // dfs 출력
        dfs(start);
        System.out.println(sb);

        sb.delete(0,sb.length());   // StringBuilder 초기화

        // bfs 출력
        bfs(start);
        System.out.println(sb);
    }

    public static void dfs(int node) {
        // 방문 처리
        visitedD[node] = true;
        sb.append(node+1).append(" ");  // 0-base이므로 +1

        // 노드 방문
        for (int i=0; i<g[node].size(); i++) {
            int nextNode = g[node].get(i);  // 갈 수 있는 정점
            if (!visitedD[nextNode]) {   // 방문하지 않았다면 방문
                dfs(nextNode);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visitedB[node] = true;
        sb.append(node+1).append(" ");  // 0-base이므로 +1

        while (!q.isEmpty()) {
            int currentNode = q.poll();

            // 노드 방문
            for (int i=0; i<g[currentNode].size(); i++) {
                int nextNode = g[currentNode].get(i);
                if (!visitedB[nextNode]) {   // 방문하지 않았다면 방문
                    q.add(nextNode);
                    visitedB[nextNode] = true;
                    sb.append(nextNode+1).append(" ");  // 0-base이므로 +1
                }
            }
        }
    }
}