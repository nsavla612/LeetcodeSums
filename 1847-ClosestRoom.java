class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int[] result = new int[queries.length];
        int rIndex = 0;
        Arrays.sort(rooms, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for(int[] query : queries) {
            int startIndex = findStartIndex( rooms, query[1]);
            if(startIndex == -1) {
                 result[rIndex++] = -1; continue;
            } else {
                int minDifference = Math.abs(rooms[startIndex][0] - query[0]);
                int minIndex = rooms[startIndex][0];
                for(int i = startIndex ; i < rooms.length ; i++) {
                    int diff = Math.abs(rooms[i][0] - query[0]);
                    if(diff < minDifference) {
                        minDifference = diff;
                        minIndex = rooms[i][0];
                    } else if( diff == minDifference) {
                         minIndex = Math.min( minIndex, rooms[i][0]);
                    }
                }
                result[rIndex++] = minIndex;
            }
          
        }
        return result;
    }

    public int findStartIndex(int[][] rooms, int target) {
        int index = -1;
        int low = 0, high = rooms.length - 1;
        while( low <= high) {
            int mid = low + ( high - low ) / 2;
            if(rooms[mid][1] >= target) {
                index = mid ;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}
