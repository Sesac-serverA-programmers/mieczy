import java.io.*;

public class DynamicProgramming {
    public static int dCount = 0;

    /* 24416: 알고리즘 수업 - 피보나치 수 1 */
    public static void boj24416() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[41];
        arr[1] = 1;
        arr[2] = 1;

        // n번째 피보나치 값 = rFib(n) 호출 횟수
        rFib(n);
        dFib(arr, n);

        System.out.println(rFib(n) + " " + dCount);
        return;
    }

    /* 재귀 피보나치 */
    public static int rFib(int n) {
        // 1들의 합으로 N번째 피보나치의 값을 계산
        if (n == 1 || n == 2) {
            return 1;
        }
        else {
            return rFib(n - 1) + rFib(n - 2);
        }
    }

    /* DP 피보나치 */
    public static int dFib(int[] arr, int n) {
        for (int i=3; i<=n; i++) {
            // static dCount 변수 증가
            dCount++;
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    /* 9184: 신나는 함수 실행 */
    public static void boj9184() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 반복문 안에 있으면 메모리 초과 발생
        int[][][] arr = new int[21][21][21];    // DP 배열

        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            // 종료 조건
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            // printf = 시간 초과의 이유
            bw.write("w(" + a + ", " + b + ", " + c +") = " + w(arr, a, b, c) + "\n");
            bw.flush();
        }

        bw.close();
        return;
    }

    /* 9184: DP로 구현한 w 함수 : Mathmatics 클래스의 DP 조합 함수 참고) */
    public static int w(int[][][] arr, int a, int b, int c) {
        // 음수 값 처리를 위한 가장 첫 조건
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        // 20 초과의 수는 일괄 처리
        if (a > 20 || b > 20 || c > 20) {
            if (arr[20][20][20] == 0) {  // 계산된 값이 없는 경우(시간 초과로 추가)
                arr[20][20][20] = w(arr, 20, 20, 20);
                return arr[20][20][20];
            }
            return arr[20][20][20];
        }

        // 계산한 값이 있다면 return
        if (arr[a][b][c] > 0) {
            return arr[a][b][c];
        }

        // 없다면 함수 호출 및 계산 후 값 저장
        if (a < b && b < c) {
            arr[a][b][c] = w(arr, a, b, c-1) + w(arr, a, b-1, c-1) - w(arr, a, b-1, c);
        } else {
            arr[a][b][c] = w(arr, a-1, b, c) + w(arr, a-1, b-1, c) + w(arr, a-1, b, c-1) - w(arr, a-1, b-1, c-1);
        }

        return arr[a][b][c];
    }

    /*1904: 01타일
    * 테이블: D[i] = i자리의 2진 수열의 개수
    * 점화식: OEIS에 붙여넣어서 풀이 => 피보나치 수열 F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.
    * 기저사례 처리
    * */
    public static void boj1904() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // DP 배열
        int[] arr = new int[1000005];
        // 기저사례 처리
        arr[1] = 1;
        arr[2] = 1;

        System.out.println(tile(arr, N+1));
        return;
    }

    /* 1904: DP로 구현한 fibo 함수 */
    public static int tile(int[] arr, int n) {
        for (int i=3; i<=n; i++) {
            // fib(n) / 15746의 나머지를 저장
            arr[i] = (arr[i-1] + arr[i-2]) % 15746;
        }
        return arr[n];
    }

    /* 9461: 파도반 수열
     * 테이블: i번째 파도반 수
     * 점화식: OEIS:  a(n) = a(n-2) + a(n-3)
     */
    public static void boj9461() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        // int형은 오버플로우 발생
        long[] arr = new long[105];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(padovan(arr, N) + "\n");
        }

        System.out.println(sb);
        return;
    }

    public static long padovan(long[] arr, int n) {
        for (int i=5; i<=n; i++) {
            arr[i] = arr[i-2] + arr[i-3];
        }
        return arr[n];
    }

    /* 1912: 연속합
     * 풀이 참고: https://zoonvivor.tistory.com/152
     * 테이블: Max(이전부터 i까지 연속한 값, 지금부터 연속한 값)
     * */
    public static void boj1912() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int sum[] = new int[n];
        sum[0] = Integer.parseInt(input[0]);
        for (int i=1; i<n; i++) {
            int x = Integer.parseInt(input[i]);
            // (이전까지 합 + x)와 현재 x의 값 비교
            // 매 순서마다 현재값부터 더할지 말지를 계산하므로 상관하지 않아도 됨
            sum[i] = Math.max(sum[i-1] + x, x);
        }

        // 가장 큰 값
        int max = -10000;
        for (int t : sum) {
            if (max < t) {
                max = t;
            }
        }

        System.out.println(max);

        return;
    }

    /* 1149: RGB 거리
     * 모든 색 조합에 대한 비용을 계산하되 비용이 최소가 되는 방향으로 저장함
    * */
    public static void boj1149() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][];
        for (int i =0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            cost[i] = new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])};
        }

        // 집을 선택할 수 있는 조합에 대한 최소 비용을 선택 및 합하여 저장
        int[][] totalCase = new int[N][3];
        for (int j=0; j<N; j++) {
            // Red: 0, Green: 1, Blue: 2
            if (j == 0) {   // 첫번째 집은 자신의 값부터 시작
                totalCase[j][0] = cost[0][0];
                totalCase[j][1] = cost[0][1];
                totalCase[j][2] = cost[0][2];
            } else {
                totalCase[j][0] = cost[j][0] + Math.min(totalCase[j - 1][1], totalCase[j - 1][2]);  // j번째 집이 Red인 경우
                totalCase[j][1] = cost[j][1] + Math.min(totalCase[j - 1][0], totalCase[j - 1][2]);  // j번째 집이 Green인 경우
                totalCase[j][2] = cost[j][2] + Math.min(totalCase[j - 1][0], totalCase[j - 1][1]);  // j번째 집이 Blue인 경우
            }
        }

        // 최소 비용
        int min = 1000*N;
        for (int c : totalCase[N-1]) {
            if (min > c) {
                min = c;
            }
        }

        System.out.println(min);
        return;
    }

    /* 1932: 정수 삼각형
     */
    public static void boj1932() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<input.length; j++) {
                triangle[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] arr = new int[n][n];
        arr[0][0] = triangle[0][0]; // 꼭대기 값

        // 위에서 아래로 내려가며 가장 합이 크도록 더함
        for (int i=1; i<n; i++) {
            for (int j=0; j<triangle[i].length; j++) {
                if (j == 0) {   // 가장 왼쪽 끝
                    arr[i][j] = triangle[i][j] + arr[i-1][j];
                }
                else if (j == triangle[i].length-1) {   // 가장 오른쪽 끝
                    arr[i][j] = triangle[i][j] + arr[i-1][j-1];
                }
                else {
                    arr[i][j] = triangle[i][j] + Math.max(arr[i-1][j-1], arr[i-1][j]);
                }
            }
        }

        // 최대 합
        int max = -1;
        for (int x : arr[n-1]) {
            if (max < x) {
                max = x;
            }
        }

        System.out.println(max);
        return;
    }

    /* 2579: 계단 오르기
     * i번째에 왔을 때, 이어서 밟고 온 경우와 뛰어 넘고 온 경우가 있음.
     * 이어서 밟고 온 경우 = 직전 계단까지 최대값 + 이전계단 + 현재 계단
     * 뛰어넘고 온 경우 = 전전 계단까지 최대값 + 현재 계단
     * 참고: https://kwanghyuk.tistory.com/4
     */
    public static void boj2579() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stair = new int[N];

        for (int i=0; i<N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        // N의 개수에 따른 출력 처리
        if (N == 1) {
            System.out.println(stair[0]);
            return;
        } else if (N == 2) {
            System.out.println(Math.max(stair[0]+stair[1], stair[1]));
            return;
        }

        int [] arr = new int[N];
        // 3번째 계단까지 선택할 수 있는 경우의 수
        arr[0] = stair[0];
        arr[1] = Math.max(stair[0]+stair[1], stair[1]);
        arr[2] = Math.max(stair[0]+stair[2], stair[1]+stair[2]);

        for (int i=3; i<N; i++) {
            int step = arr[i-3] + stair[i-1] + stair[i];
            int jump = arr[i-2] + stair[i];
            arr[i] = Math.max(step, jump);
        }

        System.out.println(arr[N-1]);
        return;
    }

    /* 1463: 1로 만들기
     * D[i] = i를 1로 만드는 최소 연산 횟수
     */
    public static void boj1463() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+2];

        arr[1] = 0;

        // i를 1로 만드는 3가지 방법
        int type1;
        int type2;
        int type3;

        for (int i=2; i<=N; i++) {
            // 초기화
            type2 = 1000000;
            type3 = 1000000;

            // 1을 빼는 경우 = 직전까지 1을 만드는 횟수 + 1
            type1 = arr[i-1] + 1;
            // 3으로 나누어 떨어지는 경우, i/3을 1로 만드는 횟수 + 1
            if (i%3 == 0) {
                type2 = arr[i/3] + 1;
            }
            // 2로 나누어 떨어지는 경우, i/2을 1로 만드는 횟수 + 1
            if (i%2 == 0) {
                type3 = arr[i/2] + 1;
            }

            arr[i] = Math.min(Math.min(type1, type2), type3);
        }

        System.out.println(arr[N]);
        return;
    }
}
