/*
Solution submitted by Jaikumar Guwalani.
*/

class Solution {
    public int swimInWater(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        PriorityQueue<Tuple> queue = new PriorityQueue<>((x,y) -> x.time - y.time);
        queue.offer(new Tuple(0,0,grid[0][0]));
        
        visited[0][0] = true;
        while(!queue.isEmpty())
        {
            Tuple tuple = queue.remove();
            if(tuple.row == n-1 && tuple.col == m-1) return tuple.time;

            int drow[] = {0,1,0,-1};
            int dcol[] = {-1,0,1,0};
            for(int i=0;i<4;i++) 
            {
                int nrow = tuple.row + drow[i];
                int ncol = tuple.col + dcol[i];
                if(isValid(nrow, ncol, grid, visited, n, m))
                {
                    visited[nrow][ncol] = true;
                    if(grid[nrow][ncol] > tuple.time) 
                        queue.offer(new Tuple(nrow, ncol, grid[nrow][ncol]));
                    else
                        queue.offer(new Tuple(nrow, ncol, tuple.time));
                }	
            }
            System.out.println();
        }
        return -1;	
    }

    boolean isValid(int row, int col, int grid[][], boolean visited[][], int n, int m)
    {
	    if(row>=0&& row<n && col>=0 && col<m && !visited[row][col]) return true; 
        return false;
    }

}

class Tuple{
	int row;
	int col;
	int time;

	Tuple(int row, int col, int time){
		this.row = row;
		this.col = col;
		this.time = time;
    }
}


