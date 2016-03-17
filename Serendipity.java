   import java.awt.*;
   import java.awt.event.*;
   import java.lang.Runnable;
   import javax.swing.*;
   import javax.swing.GroupLayout;
   import java.io.File;
   import java.util.ArrayList;
   import java.util.Random;
	
   public class Serendipity  implements Constants  {
   
      public Serendipity() {
         rand = new Random();
         gameState = 0;
         initSounds();
         initComponents();         
      }
   
      public static void main(String[] args) throws AWTException{
      
         Serendipity s = new Serendipity();
         s.switchPanels(MENU_KEY);
         while(true) {
            if(gameState == 1) {
            	//s.toggle_focus();
               //unloadMenuPanels();
               s.switchPanels(GAME_KEY);
               s.front();
               gameState = -1;
            }
         }
      }
   	
      private void initComponents() {
      	
         mainframe = new JFrame();
      	
         mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      	
         mainframe.setSize(800,600);
      	
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         w = mainframe.getSize().width;
         h = mainframe.getSize().height;
         x = (dim.width-w)/2;
         y = (dim.height-h)/2;
      
         mainframe.setLocation(x, y);
      	
      	
         loadMenuPanels();
         maingame = new Board();
      	
         cl = new CardLayout();
         mainframe.getContentPane().setLayout(cl);
         mainframe.add(loading, LOADING_KEY);
         mainframe.add(maingame, GAME_KEY);
         mainframe.add(mainmenu, MENU_KEY);
         mainframe.add(options, OPTIONS_KEY);
      	
         mainframe.setVisible(true);
      
      }	
   	
      public static void addPanel(JPanel jp, String name) {
         mainframe.add(jp, name);
      }
   	
      public static void initSounds() {
      
         master_vol = 0;
         effects_vol = 0;
         music_vol = 0;
      
         sound_array = new ArrayList<Sound>();
      	
         Sound clickSound = new Sound("clicksound", EFFECTS_PATH+"clickSoundFinal.wav", true);
         Sound laser_shoot = new Sound("laser_shoot", EFFECTS_PATH+"Laser_Shoot.wav", true);
         Sound explosion = new Sound("explosion", EFFECTS_PATH+"Explosion.wav", true);
         Sound hurt = new Sound("hurt", EFFECTS_PATH+"Hurt.wav", true);
         Sound jump = new Sound("jump", EFFECTS_PATH+"Jump.wav", true);
         Sound pickup = new Sound("pickup", EFFECTS_PATH+"Pickup.wav", true);
         Sound powerup = new Sound("powerup", EFFECTS_PATH+"Powerup.wav", true);
         Sound select = new Sound("select", EFFECTS_PATH+"Select.wav", true);
      	
         Sound sans = new Sound("sans", MUSIC_PATH+"sans.wav", false);
      	
         sound_array.add(clickSound);
         sound_array.add(laser_shoot);
         sound_array.add(explosion);
         sound_array.add(hurt);
         sound_array.add(jump);
         sound_array.add(pickup);
         sound_array.add(powerup);
         sound_array.add(select);
      	
         sound_array.add(sans);
      
      }
   	
      public static void switchPanels(String name){
         cl.show(mainframe.getContentPane(), name);
      }
   	
      public static void change_master (double c) {
         for(Sound s : sound_array)
            s.setVolume(c);
      }
   
      public static void change_effects (double c) {
         for(Sound e : sound_array)
            if(e.isEffect()) e.setVolume(4.0);
      
      }
   	
      public static void toggle_focus () {
         mainframe.setFocusable(false);
         mainframe.setFocusable(true);
      }
   	
      public static void front() throws AWTException {
         Robot robot = new Robot();
         robot.keyPress(KeyEvent.VK_ALT);
         robot.keyPress(KeyEvent.VK_TAB);
         robot.keyRelease(KeyEvent.VK_ALT);
         robot.keyRelease(KeyEvent.VK_TAB);
			mainframe.toFront();
      }
   	
      public static Sound getRandomEffect() {
         int rand_num = -1;
         do {
         
            rand_num = rand.nextInt(sound_array.size());
         
         } while (!(sound_array.get(rand_num)).isEffect());
         return sound_array.get(rand_num);
      }
   
      public static void change_music (double c) {
         for(Sound m : sound_array)
            if(!(m.isEffect())) m.setVolume(c);
      }
   	
      public static Sound getRandomMusic() {
         int rand_num = -1;
         do {
         
            rand_num = rand.nextInt(sound_array.size());
         
         } while ((sound_array.get(rand_num)).isEffect());
         return sound_array.get(rand_num);
      }
   
      public static void stop_all_sounds () { 
         for(Sound m : sound_array) m.stop(); }
   
      public static void stop_all_music () { 
         for(Sound m : sound_array) 
            if(!(m.isEffect())) m.stop(); }
   
      public static void stop_all_effects () { 
         for(Sound m : sound_array) 
            if(m.isEffect()) m.stop(); }
   
      public static void fade_all_sounds () { 
         for(Sound m : sound_array) m.fade(); }
   
      public static void fade_all_music () { 
         for(Sound m : sound_array) 
            if(!(m.isEffect())) m.fade(); }
   
      public static void fade_all_effects () { 
         for(Sound m : sound_array) 
            if(m.isEffect()) m.fade(); }
   		
      public static Sound getSound (String name) {
         for(Sound m : sound_array) {
            if ((m.getName().toLowerCase()).equals(name.toLowerCase())) 
               return m;
         }
         return null;
      }
   	
      public static void loadMenuPanels() {
      
         mainmenu = new MainMenu();
         loading = new LoadingPanel();
         options = new OptionsMenu();
      
      }
   	
      public static void unloadMenuPanels() {
      
         mainmenu = new JPanel();
         loading = new JPanel();
         options = new JPanel();
      
      }
   	
      public static void maxWindow() {
         mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
      }
      public static LoadingPanel getLoadingPanel() {
         return (LoadingPanel)loading;
      }
   	
      public static int getGameState() { 
         return gameState; }
      public static void setGameState(int gs) { gameState = gs; }
   	
      public static void load_game() {
      	
      	//fade_all_music();
         maxWindow();
      	//getSound("sans").loop();
         setGameState(1);
      
      }
   	
      public static void setVisible(boolean sv){ mainframe.setVisible(sv); }
   	
      private static int master_vol;
      private static int effects_vol;
      private static int music_vol;
      private static ArrayList<Sound> sound_array;
   
      private static int w;
      private static int h;
      private static int x;
      private static int y;
   	
      private static JFrame mainframe;
      private static JPanel loading;
      private static JPanel mainmenu;
      private static JPanel options;
      private static JPanel maingame;
   	
      public static int gameState;
      public static Random rand;
   	
      private static CardLayout cl;
   	
   }
	
	
