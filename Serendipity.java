   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import javax.swing.GroupLayout;
   import java.io.File;
   import java.util.ArrayList;
	
   public class Serendipity extends JFrame implements Constants{
   
      public static void main(String[] args){
      	initComponents();
   		initSounds();
			Serendipity frame = new Serendipity();   
         frame.show(MENU_KEY);
			
      }
		
		public static void initComponents() {
			
			mainframe = new JFrame();
			
			mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			mainframe.setSize(800,600);
			mainframe.setFocusable(true);
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         w = getSize().width;
         h = getSize().height;
         x = (dim.width-w)/2;
         y = (dim.height-h)/2;
      
			mainframe.setLocation(x, y);
      	
			loading = new LoadingPanel();
			
			mainmenu = new MainMenu();
			
         CardLayout cl = new CardLayout();
         
			getContentPane().setLayout(cl);
			
         add(loading, LOADING_KEY);
         add(mainmenu, MENU_KEY);
		
		}	
		
		public static void initSounds() {
			master_vol = 0;
         effects_vol = 0;
         music_vol = 0;
      
         sound_array = new ArrayList<Sound>();
			
			clickSound = new Sound(EFFECTS_PATH+"clickSoundFinal.wav", true);
         sans = new Sound(MUSIC_PATH + "sans.wav", false);
      
         sound_array.add(clickSound);
         sound_array.add(sans);
			
		}
		
		public void switchPanels(String panelName){
		show(panelName);
		}
		
		public void change_master (int c) {
         for(Sound s : sound_array)
            s.setVolume(c);
      }
   
      public void change_effects (int c) {
         for(Sound e : sound_array)
            if(e.isEffect()) e.setVolume(c);
      
      }
   
      public void change_music (int c) {
         for(Sound m : sound_array)
            if(!(m.isEffect())) m.setVolume(c);
      
      }
   
      public void stop_all_sounds () { 
         for(Sound m : sound_array) m.stop(); }
   
      public void stop_all_music () { 
         for(Sound m : sound_array) 
            if(!(m.isEffect())) m.stop(); }
   
      public void stop_all_effects () { 
         for(Sound m : sound_array) 
            if(m.isEffect()) m.stop(); }
   
      public void fade_all_sounds () { 
         for(Sound m : sound_array) m.fade(); }
   
      public void fade_all_music () { 
         for(Sound m : sound_array) 
            if(!(m.isEffect())) m.fade(); }
   
      public void fade_all_effects () { 
         for(Sound m : sound_array) 
            if(m.isEffect()) m.fade(); }
				
				
		
		public static Sound sans;
      public static Sound clickSound;
      private static int master_vol;
      private static int effects_vol;
      private static int music_vol;
      private static ArrayList<Sound> sound_array;
   
      private static int w;
      private static int h;
      private static int x;
      private static int y;
		
		private JFrame mainframe;
		private JPanel loading;
		private JPanel mainmenu;
		 
   }
	
	
