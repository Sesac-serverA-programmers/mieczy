import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DequeProblem {
    /* 18258: 큐2 */
    public static void boj18258() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input;
        Deque<String> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            input = br.readLine().split(" ");

            switch (input[0]) {
                case "push":
                    dq.offer(input[1]);
                    break;
                case "pop":
                    try {
                        sb.append(dq.remove()).append("\n");
                    } catch (NoSuchElementException e) {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if (dq.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    try {
                        sb.append(dq.element()).append("\n");
                    } catch (NoSuchElementException e) {
                        sb.append(-1).append("\n");
                    }
                    break;
                default:
                    try {
                        sb.append(dq.getLast()).append("\n");
                    } catch (NoSuchElementException e) {
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
        return;
    }

    /* 2164: 카드2 */
    public static void boj2164() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 카드셋
        Deque<Integer> card = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            card.offer(i);
        }

        while (card.size() != 1) {
            card.pollFirst();               // 가장 앞에 있는 카드 삭제 후,
            card.offer(card.pollFirst());   // 제일 위에 있는 카드를 마지막으로 이동
        }

        System.out.println(card.peek());
    }

    /* 15828: Router */
    public static void boj15828() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bufferSize = Integer.parseInt(br.readLine());
        int buffer = 0;

        Deque<Integer> router = new LinkedList<>();
        while (true) {
            int packet = Integer.parseInt(br.readLine());
            if (packet == -1) { // 입력 종료
                break;
            }

            if (packet == 0) {  // 패킷 처리
                buffer--;
                router.poll();
            } else {
                if (buffer == bufferSize) { // 버퍼가 꽉 찬 경우, 패킷을 받지 않음
                    continue;
                }
                buffer++;
                router.offer(packet);
            }
        }

        // 패킷 출력
        StringBuilder sb = new StringBuilder();
        if (router.isEmpty()) {
            sb.append("empty");
        } else {
            while (!router.isEmpty()) {
                sb.append(router.poll()).append(" ");
            }
        }
        System.out.println(sb);
        return;
    }

    /* 11866: 요세푸스 문제 0 */
    public static void boj11866() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        // 원 생성
        Deque<Integer> people = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            people.offer(i);
        }

        int[] removeArr = new int[N];
        int idx = 0;
        while (!people.isEmpty()) {
            // K-1번 통과
            for (int j=1; j<K; j++) {
                people.offer(people.pollFirst());
            }
            // 제거된 사람 저장
            removeArr[idx] = people.pollFirst();
            idx++;
        }

        // 요세푸스 순열 출력
        StringBuilder sb = new StringBuilder("<");
        for (int k=0; k<N; k++) {
            if (k == N-1) {
                sb.append(removeArr[k]).append(">");
                break;
            }
            sb.append(removeArr[k]).append(", ");
        }
        System.out.println(sb);
        return;
    }
}
