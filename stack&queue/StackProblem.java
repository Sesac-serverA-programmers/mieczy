import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackProblem {

    /* 10828: 스택 */
    public static void boj10828() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input;
        Stack<String> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            input = br.readLine().split(" ");

            switch (input[0]) {
                case "push":
                    stk.push(input[1]);
                    break;
                case "pop":
                    try {
                        sb.append(stk.peek()).append("\n");
                        stk.pop();
                    } catch (EmptyStackException e) {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(stk.size()).append("\n");
                    break;
                case "empty":
                    if (stk.empty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "top":
                    try {
                        sb.append(stk.peek()).append("\n");
                    } catch (EmptyStackException e) {
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
        return;
    }

    /* 10773: 제로 */
    public static void boj10773() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<String> stk = new Stack<>();
        String input;
        while (K-- > 0) {
            input = br.readLine();
            if (input.equals("0")) {
                stk.pop();
            } else {
                stk.push(input);
            }
        }

        int sum = 0;
        while (!stk.empty()) {
            sum += Integer.parseInt(stk.peek());
            stk.pop();
        }

        System.out.println(sum);
        return;
    }
}
