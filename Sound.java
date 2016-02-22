   import java.io.File; 
   import java.io.IOException; 
   import java.net.MalformedURLException; 
   import javax.sound.sampled.AudioInputStream; 
   import javax.sound.sampled.AudioSystem; 
   import javax.sound.sampled.Clip;
   import javax.sound.sampled.LineUnavailableException; 
   import javax.sound.sampled.UnsupportedAudioFileException;
   import javax.sound.sampled.FloatControl;
	
   public class Sound { private Clip clip;
   
      private boolean sound_effect;
      private double volume;
   
      public Sound(String fileName, boolean se) {
      
         sound_effect = se;
         volume = 0;
      
         try { File file = new File(fileName);
         
            if (file.exists()) { AudioInputStream sound = AudioSystem.getAudioInputStream(file); 
               clip = AudioSystem.getClip(); 
               clip.open(sound);
            } 
            
            else { 
               throw new RuntimeException("Sound: file not found: " + fileName); } } 
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
         setVolume(0);
         clip.start(); 
      } 
   	
      public void loop() { 
         setVolume(0);
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
      
         while(volume > -50) {
			
            setVolume(volume--);
				
            try {
               Thread.sleep(40);
            } 
               catch(InterruptedException ex) {
                  Thread.currentThread().interrupt();
               }
         }
         stop();
      }
   	
      public boolean isEffect() {
         return sound_effect;
      }
   	
   }
