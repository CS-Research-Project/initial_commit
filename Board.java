   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.KeyAdapter;
   import java.awt.event.KeyEvent;
   import java.util.Timer;
   import java.util.TimerTask;


   public class Board extends JPanel implements Constants {
      private Timer timer;
      private Dude dude;
      private World world;
      private int camX, camY;
   
      public Board() {
         initBoard();
      }
   
      private void initBoard() {
         addKeyListener(new TAdapter());
         setBackground(Color.WHITE);
         setFocusable(true); // So u can click on it
         setDoubleBuffered(true);
      
         dude = new Dude();
         world = new World();
      
        // Inits timer for drawing
         final int INITIAL_DELAY = 10;
         final int PERIOD_INTERVAL = 1000 / TARGET_FPS;
         timer = new Timer();
         timer.scheduleAtFixedRate(new ScheduleTask(), INITIAL_DELAY, PERIOD_INTERVAL);
        // Inits timer for physics
         final int PHYSICS_INTERVAL = 1000 / CALCULATIONS_PER_SECOND;
         new Timer().schedule(new SchedulePhysicsTask(), INITIAL_DELAY, PHYSICS_INTERVAL);
      }
   
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         doDrawing(g);
        //  Toolkit.getDefaultToolkit().sync();
      }
   
      private void doDrawing(Graphics g) {
         Graphics2D g2d = (Graphics2D) g;
      
         { // Side-scrolling operations
            camX = dude.getX() - Constants.WIDTH / 2; // The center of the X viewport
            camY = dude.getY() - Constants.HEIGHT / 2; // The center of the Y viewport
         
            if (camX > OFFSET_MAX_X)
               camX = OFFSET_MAX_X;
            else if (camX < OFFSET_MIN_X)
               camX = OFFSET_MIN_X;
         
            if (camY > OFFSET_MAX_Y)
               camY = OFFSET_MAX_Y;
            else if (camY < OFFSET_MIN_Y)
               camY = OFFSET_MIN_Y;
         
            g2d.translate(-camX, -camY);
         }
      
         drawMap(g2d);
         g2d.drawImage(dude.getImage(), dude.getX(), dude.getY(), this);
      }
   
      private void drawMap(Graphics2D g2d) {
         int terrain[][] = world.getTerrain();
         for (int r = 0; r < terrain.length; r++) {
            for (int c = 0; c < terrain[0].length; c++) {
               g2d.drawImage(world.getTerrainImage(terrain[r][c]), c * BLOCK_SIZE, r * BLOCK_SIZE, this);
            }
         }
      }
   
      private void gravity() { // Makes people fall
         int player_foot_level = (dude.getY() + dude.getHitBox().height) / BLOCK_SIZE;
         int player_side = (dude.getX() + dude.getHitBox().width) / BLOCK_SIZE;
         if (world.getTerrain()[player_foot_level][player_side] == 0) {
            dude.fall();
         } 
         else
            dude.stopFalling();
      }
   
      private void checkHorizontalCollision() { 
         int player_right_side = (dude.getX() + dude.getHitBox().width + HORIZONTAL_MOVEMENT_SPEED - 1) / BLOCK_SIZE;
         int player_left_side = (dude.getX() - HORIZONTAL_MOVEMENT_SPEED-1) / BLOCK_SIZE;
         int player_foot_level = (dude.getY() + dude.getHitBox().height - 1) / BLOCK_SIZE;
         if (world.getTerrain()[player_foot_level][player_right_side] == 1) {
            dude.stopRunning();
         } 
         else if (world.getTerrain()[player_foot_level][player_left_side] == 1) {
            dude.stopRunning();
         } 
         else if (dude.getX() + dude.getHitBox().width >= Constants.WIDTH) {
            dude.stopRunning();
         } 
         else if (dude.getX() <= 0) {
            dude.stopRunning();
         }
      
      
      }
   
      private class ScheduleTask extends TimerTask { // Timer for drawing
         public void run() {
            repaint();
         }
      }
   
      private class SchedulePhysicsTask extends TimerTask { // Timer for physics / other calculations
         public void run() {
            dude.move();
            gravity();
            checkHorizontalCollision();
         }
      }
   
      private class TAdapter extends KeyAdapter { // Key listener
         public void keyReleased(KeyEvent e) {
            dude.keyReleased(e);
         }
      
         public void keyPressed(KeyEvent e) {
            dude.keyPressed(e);
         }
      }
   }