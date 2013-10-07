package landmark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Selpage extends JPanel {
		
		private String p1Name;
		private String p2Name;
		private String p3Name;
		private String p4Name;
		
		private int p1Color;
		private int p2Color;
		private int p3Color;
		private int p4Color;
		
		private int p1Diff;
		private int p2Diff;
		private int p3Diff;
		private int p4Diff;
	
	
        private JPanel panel;
        private JTextField txtPlayer1;
        private JTextField txtPlayer2;
        private JTextField txtPlayer3;
        private JTextField txtPlayer4;
        
        private JComboBox colorBox1;
        private JComboBox colorBox2;
        private JComboBox colorBox3;
        private JComboBox colorBox4;
        
        private JComboBox raceBox1;
        private JComboBox raceBox2;
        private JComboBox raceBox3;
        private JComboBox raceBox4;
        
        private int playerCount;
        
        
        public JPanel generate(int numOfPlayers){
        	// JPanel panel = new JPanel();


    		 BufferedImage myPicture = null;
    		 try {
    			 ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    			 InputStream input = classLoader.getResourceAsStream("Start_Page.jpg");
    			 myPicture = ImageIO.read(input);
    		 } catch (IOException e) {
    			 // TODO Auto-generated catch block
    			 System.out.println("Picture not found");
    		 }
    		 panel.setLayout(null);
    		 //frame.getContentPane().add(panel, BorderLayout.CENTER);

    		 if (numOfPlayers > 4)
    			 return null;
    		 
    		 playerCount = 0;

    		 if(numOfPlayers > 0) {
    			 JLabel nameLabel = new JLabel("Name:");
    			 nameLabel.setBounds(188, 136, 86, 20);
    			 panel.add(nameLabel);

    			 
    			 txtPlayer1 = new JTextField();
    			 txtPlayer1.setBounds(183, 152, 105, 20);  
    			 panel.add(txtPlayer1);
    			 txtPlayer1.setColumns(100);
    			 

    			 raceBox1 = new JComboBox();
    			 raceBox1.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
    			 raceBox1.setToolTipText("");
    			 raceBox1.setBounds(183, 237, 105, 20);
    			 panel.add(raceBox1);

    			 colorBox1 = new JComboBox();
    			 colorBox1.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
    			 colorBox1.setBounds(183, 183, 105, 20);
    			 panel.add(colorBox1);
    			 playerCount += 1;
    		 }

    		 if(numOfPlayers > 1) {
    			 JLabel nameLabel = new JLabel("Name:");
    			 nameLabel.setBounds(307, 136, 86, 20);
    			 panel.add(nameLabel);

    			 txtPlayer2 = new JTextField();
    			 txtPlayer2.setBounds(302, 152, 105, 20);
    			 panel.add(txtPlayer2);
    			 txtPlayer2.setColumns(10);

    			 colorBox2 = new JComboBox();
    			 colorBox2.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"})); 
    			 colorBox2.setBounds(302, 185, 105, 20);
    			 panel.add(colorBox2);

    			 raceBox2 = new JComboBox();
    			 raceBox2.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
    			 raceBox2.setToolTipText("");
    			 raceBox2.setBounds(302, 237, 105, 20);  
    			 panel.add(raceBox2);
    			 playerCount += 1;
    		 }

    		 if(numOfPlayers > 2) {
    			 JLabel nameLabel = new JLabel("Name:");
    			 nameLabel.setBounds(422, 136, 86, 20);
    			 panel.add(nameLabel);	

    			 txtPlayer3 = new JTextField();
    			 txtPlayer3.setBounds(417, 152, 105, 20);
    			 panel.add(txtPlayer3);
    			 txtPlayer3.setColumns(10);

    			 colorBox3 = new JComboBox();
    			 colorBox3.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
    			 colorBox3.setBounds(417, 185, 105, 20);
    			 panel.add(colorBox3);

    			 raceBox3 = new JComboBox();
    			 raceBox3.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
    			 raceBox3.setToolTipText("");
    			 raceBox3.setBounds(417, 237, 105, 20);
    			 panel.add(raceBox3);
    			 playerCount += 1;
    		 }

    		 if(numOfPlayers > 3) {
    			 JLabel nameLabel = new JLabel("Name:");
    			 nameLabel.setBounds(532, 136, 86, 20);
    			 panel.add(nameLabel);

    			 txtPlayer4 = new JTextField();
    			 txtPlayer4.setBounds(527, 152, 105, 20);
    			 panel.add(txtPlayer4);
    			 txtPlayer4.setColumns(10);

    			 colorBox4 = new JComboBox();
    			 colorBox4.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
    			 colorBox4.setBounds(527, 185, 105, 20);
    			 panel.add(colorBox4);

    			 raceBox4 = new JComboBox();
    			 raceBox4.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
    			 raceBox4.setToolTipText("");
    			 raceBox4.setBounds(527, 237, 105, 20);
    			 panel.add(raceBox4);
    			 playerCount += 1;
    		 }
    		 
    		 JButton startButton = new JButton("START");
    		 startButton.setBounds(300,400,200,50);
    		 panel.add(startButton);
    		 startButton.addActionListener(new ActionListener(){
    			 public void actionPerformed(ActionEvent e){
    				 if(!txtPlayer1.getText().isEmpty() && playerCount == 1) {
    					 p1Name = txtPlayer1.getText();
    					 p1Color = colorBox1.getSelectedIndex();
    					 p1Diff = raceBox1.getSelectedIndex();
    				 }
    				 else if(!txtPlayer1.getText().isEmpty() && !txtPlayer2.getText().isEmpty() && playerCount == 2) {
    					 p1Name = txtPlayer1.getText();
    					 p1Color = colorBox1.getSelectedIndex();
    					 p1Diff = raceBox1.getSelectedIndex();
    					 
    					 p2Name = txtPlayer2.getText();
    					 p2Color = colorBox2.getSelectedIndex();
    					 p2Diff = raceBox2.getSelectedIndex();
    				 }
    				 else if(!txtPlayer1.getText().isEmpty() && !txtPlayer2.getText().isEmpty()
    						 && !txtPlayer3.getText().isEmpty() && playerCount == 3) {
    					 p1Name = txtPlayer1.getText();
    					 p1Color = colorBox1.getSelectedIndex();
    					 p1Diff = raceBox1.getSelectedIndex();
    					 
    					 p2Name = txtPlayer2.getText();
    					 p2Color = colorBox2.getSelectedIndex();
    					 p2Diff = raceBox2.getSelectedIndex();
    					 
    					 p3Name = txtPlayer3.getText();
    					 p3Color = colorBox3.getSelectedIndex();
    					 p3Diff = raceBox3.getSelectedIndex();
    				 }
    				 else if(!txtPlayer1.getText().isEmpty() && !txtPlayer2.getText().isEmpty()
    						 && !txtPlayer3.getText().isEmpty() && !txtPlayer4.getText().isEmpty() && playerCount == 4) {
    					 p1Name = txtPlayer1.getText();
    					 p1Color = colorBox1.getSelectedIndex();
    					 p1Diff = raceBox1.getSelectedIndex();
    					 
    					 p2Name = txtPlayer2.getText();
    					 p2Color = colorBox2.getSelectedIndex();
    					 p2Diff = raceBox2.getSelectedIndex();
    					 
    					 p3Name = txtPlayer3.getText();
    					 p3Color = colorBox3.getSelectedIndex();
    					 p3Diff = raceBox3.getSelectedIndex();
    					 
    					 p4Name = txtPlayer4.getText();
    					 p4Color = colorBox4.getSelectedIndex();
    					 p4Diff = raceBox4.getSelectedIndex();
    				 }
    				 
    				 if(p1Name != null) {
    					 panel.setVisible(false);
    				 }
    			 }
    		 });
    		 
    		 
    		 JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    		 picLabel.setBounds(0, 0, 792, 576);
    		 panel.add(picLabel);
    		 return panel;
    	 }
        
        /**
         * Create the application.
         */
        
        public Selpage() {
        	panel = new JPanel();
               // initialize();
        }
}

