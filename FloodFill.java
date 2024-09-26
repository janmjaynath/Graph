import java.util.*;
public class FloodFill {

    public static void helper(int [][]images,int sr,int sc,int color,boolean visit[][] ,int orgcol){
        if(sr < 0 || sc < 0 || sr > images.length || sc > images[0].length || visit[sr][sc] || images[sr][sc] != orgcol){

            //Left
            helper(images,sr,sc-1,color,visit,orgcol);

            //Right
            helper(images, sr, sc+1, color, visit, orgcol);

            //Top
            helper(images, sr-1, sc, color, visit, orgcol);

            //Down
            helper(images, sr+1, sc, color, visit, orgcol);
        }
    }
    
    public static int [][]floodfill(int [][]images,int sr,int sc, boolean vist[][] ,int color){

        boolean visit[][] = new boolean[images.length][images[0].length];
        helper(images,sr,sc,color,visit,images[sr][sc]);

        return images;
    }

    public static void main(String[] args) {
        int images[][] = {{1,1,1},
                         {1,1,0},
                        {1,0,1}};

          System.out.println(floodfill(images, 1, 1,null, 2));
     
    }
}
