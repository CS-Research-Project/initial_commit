   import java.io.File; 
   import java.io.IOException; 
   import java.net.MalformedURLException; 
   import javax.sound.sampled.AudioInputStream; 
   import javax.sound.sampled.AudioSystem; 
   import javax.sound.sampled.Clip;
   import javax.sound.sampled.LineUnavailableException; 
   import javax.sound.sampled.UnsupportedAudioFileException;
   import javax.sound.sampled.FloatControl;
	
   public class Sound { 
	
		private Clip clip;
   
      private boolean sound_effect;
      private double volume;
		private String name;
   
      public Sound(String n, String filePath, boolean se) {
      
         sound_effect = se;
         volume = 3;
			name = n;
      
         try { File file = new File(filePath);
         
            if (file.exists()) { AudioInputStream sound = AudioSystem.getAudioInputStream(file); 
               clip = AudioSystem.getClip(); 
               clip.open(sound);
            } 
            
            else { 
               throw new RuntimeException("Sound: file not found: " + filePath); } } 
            catch (MalformedURLException e) { e.printStackTrace(); 
               throw new RuntimeException("Sound: Malformed URL: " + e); } 
            catch (UnsupportedAudioFileException e) { e.printStackTrace(); 
               throw new RuntimeException("Sound: Unsupported Audio File: " + e); } 
            catch (IOException e) { e.printStackTrace(); 
               throw new RuntimeException("Sound: Input/Output Error: " + e); } 
            catch (LineUnavailableException e) { e.printStackTrace(); 
               throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
            	
            }
      } 
   	
      public void play() { 
         clip.setFramePosition(0);
         clip.start(); 
      } 
   	
      public void loop() {
         clip.loop(Clip.LOOP_CONTINUOUSLY);
      } 
   	
      public void stop() {
         clip.stop(); 
      }
   	
      public void setVolume(double vol) {
      
         float vol_f = (float) vol;
      
         FloatControl gainControl = 
            (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
         gainControl.setValue(vol_f);
      }
   	
      public void fade () {
		
		double vol_save = volume;
      
         while(volume > -50) {
			
            setVolume(volume--);
				
            try {
               Thread.sleep(40);
            } 
               catch(InterruptedException ex) {
                  //Thread.currentThread().interrupt();
               }
         }
         stop();
			volume = vol_save;
			setVolume(volume);
      }
   	
      public boolean isEffect() {
         return sound_effect;
      }
		
		public String getName() {
			return name;
		}
  		public String toString () {
			return name;
		} 	
		
   }
