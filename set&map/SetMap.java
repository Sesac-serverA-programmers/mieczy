package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 백준 단계별 풀기: 집합과 맵
 * */
public class SetMap {

    /* 10815: 숫자 카드 */
    public static void boj10815() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // String 배열을 리스트로 저장 후, Set으로 변환
        List<String> myCard = List.of(br.readLine().split(" "));
        Set<String> myCardSet = new HashSet<>(myCard);

        int M = Integer.parseInt(br.readLine());
        String[] targetCard = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        // 타겟 카드가 포함되어 있는지 확인
        // contains: O(N)
        for (String t : targetCard) {
            if (myCardSet.contains(t)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }

    /* 14425: 문자열 집합 */
    public static void boj14425() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        Set<String> words = new HashSet<>();
        while (N-- > 0) {
            words.add(br.readLine());
        }

        int count = 0;
        while (M-- > 0) {
            String target = br.readLine();
            // 타겟 문자열이 포함되어 있으면 count 증가
            // contains: O(N)
            if (words.contains(target)) {
                count++;
            }
        }

        System.out.println(count);
    }

    /* 1620: 나는야 포켓몬 마스터 이다솜 */
    public static void boj1620() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        // 이름과 번호를 key로 가지는 각각의 map에 데이터 저장
        Map<String, String> nameMap = new HashMap<>();
        Map<String, String> numberMap = new HashMap<>();
        for (int i=1; i<=N; i++) {
            String name = br.readLine();
            String idx = String.valueOf(i);
            nameMap.put(name, idx);
            numberMap.put(idx, name);
        }

        StringBuilder sb = new StringBuilder();
        for (int j=0; j<M; j++) {
            String target = br.readLine();
            // 이름으로 찾기
            if (nameMap.containsKey(target)) {
                sb.append(nameMap.get(target) + "\n");
            // 번호로 찾기
            } else if (numberMap.containsKey(target)) {
                sb.append(numberMap.get(target) + "\n");
            }
        }

        System.out.println(sb);
    }

    /* 10816: 숫자 카드2 */
    public static void boj10816() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        // 숫자 카드의 중복된 값을 카운트
        Map<String, Integer> map = new HashMap<>();
        for (String n : input) {
            Integer count = map.get(n);
            if (count == null) {
                map.put(n, 1);
            } else {
                map.put(n, count+1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String n : input) {
            Integer count = map.get(n);
            if (count == null) {
                sb.append(0).append(" ");
            } else {
                sb.append(count).append(" ");
            }
        }

        System.out.println(sb);
        return;
    }
}
