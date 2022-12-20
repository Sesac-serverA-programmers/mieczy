import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    /* 11047: 동전 0 */
    public static void boj11047() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] coin = new int[N];
        for (int i=N-1; i>-1; i--) {    // 역순으로 저장
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int c : coin) {
            count += K / c;
            K = K % c;
        }

        System.out.println(count);
        return;
    }

    /* 1931: 회의실 배정 */
    public static void boj1931() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input;
        Integer[][] meeting = new Integer[N][2];
        for (int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            meeting[i][0] = Integer.parseInt(input[0]);
            meeting[i][1] = Integer.parseInt(input[1]);
        }

        // 끝나는 시간이 빠른 순으로 정렬
        Arrays.sort(meeting, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 1;
        int before = meeting[0][1];
        for (int i=1; i<N; i++) {
            // 다음 미팅 시작 시간이 이전 미팅이 끝나는 시간 이후인 경우, 회의 추가
            if (before <= meeting[i][0]) {
                 count++;
                 before = meeting[i][1];
            }
        }

        System.out.println(count);
        return;
    }
}
