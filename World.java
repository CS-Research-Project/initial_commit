   import javax.swing.*;
   import java.awt.*;
   import java.util.*;

   public class World implements Constants {
      private int[][] terrain;
      private ImageIcon[] blockImages;
   
      public World() {
         initWorld();
			fillground();
			fillground2();
        
      }
   
      private void initWorld() {
         int worldHeight = Constants.HEIGHT/Constants.BLOCK_SIZE;
         int worldWidth = Constants.WIDTH/Constants.BLOCK_SIZE;
        //Inits world
         terrain = new int[worldHeight][worldWidth];
         
         blockImages = new ImageIcon[3];
         blockImages[0] = new ImageIcon(getClass().getResource(PICTURES_PATH+"air.png"));
         blockImages[1] = new ImageIcon(getClass().getResource(PICTURES_PATH+"grass.png"));
         blockImages[2] = new ImageIcon(getClass().getResource(PICTURES_PATH+"dirt.png"));
      	//blockImages[3] = new ImageIcon(getClass().getResource("cloud.png"));
      }
   
      public int[][] getTerrain() {
         return terrain;
      }
   
      public Image getTerrainImage(int blockNumber) {
         return blockImages[blockNumber].getImage();
      }
   
      public void fillground(){
			int current_y = 10;
			int max_y = 5;
			int min_y = 30;
         Random rand = new Random();
         terrain[current_y][0] = 1;
         for(int i=1; i<terrain[0].length;i++){
            int x = rand.nextInt(3);
            if(x==0){
               if(current_y > max_y){
                  terrain[current_y-1][i] = 1;
                  current_y--;
               }
               else terrain[current_y][i] = 1;
            }
            if(x==1){
               terrain[current_y][i] = 1;
            }
            if(x==2){
               if(current_y < min_y){
                  terrain[current_y+1][i] = 1;
                  current_y++;
               }
               else terrain[current_y][i] = 1;
            }
         }
      }
      public void fillground2(){
         boolean huh = false;
         for(int i = 0; i<terrain[0].length; i++)
         {
            for(int j = 0; j<terrain.length; j++)
            {
               if(huh){
                  terrain[j][i] = 2;
               }
               if(terrain[j][i] == 1){
                  huh = true;
               }
            }
            huh = false;
         }   
      }
   
   }
