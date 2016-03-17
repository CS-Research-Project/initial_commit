   import java.awt.*;
   import java.awt.event.*;
   import java.beans.*;
   import javax.swing.*;
   import javax.swing.event.*;

   public class OptionsMenu extends JPanel implements ActionListener, Constants{
      public OptionsMenu() {
         initComponents();
      }
   
      public void actionPerformed(ActionEvent e) {
      
         if(e.getSource() == masterTest) {
            Serendipity.stop_all_sounds();
         }
      	
         if(e.getSource() == effectsTest) {
            Serendipity.stop_all_sounds();
            Serendipity.getRandomEffect().play();
         }
      	
         if(e.getSource() == musicTest) {
            Serendipity.stop_all_sounds();
            Serendipity.getRandomMusic().play();
         }
      	
         if(e.getSource() == backButton) {
            Serendipity.getSound("clickSound").play();
            Serendipity.switchPanels(MENU_KEY);
         
         }
      
      }  
   
      private void initComponents() {
      
         title = new JLabel();
         masterLabel = new JLabel();
         effectsLabel = new JLabel();
         musicLabel = new JLabel();
         background = new JLabel();
         masterSlider = new JSlider();
         effectsSlider = new JSlider();
         musicSlider = new JSlider();
         masterTest = new JButton();
         effectsTest = new JButton();
         musicTest = new JButton();
         backButton = new JButton();
      	
         helpSlider = new JSlider();
      	
         {
            {
               setLayout(null);
            	
            	
            	//---- masterLabel ----
               masterLabel.setText("Master");
               masterLabel.setForeground(Color.red);
               masterLabel.setFont(new Font("Trajan Pro", Font.PLAIN, 24));
               masterLabel.setBounds(70, 240, 100, 100);
               add(masterLabel);
            	 
            	  //---- effectsLabel ----
               effectsLabel.setText("Effects");
               effectsLabel.setForeground(Color.red);
               effectsLabel.setFont(new Font("Trajan Pro", Font.PLAIN, 24));
               effectsLabel.setBounds(70, 310, 100, 100);
               add(effectsLabel);
            	 
            	  //---- musicLabel ----
               musicLabel.setText("Music");
               musicLabel.setForeground(Color.red);
               musicLabel.setFont(new Font("Trajan Pro", Font.PLAIN, 24));
               musicLabel.setBounds(70, 380, 100, 100);
               add(musicLabel);
            	
            	 //---- helpSlider ----
               helpSlider.setBounds(0, 0, 0, 0);
               helpSlider.setOpaque(false);
               add(helpSlider);
            	
            	
            
                //---- effectsSlider ----
               effectsSlider.addChangeListener(
                     new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                           JSlider source = (JSlider) e.getSource();
									Serendipity.change_effects(6/(effectsSlider.getValue()+1));
                        
                        }
                     });
               effectsSlider.setBounds(175, 350, 390, effectsSlider.getPreferredSize().height+30);
               effectsSlider.setMajorTickSpacing(100);
               effectsSlider.setMinorTickSpacing(10);
               effectsSlider.setPaintTicks(true);
               effectsSlider.setPaintLabels(true);
               effectsSlider.setOpaque(false);
               add(effectsSlider);
            
               
            
                //---- musicSlider ----
               musicSlider.addChangeListener(
                     new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                           JSlider source = (JSlider) e.getSource();
									Serendipity.change_music(6*((effectsSlider.getValue()+1)/100));
                        
                        }
                     });
               musicSlider.setBounds(175, 420, 390, effectsSlider.getPreferredSize().height);
               musicSlider.setMajorTickSpacing(100);
               musicSlider.setMinorTickSpacing(10);
               musicSlider.setPaintTicks(true);
               musicSlider.setPaintLabels(true);
               musicSlider.setOpaque(false);
               add(musicSlider);
					
					 //---- masterSlider ----
               masterSlider.addChangeListener(
                     new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
								effectsSlider.setMajorTickSpacing(effectsSlider.getValue());
               			effectsSlider.setMinorTickSpacing(effectsSlider.getValue()/10);
								musicSlider.setMajorTickSpacing(effectsSlider.getValue());
               			musicSlider.setMinorTickSpacing(effectsSlider.getValue()/10);
                        }
                     });
               masterSlider.setBounds(175, 280, 390, effectsSlider.getPreferredSize().height);
               masterSlider.setMajorTickSpacing(100);
               masterSlider.setMinorTickSpacing(10);
               masterSlider.setPaintTicks(true);
               masterSlider.setPaintLabels(true);
               masterSlider.setOpaque(false);
               add(masterSlider);
            	
            	 //---- title ----
               title.setIcon(new ImageIcon(PICTURES_PATH+"options_title_fixed_trans.png"));
               add(title);
               title.setBounds(0, -130, 1095, 515);
            	
            
                //---- effectsTest ----
               effectsTest.setText("Test Effects Volume");
               effectsTest.addActionListener(this);
               add(effectsTest);
               effectsTest.setBounds(new Rectangle(new Point(605, 345), effectsTest.getPreferredSize()));
            
                //---- musicTest ----
               musicTest.setText("Test Music Volume");
               musicTest.addActionListener(this);
               add(musicTest);
               musicTest.setBounds(new Rectangle(new Point(605, 415), effectsTest.getPreferredSize()));
            	
            	 //---- masterTest ----
               masterTest.setText("Stop All Sounds");
               masterTest.addActionListener(this);
               masterTest.setBackground(Color.white);
					masterTest.setBorder(BorderFactory.createLineBorder(Color.red, 3));
               add(masterTest);
               masterTest.setBounds(new Rectangle(new Point(605, 275), effectsTest.getPreferredSize()));
            	
            	 //---- backButton ----
               backButton.setText("Main Menu");
               backButton.setBackground(Color.lightGray);
               backButton.setFont(new Font("Trajan Pro", Font.PLAIN, 28));
               backButton.addActionListener(this);
               add(backButton);
               backButton.setBounds(285, 475, 225, 75);
            	
            	//---- background ----
               background.setIcon(new ImageIcon(PICTURES_PATH+"samplebackground.png"));
               background.setBounds(0, 0, 800, background.getPreferredSize().height);
               add(background);
            	
            	
            }
         }
      }
   
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Charles Houghton
      private JPanel panel3;
      private JPanel panel1;
      private JSlider masterSlider;
      private JSlider effectsSlider;
      private JLabel title;
      private JSlider musicSlider;
      private JButton masterTest;
      private JButton effectsTest;
      private JButton musicTest;
      private JButton backButton;
      private JLabel masterLabel;
      private JLabel effectsLabel;
      private JLabel musicLabel;
      private JLabel background;
      private JSlider helpSlider;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
   }
