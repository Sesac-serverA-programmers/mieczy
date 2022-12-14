import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DequeProblem {
    /* 18258: ํ2 */
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

    /* 2164: ์นด๋2 */
    public static void boj2164() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // ์นด๋์
        Deque<Integer> card = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            card.offer(i);
        }

        while (card.size() != 1) {
            card.pollFirst();               // ๊ฐ์ฅ ์์ ์๋ ์นด๋ ์ญ์? ํ,
            card.offer(card.pollFirst());   // ์?์ผ ์์ ์๋ ์นด๋๋ฅผ ๋ง์ง๋ง์ผ๋ก ์ด๋
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
            if (packet == -1) { // ์๋?ฅ ์ข๋ฃ
                break;
            }

            if (packet == 0) {  // ํจํท ์ฒ๋ฆฌ
                buffer--;
                router.poll();
            } else {
                if (buffer == bufferSize) { // ๋ฒํผ๊ฐ ๊ฝ ์ฐฌ ๊ฒฝ์ฐ, ํจํท์ ๋ฐ์ง ์์
                    continue;
                }
                buffer++;
                router.offer(packet);
            }
        }

        // ํจํท ์ถ๋?ฅ
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

    /* 11866: ์์ธํธ์ค ๋ฌธ์? 0 */
    public static void boj11866() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        // ์ ์์ฑ
        Deque<Integer> people = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            people.offer(i);
        }

        int[] removeArr = new int[N];
        int idx = 0;
        while (!people.isEmpty()) {
            // K-1๋ฒ ํต๊ณผ
            for (int j=1; j<K; j++) {
                people.offer(people.pollFirst());
            }
            // ์?๊ฑฐ๋ ์ฌ๋ ์?์ฅ
            removeArr[idx] = people.pollFirst();
            idx++;
        }

        // ์์ธํธ์ค ์์ด ์ถ๋?ฅ
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
