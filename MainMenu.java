   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import javax.swing.GroupLayout;
   import java.io.File;
   import java.util.ArrayList;

   public class MainMenu extends JPanel implements ActionListener, Constants {
      public MainMenu() {
     
         initComponents();
      
         setVisible(true);
      
         Serendipity.sans.loop();
      
      }
   
       
      public void actionPerformed(ActionEvent e) {
      
         Serendipity.clickSound.play();
      
         if(e.getSource() == playButton) {
					
				Serendipity.fade_all_music();
				
				Serendipity.switchPanels(LOADING_KEY);
         
         }
         if(e.getSource() == optionsButton);
         if(e.getSource() == exitButton) System.exit(0);
      
      }  
   
   
   
      private void initComponents() {
      // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
      // Generated using JFormDesigner Evaluation license - Charles Houghton
         playButton = new JButton();
         optionsButton = new JButton();
         exitButton = new JButton();
         title = new JLabel();
         background = new JLabel();
      
      
      //======== this ========
         Container contentPane = getContentPane();
         contentPane.setLayout(null);
      
      //---- playButton ----
         playButton.setText("Play");
         playButton.setIcon(null);
         playButton.setBackground(Color.lightGray);
         playButton.setFont(new Font("Trajan Pro", Font.PLAIN, 28));
         playButton.addActionListener(this);
         contentPane.add(playButton);
         playButton.setBounds(40, 455, 225, 75);
      
      //---- optionsButton ----
         optionsButton.setText("Options");
         optionsButton.setBackground(Color.lightGray);
         optionsButton.setFont(new Font("Trajan Pro", Font.PLAIN, 28));
         optionsButton.addActionListener(this);
         contentPane.add(optionsButton);
         optionsButton.setBounds(285, 455, 225, 75);
      
      //---- exitButton ----
         exitButton.setText("Exit Game");
         exitButton.setBackground(Color.lightGray);
         exitButton.setFont(new Font("Trajan Pro", Font.PLAIN, 28));
         exitButton.addActionListener(this);
         contentPane.add(exitButton);
         exitButton.setBounds(530, 455, 225, 75);
      
      //---- title ----
      //title.setText("SERENDIPITY");
      //title.setBackground(new Color(153, 51, 255));
      //title.setHorizontalAlignment(SwingConstants.CENTER);
      //title.setFont(new Font("Segoe Print", Font.BOLD, 48));
      //title.setForeground(Color.red);
         title.setIcon(new ImageIcon(PICTURES_PATH+"title_trans.png"));
         contentPane.add(title);
         title.setBounds(-115, -10, 1095, 515);
      
      //---- background ----
      //background.setText("SERENDIPITY");
      //background.setFont(new Font("Sitka Text", Font.PLAIN, 12));
         background.setIcon(new ImageIcon(PICTURES_PATH+"samplebackground.png"));
         contentPane.add(background);
         background.setBounds(0, 0, 800, background.getPreferredSize().height);
      
         { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
               Rectangle bounds = contentPane.getComponent(i).getBounds();
               preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
               preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
         }
         pack();
      
      // JFormDesigner - End of component initialization  //GEN-END:initComponents
      }
   
   // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
   // Generated using JFormDesigner Evaluation license - Charles Houghton
      private JButton playButton;
      private JButton optionsButton;
      private JButton exitButton;
      private JLabel title;
      private JLabel background;
   //private Clip clip;
      
   // JFormDesigner - End of variables declaration  //GEN-END:variables
   }
