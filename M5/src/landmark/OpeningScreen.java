package landmark;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class OpeningScreen extends JFrame {
	private int isStandard = 0; // 1 = standard map and 2 = random map
	
	private int difficulty = 0; // 1 = normal 2 = advanced and 3 = tournament

	static int numOfPlayers = 0;
	private JPanel contentPane;
	private JPanel contentPane2;   
	private JPanel panel;
	private JTextField txtPlayer;
	private JTextField txtEnterYourName;
	private JTextField txtEnterName;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	 public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
			 public void run() {
				 try {
					 OpeningScreen frame = new OpeningScreen();
					 frame.setVisible(true);
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
		 });
	 }



	 /**
	  * Create the frame.
	  */

	 public OpeningScreen() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setBounds(100, 100, 953, 617);
		 contentPane = new JPanel();
		 contentPane.setBackground(new Color(255, 204, 0));
		 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 contentPane.setLayout(new BorderLayout(0, 0));
		 setContentPane(contentPane);



		 JPanel center = new JPanel();
		 contentPane.add(center, BorderLayout.CENTER);
		 BufferedImage myPicture = null;
		 try {
			 ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			 InputStream input = classLoader.getResourceAsStream("Openingpage.jpg");
			 myPicture = ImageIO.read(input);
		 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 System.out.println("Picture not found");
		 }
		 center.setLayout(null);

		 JButton btn2 = new JButton("1");
		 btn2.setBackground(new Color(204, 255, 204));
		 btn2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg2) {
				 numOfPlayers = 1;                               
			 }
		 });
		 btn2.setBounds(301, 371, 46, 23);
		 center.add(btn2);

		 JButton btn3 = new JButton("2");
		 btn3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg3) {
				 numOfPlayers = 2;
			 }
		 });
		 btn3.setBounds(387, 371, 46, 23);
		 center.add(btn3);

		 JButton btn1 = new JButton("3");
		 btn1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg1) {
				 numOfPlayers = 3;
			 }
		 });
		 btn1.setBounds(478, 371, 46, 23);
		 center.add(btn1);

		 JButton btn4 = new JButton("4");
		 btn4.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg4) {
				 numOfPlayers = 4;
			 }
		 });
		 btn4.setBounds(568, 371, 46, 23);
		 center.add(btn4);
		 JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		 picLabel.setBounds(27, 5, 869, 518);
		 center.add(picLabel);


		 JPanel south = new JPanel();
		 south.setBackground(new Color(255, 204, 0));
		 contentPane.add(south, BorderLayout.SOUTH);
		 south.setLayout(new GridLayout(0, 8, 0, 0));

		 JLabel lblNewLabel = new JLabel("Map Type:");
		 lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		 lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		 south.add(lblNewLabel);

		 
		 JRadioButton rdbtnNewRadioButton = new JRadioButton("Standard");
		 rdbtnNewRadioButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		isStandard = 1;
		 	}
		 });
         rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
         
         JRadioButton rdbtnRandom = new JRadioButton("Random");
         rdbtnRandom.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		isStandard = 2;
         	}
         });
         rdbtnRandom.setHorizontalAlignment(SwingConstants.LEFT);
         
         ButtonGroup bg1 = new ButtonGroup( );
         bg1.add(rdbtnNewRadioButton);
         bg1.add(rdbtnRandom);
         
         south.add(rdbtnNewRadioButton);
         south.add(rdbtnRandom);

		 JLabel lblDifficulty = new JLabel("Difficulty:");
		 lblDifficulty.setFont(new Font("Garuda", Font.BOLD, 17));
		 lblDifficulty.setHorizontalAlignment(SwingConstants.RIGHT);
		 south.add(lblDifficulty);

		 JRadioButton rdbtnBeginner = new JRadioButton("Beginner");
		 rdbtnBeginner.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		difficulty = 1; 
		 	}
		 });
		 
		 rdbtnBeginner.setHorizontalAlignment(SwingConstants.LEFT);
		 rdbtnBeginner.setBackground(new Color(255, 204, 0));

		 JRadioButton rdbtnAdvanced = new JRadioButton("Advanced");
		 rdbtnAdvanced.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		difficulty = 2;
		 	}
		 });
		 
		 rdbtnAdvanced.setHorizontalAlignment(SwingConstants.LEFT);
		 rdbtnAdvanced.setBackground(new Color(255, 204, 0));

		 JRadioButton rdbtnTournament = new JRadioButton("Tournament");
		 rdbtnTournament.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		difficulty = 3;
		 	}
		 });
		 
		 rdbtnTournament.setHorizontalAlignment(SwingConstants.LEFT);
		 rdbtnTournament.setBackground(new Color(255, 204, 0));

		 ButtonGroup bg2 = new ButtonGroup( );
		 bg2.add(rdbtnBeginner);
		 bg2.add(rdbtnAdvanced);
		 bg2.add(rdbtnTournament);

		 south.add(rdbtnBeginner);
		 south.add(rdbtnAdvanced);
		 south.add(rdbtnTournament);

		 JButton btnStart = new JButton("NEXT");
		 btnStart.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if(numOfPlayers != 0 && isStandard != 0 && difficulty != 0){
					 contentPane.setVisible(false);
					 
					 
					 contentPane2 = new JPanel();
					 contentPane2.setBackground(new Color(255, 204, 0));
					 contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
					 contentPane2.setLayout(new BorderLayout(0, 0));
					 setContentPane(contentPane2);
					 
					 Selpage selectionPage = new Selpage();
					 contentPane2.add(selectionPage.generate(numOfPlayers));
				
				 }

			 }
		 });
		 south.add(btnStart);

	 }
}


