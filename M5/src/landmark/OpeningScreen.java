package landmark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

/**
 * 
 * @author Landmark - Team 14
 *
 */
@SuppressWarnings("serial")
public class OpeningScreen extends JPanel{ // JFrame {

	private int isStandard = 0; // 1 = standard map and 2 = random map
	private int difficulty = 0; // 1 = beginner 2 = standard and 3 = tournament
	private int numOfPlayers = 0;
	private JPanel contentPane;
	private JButton btnNext;   
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;

	/**
	 * Create the panel.
	 */
	public OpeningScreen() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(207,181,59));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		/*
		 * Reads file containing picture for opening
		 * and uses try catch to make sure the file 
		 * is really there.
		 */
		JPanel center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		BufferedImage myPicture = null;
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("Openingpage.jpg");
			myPicture = ImageIO.read(input);
		} catch (IOException e) {
			System.out.println("Picture not found");
		}
		center.setLayout(null);

		/*
		 * Action listener for button number 1.
		 * Sets button location.
		 */
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg2) {
				switch (numOfPlayers){
					case 2:
						btn2.setBackground(null);
						break;
					case 3:
						btn3.setBackground(null);
						break;
					case 4:
						btn4.setBackground(null);
						break;	
				}
				numOfPlayers = 1;
				btn1.setBackground(new Color(207,181,59));
			}
		});
		btn1.setBounds(574, 420, 46, 64);
		center.add(btn1);

		/*
		 * Action listener for button number 2.
		 * Sets button location.
		 */
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg3) {
				switch (numOfPlayers){
					case 1:
						btn1.setBackground(null);
						break;
					case 3:
						btn3.setBackground(null);
						break;
					case 4:
						btn4.setBackground(null);
						break;	
				}
				numOfPlayers = 2;
				btn2.setBackground(new Color(207,181,59));
			}
		});
		btn2.setBounds(660, 420, 46, 64);
		center.add(btn2);

		/*
		 * Action listener for button number 3.
		 * Sets button location.
		 */
		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				switch (numOfPlayers){
					case 1:
						btn1.setBackground(null);
						break;
					case 2:
						btn2.setBackground(null);
						break;
					case 4:
						btn4.setBackground(null);
						break;	
				}
				numOfPlayers = 3;
				btn3.setBackground(new Color(207,181,59));
			}
		});
		btn3.setBounds(751, 420, 46, 64);
		center.add(btn3);

		/*
		 * Action listener for button number 4.
		 * Sets button location.
		 */
		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg4) {
				switch (numOfPlayers){
					case 1:
						btn1.setBackground(null);
						break;
					case 2:
						btn2.setBackground(null);
						break;
					case 3:
						btn3.setBackground(null);
						break;	
				}
				numOfPlayers = 4;
				btn4.setBackground(new Color(207,181,59));
			}
		});
		btn4.setBounds(841, 420, 46, 65);
		center.add(btn4);

		/**
		 * JLabel for picture.
		 * Sets the bounds before adding the label.
		 */
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(300, 60, 869, 518);
		center.add(picLabel);

		/**
		 * Set the background color for the lower part of the
		 * opening screen. 
		 */
		JPanel south = new JPanel();
		south.setBackground(new Color(207,181,59));
		contentPane.add(south, BorderLayout.SOUTH);
		south.setLayout(new GridLayout(0, 8, 0, 0));

		/**
		 * Creates the label for Map Type.
		 */
		JLabel lblNewLabel = new JLabel("Map Type:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Garuda", Font.BOLD, 17));
		south.add(lblNewLabel);

		/**
		 * Creates first radio button for Standard map type.
		 */
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Standard");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isStandard = 1;
			}
		});
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setBackground(new Color(207,181,59));

		/**
		 * Creates second radio button for Random map type.
		 */
		JRadioButton rdbtnRandom = new JRadioButton("Random");
		rdbtnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isStandard = 2;
			}
		});
		rdbtnRandom.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnRandom.setBackground(new Color(207,181,59));

		/**
		 * Adds the buttons to the button group.
		 */
		ButtonGroup bg1 = new ButtonGroup( );
		bg1.add(rdbtnNewRadioButton);
		bg1.add(rdbtnRandom);

		/**
		 * Adds the buttons to the panel.
		 */
		south.add(rdbtnNewRadioButton);
		south.add(rdbtnRandom);

		/**
		 * Creates JLabel for Difficulty.
		 * Adds it to the panel.
		 */
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setFont(new Font("Garuda", Font.BOLD, 17));
		lblDifficulty.setHorizontalAlignment(SwingConstants.RIGHT);
		south.add(lblDifficulty);

		/**
		 * Creates new radio button for Beginner level.	
		 */
		JRadioButton rdbtnBeginner = new JRadioButton("Beginner");
		rdbtnBeginner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = 1; 
			}
		});

		/**
		 * Set background and aligns radio button.
		 */
		rdbtnBeginner.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnBeginner.setBackground(new Color(207,181,59));

		/**
		 * Creates new radio button for Advanced level.	
		 */
		JRadioButton rdbtnAdvanced = new JRadioButton("Standard");
		rdbtnAdvanced.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = 2;
			}
		});

		/**
		 * Set background and aligns radio button.
		 */
		rdbtnAdvanced.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnAdvanced.setBackground(new Color(207,181,59));

		/**
		 * Creates new radio button for Tournament level.	
		 */
		JRadioButton rdbtnTournament = new JRadioButton("Tournament");
		rdbtnTournament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = 3;
			}
		});

		/**
		 * Set background and aligns radio button.
		 */
		rdbtnTournament.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnTournament.setBackground(new Color(207,181,59));

		/**
		 * Adds the buttons to the button group.
		 */
		ButtonGroup bg2 = new ButtonGroup( );
		bg2.add(rdbtnBeginner);
		bg2.add(rdbtnAdvanced);
		bg2.add(rdbtnTournament);

		/**
		 * Adds the buttons to the panel.
		 */
		south.add(rdbtnBeginner);
		south.add(rdbtnAdvanced);
		south.add(rdbtnTournament);

		/**
		 * Creates Next button after players, map, and difficulty 
		 * have been selected.
		 */
		btnNext = new JButton("NEXT");   
		south.add(btnNext);	//Add Next button to panel	
	}

	public void addBtnNextActionListener(ActionListener listener) {
		btnNext.addActionListener(listener);
	}

	public JComponent getMainComponent() {
		return contentPane;
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}

	public int getIsStandard() {
		return isStandard;
	}

	public int getDifficulty() {
		return difficulty;
	}
}



