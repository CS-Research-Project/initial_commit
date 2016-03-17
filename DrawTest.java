   import java.awt.*;
   import javax.swing.JFrame;


   public class DrawTest extends JFrame implements Constants{
   
   
   
      public DrawTest() {
      
         initUI();
         setVisible(true);
         setExtendedState(JFrame.MAXIMIZED_BOTH); 		
      
         
      }
   
      private void initUI() {
      
         add(new Board());
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         setPreferredSize(new Dimension(screenSize)); 
         pack();
         setTitle("2D TEST");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
      }
   
      public static void main(String[] args) {
         DrawTest ex = new  DrawTest();
         ex.setVisible(true);
      
      }
   }