import java.util.*;

public class TestUserWatchedEpisode {
    public static void main(String[] args) {
        List<String> episodes = Arrays.asList("1,55" , "2,66" , "3,77" , "4,51" ,"5,66" );
        System.out.println(" Has user watched twice- " + hasUserWatchedTwice(episodes));
        System.out.println(" Has user watched twice in K days - " + hasUserWatchedTwiceInKDays(episodes, 4));
        System.out.println(" Has user watched same season twice in K days - " + hasUserWatchedSameSeasonTwiceInKDays(episodes, 4, 10));

    }

    public static boolean hasUserWatchedTwice(List<String> episodes) {
        Set<String> epsiodeSet = new HashSet<>();
        for(String episode : episodes) {
            String episodeId = episode.split(",")[1];
            if(epsiodeSet.contains(episodeId)) return true;
            epsiodeSet.add(episodeId);
        }
        return false;
    }

    public static boolean hasUserWatchedTwiceInKDays(List<String> episodes, int K) {
        Set<String> episodeSet = new HashSet<>();
        for(int index = 0 ; index < episodes.size(); index++) {
            String episodeId = episodes.get(index).split(",")[1];
            if(index >= K) {
                String previousEpisodeId = episodes.get(index - K).split(",")[1];
                episodeSet.remove(previousEpisodeId);
            }

            if(episodeSet.contains(episodeId))  {
                return true;
            } else {
                episodeSet.add(episodeId);
            }
        }
        return false;
    }

    public static boolean hasUserWatchedSameSeasonTwiceInKDays(List<String> episodes, int K, int T) {
        Set<String> episodeSet = new TreeSet<>();
        for(int index = 0 ; index < episodes.size(); index++) {
            String episodeId = episodes.get(index).split(",")[1];
            if(index >= K) {
                String previousEpisodeId = episodes.get(index - K).split(",")[1];
                episodeSet.remove(previousEpisodeId);
            }
            episodeSet.add(episodeId);

            Iterator<String> iterator = episodeSet.iterator();
            int first = Integer.parseInt(iterator.next());
            while (iterator.hasNext()) {
                int second = Integer.parseInt(iterator.next());
                if(Math.abs(second - first) <= T ) return true;
                first = second;
            }
        }
        return false;
    }
}
