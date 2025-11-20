// 장르별로, 많은걸 찾아야함.
// 장르별, 노래 정보를 top2 가져올 수 있어야함.

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, PriorityQueue<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            genreTotal.put(g, genreTotal.getOrDefault(g, 0) + p);
            genreSongs.putIfAbsent(g, new PriorityQueue<>(
                    (a, b) -> {
                        if (a.plays != b.plays) return b.plays - a.plays;
                        return a.id - b.id;
                    }
            ));

            genreSongs.get(g).offer(new Song(g, i, p));
        }

        List<String> order = new ArrayList<>(genreTotal.keySet());
        order.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        List<Integer> answerList = new ArrayList<>();

        for (String g : order) {
            PriorityQueue<Song> pq = genreSongs.get(g);

            int cnt = 0;
            while (!pq.isEmpty() && cnt < 2) {
                answerList.add(pq.poll().id);
                cnt++;
            }
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
    
    private class Song {
        private String genre;
        private int id;
        private int plays;
        
        public Song(String genre, int id, int plays) {
            this.genre = genre;
            this.id = id;
            this.plays = plays;
        }
    }
}