import java.io.*;
import java.util.*;

/*
* 백준 단계별 풀기: 정렬
* */
public class Sort {
    /* 2750: 수 정렬하기 */
    public static void boj2750() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        while (N != 0) {
            N--;
            arr[N] = Integer.parseInt(br.readLine());
        }

        // int형이므로 Dual-PivotQuickSort 수행
        // N이 1,000 이하이므로 N^2이어도 시간제한 통과
        Arrays.sort(arr);

        for (int x : arr) {
            System.out.println(x);
        }
    }

    /* 2587: 대표값 */
    public static void boj2587() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[5];
        int N = 5;
        int sum = 0;

        while (N != 0) {
            N--;
            arr[N] = Integer.parseInt(br.readLine());
            sum += arr[N];
        }

        // int형이므로 Dual-PivotQuickSort 수행
        // N이 5이므로 시간제한 통과
        Arrays.sort(arr);

        System.out.println(sum/5);
        System.out.println(arr[2]);
    }

    /* 25305: 커트라인 */
    public static void boj25305() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 띄어쓰기로 구분된 입력을 받기 위해 사용
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N, k;
        N = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        int arr[] = new int[N];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        // int형이므로 Dual-PivotQuickSort 수행
        // N이 1,000 이하이므로 시간제한 통과
        Arrays.sort(arr);

        System.out.println(arr[N-k]);
    }

    /* 2751: 수 정렬하기 2 */
    public static void boj2751() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for (int i=0; i<N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        // Tim Sort 수행: 최악의 경우에도 NlogN을 보장
        // N이 1,000,000이하
        Collections.sort(arr);

        for (int x : arr) {
            bw.write(x + "\n");
        }

        bw.flush();
        bw.close();
    }

    /* 10989: 수 정렬하기 3 */
    public static void boj10989() throws IOException {
        // 시간 5초, 메모리 8MB, 1 ≤ N ≤ 10,000,000, 입력값 ≤ 10,000
        // short형(2byte)으로 선언해도 최대 20MB 메모리 필요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[10001];

        // 인덱스를 입력값으로 하여 개수를 기록함
        for (int i=0; i<N; i++) {
            short x = Short.parseShort(br.readLine());
            arr[x]++;
        }

        int i = 1;
        while (i < 10001) {
            for (int j=0; j<arr[i]; j++) {
                bw.write(i + "\n");
            }
            i++;
        }
        bw.flush();
        bw.close();
    }

    /* 2108: 통계학 */
    public static void boj2108() throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        float N = Integer.parseInt(br.readLine());
        List<Integer> num = new ArrayList<>();
        int count[] = new int[8001];
        int sum = 0;

        // 값을 저장하면서 총합과 빈도 수를 계산
        // 인덱스는 0부터 시작하므로 음수를 위해 +4000으로 변경
        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            num.add(x);
            count[x+4000]++;
            sum += x;
        }

        // Tim Sort 수행: 최악의 경우에도 NlogN을 보장
        // N이 500,000이하
        Collections.sort(num);

        int avg = Math.round(sum / N);
        int mid = num.get((int)N/2);

        List<Integer> mode = new ArrayList<>();
        int maxCount = 0;
        // 리스트에서 가장 많이 나타나는 횟수를 확인
        for (int i=0; i<8001; i++) {
            if (count[i] >= maxCount) {
                maxCount = count[i];
            }
        }
        // 최빈값인 수를 모두 저장
        for (int i=0; i<8001; i++) {
            if (count[i] == maxCount) {
                mode.add(i-4000);
            }
        }

        int diff = num.get(num.size()-1) - num.get(0);

        System.out.println(String.format("%d\n%d\n%d\n%d\n", avg, mid, mode.size()>1 ? mode.get(1):mode.get(0), diff));
    }

    /* 1427: 소트인사이드 */
    public static void boj1427() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        List<Integer> numList = new ArrayList<>();
        // 숫자 문자열을 각 자리수별로 저장
        // char형을 int로 변경
        for (int i=0; i<n.length(); i++) {
            numList.add(n.charAt(i) - '0');
        }

        // Tim Sort 수행(내림차순): 최악의 경우에도 NlogN을 보장
        // N이 1,000,000,000이하
        Collections.sort(numList, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n.length(); i++) {
            sb.append(numList.get(i));
        }

        System.out.println(sb);
    }

    /* 11650: 좌표 정렬하기 */
    public static void boj11650() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> pos = new ArrayList<>();

        while (N != 0) {
            N--;
            String temp[] = br.readLine().split(" ");
            // 좌표 배열(x, y)을 리스트에 저장
            pos.add(new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])});
        }

        // 2차원 배열을 정렬
        Collections.sort(pos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // x좌표가 같다면 y좌표 오름차순
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i< pos.size(); i++) {
            sb.append(String.format("%s %s" ,pos.get(i)[0] ,pos.get(i)[1]) + "\n");
        }

        System.out.println(sb);
    }

    /* 11651: 좌표 정렬하기2 */
    public static void boj11651() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> pos = new ArrayList<>();

        while (N != 0) {
            N--;
            String temp[] = br.readLine().split(" ");
            // 좌표 배열(x, y)을 리스트에 저장
            pos.add(new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])});
        }

        // 2차원 배열을 정렬
        Collections.sort(pos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // y좌표가 같다면 x좌표 오름차순
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i< pos.size(); i++) {
            sb.append(String.format("%s %s" ,pos.get(i)[0] ,pos.get(i)[1]) + "\n");
        }

        System.out.println(sb);
    }

    /* 1181: 단어 정렬 */
    public void boj1181() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Pos> posList = new ArrayList<>();

        while (N-- > 0) {
            String w = br.readLine();
            posList.add(new Pos(w.length(), w));
        }

        // Pos 클래스 리스트 정렬
        Collections.sort(posList, new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                // 글자 수가 같을 경우, 사전 순
                if (o1.len == o2.len) {
                    return o1.word.compareTo(o2.word);
                }
                return  o1.len - o2.len;
            }
        });

        StringBuilder sb = new StringBuilder(posList.get(0).word + "\n");
        for (int i=1; i< posList.size(); i++) {
            if (posList.get(i-1).word.equals(posList.get(i).word)) {
                continue;
            }
            sb.append(posList.get(i).word + "\n");
        }

        System.out.println(sb);
    }

    /* POS 클래스 */
    class Pos {
        private int len;
        private String word;

        public Pos(int len, String word) {
            this.len = len;
            this.word = word;
        }
    }

    /* 1181: 나이순 정렬 */
    public void boj10814() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<User> userList = new ArrayList<>();

        while (N-- > 0) {
            String[] temp = br.readLine().split(" ");
            userList.add(new User(Integer.parseInt(temp[0]), temp[1]));
        }

        // User 클래스 리스트 정렬
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.age - o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i< userList.size(); i++) {
            sb.append(String.format("%d %s" ,userList.get(i).age ,userList.get(i).name) + "\n");
        }

        System.out.println(sb);
    }

    /* 회원 클래스 */
    class User {
        private int age;
        private String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    /* 18870: 좌표 압축 */
    public static void boj18870() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String num[] = br.readLine().split(" ");
        Integer origin[] = new Integer[N];
        Integer sorted[] = new Integer[N];
        // 순위 계산을 위해 map 구조 사용
        Map<Integer, Integer> rankMap = new HashMap<>();

        for (int i=0; i<N; i++) {
            origin[i] = Integer.parseInt(num[i]);
            sorted[i] = origin[i];
        }

        // 래퍼 클래스 배열이므로 Tim Sort 수행
        Arrays.sort(sorted);

        int ranking = 0;
        for (int j=0; j<N; j++) {
            int x = sorted[j];
            // 이미 순위가 정해진 경우, continue
            if (rankMap.containsKey(x)) {
                continue;
            }
            rankMap.put(x, ranking);
            ranking++;
        }

        StringBuilder sb = new StringBuilder();
        for (int k=0; k<N; k++) {
            sb.append(rankMap.get(origin[k]) + " ");
        }

        System.out.println(sb);
    }
}
