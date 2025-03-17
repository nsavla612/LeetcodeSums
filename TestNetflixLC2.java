import java.util.*;

public class TestNetflixLC2 {
    public static void main(String[] args) {
        List<List<String>> moviesDB = new ArrayList<>();
        moviesDB.add(Arrays.asList("m1", "m2", "m2", "m3", "m2" ));
        moviesDB.add(Arrays.asList("m4", "m2", "m5"  ));
        moviesDB.add(Arrays.asList("m6","m7","m4","m8","m1","m6","m6" ));

        List<List<String>> removedMoviesDB = removeDuplicates(moviesDB, 2);
        for(List<String> moviesList : removedMoviesDB) {
            for (String movie : moviesList) {
                System.out.print( movie + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> removeDuplicates( List<List<String>> moviesDB, int K) {
        TreeSet<String> moviesSet = new TreeSet<>();
        Queue<String> moviesQueue = new LinkedList<>();
        for(List<String> moviesList : moviesDB) {
            for(String movie : moviesList) {
                if(!moviesSet.contains(movie)) {
                    moviesSet.add(movie);
                    moviesQueue.offer(movie);
                }
            }
        }

        List<List<String>> resultList = new ArrayList<>();
        while(!moviesQueue.isEmpty()) {
            List<String> resultString = new ArrayList<>();
            for(int i = 0 ; i < K; i++) {
                if(moviesQueue.isEmpty()) break;
                resultString.add(moviesQueue.poll());
            }
            resultList.add(resultString);
        }
        return resultList;
    }
}
