   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import javax.swing.GroupLayout;

   public class LoadingPanel extends JPanel implements Constants{
      public LoadingPanel() { 
         JLabel loadingTitle = new JLabel();
      		
         setSize(800,600);
         loadingTitle.setText("Loading...");
         loadingTitle.setBackground(new Color(153, 51, 255));
         loadingTitle.setHorizontalAlignment(SwingConstants.CENTER);
         loadingTitle.setFont(new Font("Segoe Print", Font.BOLD, 48));
         loadingTitle.setForeground(Color.black);
         add(loadingTitle);
         loadingTitle.setBounds(-115, -10, 1095, 515);				
      }
   }