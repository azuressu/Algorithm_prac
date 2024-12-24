package org.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class P22 {

    /**
     * [문제 22] 베스트 앨범
     * 스트리밍 사이트에서 장르별로 가장 많이 재생된 노래를 2개씩 모아 베스트 앨범을 출시
     * 노래는 고유 번호로 구분, 노래 수록 기준은 다음과 같음
        * 속한 노래가 많이 재생된 장르 우선 수록
        * 장르 내에서 많이 재생된 노래를 우선 수록
        * 장스 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래 우선 수록
     * 제약 조건
        * genres[i]는 고유 번호가 i인 노래
        * plays[i]는 고유 번호가 i인 노래의 재생 횟수
        * genres와 plays의 길이는 같고, 1 이상 10,000 이하
        * 장르 종류는 100가지 미만, 장르에 속한 곡이 하나라면 하나의 곡만 선택
        * 모든 장르는 재생된 횟수가 다름
     */

    private static int[] solution(String[] genres, int[] plays) {
        // 장르에 따른 HashMap
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        // 재생 횟수에 따른 HashMap
        HashMap<String, Integer> playMap = new HashMap<>();

        // 1. 장르별 총 재생 횟수와 각 곡의 재생 횟수 저장
        for (int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 만약, 만들어둔 hashmap에 genre 키가 존재하지 않는다면 (nullpointException 발생 가능)
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }

            // 장르에 새로운 곡 번호와 재생 횟수 리스트 추가
            genreMap.get(genre).add(new int[]{i, play});
            // 기존에 저장되어 있던 장르 재생 횟수에 해당 장르 재생 횟수 더하기
            playMap.put(genre, playMap.get(genre) + play);
        } // for

        ArrayList<Integer> answer = new ArrayList<>();

        // 2. 총 재생 횟수가 많은 장르순으로 내림차순 정렬
        Stream<Map.Entry<String, Integer>> sortedGenre = playMap.entrySet()
                .stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        // 3. 각 장르 내에서 노래를 재생 횟수 순으로 정렬해 최대 2곡까지 선택
        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                    // 두 번째에 저장된 고유 번호만 가져옴
                    .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                    .limit(2);
            sortedSongs.forEach(song->answer.add(song[0]));
        });
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500,600,150,800,2500};
        int[] result = solution(genres, plays);
        System.out.println("result: " + Arrays.toString(result));
    }

}
