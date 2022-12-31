package Arrays;

public class BrickWall {
    // [1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]
    int wall[][] = { {1,2,2,1},
                     {3,1,2},
                     {1,3,2},
                     {2,4},
                     {3,1,2},
                     {1,3,1,1}
                    };
    
    public int leastBricks(){

        int result = 0;
        int row_sum = 0;
        int i = 0; 
        int j = 0;


        // rows -> wall.length : no. of rows in wall
        // column -> 2 * maxumum no. of elements
        int hashTable[][] = new int[wall.length][row_sum + 1];

        

        return result;
    }

}
