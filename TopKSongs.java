/* Top Songs Class With Updates

// Implement a `TopSongs` class that receives an integer `k > 0` during initialization and has two methods:

// - `register_plays(title, plays)` indicates that a song was played a given number of times. It returns nothing. The method can be called with the same title multiple times, meaning that we should **add** the new plays to the total number of plays for that song.
// - `top_k()` returns the (up to) `k` registered song titles with the most plays, in any order, and breaking ties arbitrarily.

// ```
// Example:
// s = TopSongs(3)
// s.register_plays("Boolean Rhapsody", 100)
// s.register_plays("Boolean Rhapsody", 193)  # Total 293
// s.register_plays("Coding In The Deep", 75)
// s.register_plays("Coding In The Deep", 75)  # Total 150
// s.register_plays("All About That Base Case", 200)
// s.register_plays("All About That Base Case", 90)  # Total 290
// s.register_plays("All About That Base Case", 1)   # Total 291
// s.register_plays("Here Comes The Bug", 223)
// s.register_plays("Oops! I Broke Prod Again", 274)
// s.register_plays("All the Single Brackets", 132)
// s.top_k()  # Returns ["All About That Base Case", "Boolean Rhapsody", "Oops! I Broke Prod Again"]
// ```

// Constraints:

// - The number of songs is at most 10^5
// - Each element in songs is a tuple with a string and an integer
// There can be multiple calls to topK and RegisterPlays
  */


 class MovieNode {
      public String title;
      public int count;
      public MovieNode(String title, int count) {
        this.title = title;
        this.count = count;
      }
  }

class TopSongs { 
  Map<String, MovieNode> MovieCounts = new HashMap<>();
  PriorityQueue<MovieNode> minHeap = new PriorityQueue<>( (a,b) -> a.count - b.count);
  int capacity;

  public TopSongs(int k) {
    this.capacity = k;
  }

  public void register_plays(String movie, int count) {
     MovieNode tempMovieNode = MovieCounts.getOrDefault(movie, new MovieNode(movie, 0));
     tempMovieNode.count += count;
     MovieCounts.put(movie,tempMovieNode);
    
     if(MovieCounts.containsKey(movie)) {
          minHeap.remove(MovieCounts.get(movie));
      } 
      minHeap.add(tempMovieNode);
  
      if(minHeap.size() > this.capacity) {
          minHeap.remove(minHeap.peek());
      }
  }

  public List<String> getTopKMovies() {
      List<MovieNode> topKNodes = new ArrayList<>(minHeap);
      List<String> topKString = topKNodes.stream().map(node -> node.title).toList();
      
      return topKString;
  }
}

class Solution {
  public static void main(String[] args) {
    TopSongs topSongs = new TopSongs(3);
    topSongs.register_plays( "A", 100);
    topSongs.register_plays( "B", 1);
    topSongs.register_plays( "C", 99);
    topSongs.register_plays( "D", 100);
    topSongs.register_plays( "E", 101);
    topSongs.register_plays( "F", 100);
    
    for (String string : topSongs.getTopKMovies()) {
      System.out.println(string);
    } System.out.println();
    
    topSongs.register_plays( "B", 101);
    for (String string : topSongs.getTopKMovies()) {
      System.out.println(string);
    } System.out.println();

    topSongs.register_plays( "B", 101);
    for (String string : topSongs.getTopKMovies()) {
      System.out.println(string);
    } System.out.println();

    topSongs.register_plays( "C", 101);
    for (String string : topSongs.getTopKMovies()) {
      System.out.println(string);
    } System.out.println();
  }
}
