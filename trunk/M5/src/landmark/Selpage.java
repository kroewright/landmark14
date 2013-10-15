package landmark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 * 
 * @author Landmark - Team 14
 *
 */
@SuppressWarnings("serial")
public class Selpage extends JPanel {
	//Setting variable names for entire file
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	
	private int difficulty;

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

	private JButton startButton;
	private int playerCount;

	/**
	 * Create the application.
	 */
	public Selpage() {
		panel = new JPanel();
		panel.setBackground(new Color(255, 204, 0)); //sets background
		panel.setBorder(new EmptyBorder(5, 5, 5, 5)); //sets border
		panel.setLayout(new BorderLayout(0, 0)); //sets layout


		//Creates start button to get to the main game page
		startButton = new JButton("START");
		startButton.setBounds(300,400,200,50);
		panel.add(startButton);
	}

	public void setSelpage(int numOfPlayers){
		BufferedImage myPicture = null;
		//Try-catch for image for selection screen
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("Start_Page.jpg");
			myPicture = ImageIO.read(input);
		} catch (IOException e) {
			System.out.println("Picture not found");
		}
		panel.setLayout(null);

		//Can't play if there are more than 4 players
		// if (numOfPlayers > 4)
		// return null;

		playerCount = 0;

		/**
		 * If 0<x<=4 players have been selected,
		 * create JLabel for player input textbox
		 */
		if(numOfPlayers > 0) {
			JLabel nameLabel = new JLabel("Name:");
			nameLabel.setBounds(188, 136, 86, 20);
			panel.add(nameLabel);

			//Sets bounds for the textfield
			txtPlayer1 = new JTextField();
			txtPlayer1.setBounds(183, 152, 105, 20);  
			panel.add(txtPlayer1);
			txtPlayer1.setColumns(100);

			//First dropdown menu containing race	
			raceBox1 = new JComboBox();
			raceBox1.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
			raceBox1.setToolTipText("");
			raceBox1.setBounds(183, 237, 105, 20);
			panel.add(raceBox1);

			//Second dropdown menu containing player color
			colorBox1 = new JComboBox();
			colorBox1.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
			colorBox1.setBounds(183, 183, 105, 20);
			panel.add(colorBox1);
			playerCount += 1;
		}
		/**
		 * If 0<x<=4 players have been selected,
		 * create JLabel for player input textbox
		 */
		if(numOfPlayers > 1) {
			JLabel nameLabel = new JLabel("Name:");
			nameLabel.setBounds(307, 136, 86, 20);
			panel.add(nameLabel);

			//Sets bounds for the textfield
			txtPlayer2 = new JTextField();
			txtPlayer2.setBounds(302, 152, 105, 20);
			panel.add(txtPlayer2);
			txtPlayer2.setColumns(10);

			//First dropdown menu containing race	
			colorBox2 = new JComboBox();
			colorBox2.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"})); 
			colorBox2.setBounds(302, 185, 105, 20);
			panel.add(colorBox2);

			//Second dropdown menu containing race		
			raceBox2 = new JComboBox();
			raceBox2.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
			raceBox2.setToolTipText("");
			raceBox2.setBounds(302, 237, 105, 20);  
			panel.add(raceBox2);
			playerCount += 1;
		}

		/**
		 * If 0<x<=4 players have been selected,
		 * create JLabel for player input textbox
		 */
		if(numOfPlayers > 2) {
			JLabel nameLabel = new JLabel("Name:");
			nameLabel.setBounds(422, 136, 86, 20);
			panel.add(nameLabel);	

			//Sets bounds for the textfield	
			txtPlayer3 = new JTextField();
			txtPlayer3.setBounds(417, 152, 105, 20);
			panel.add(txtPlayer3);
			txtPlayer3.setColumns(10);

			//First dropdown menu containing race	
			colorBox3 = new JComboBox();
			colorBox3.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
			colorBox3.setBounds(417, 185, 105, 20);
			panel.add(colorBox3);

			//Second dropdown menu containing race		
			raceBox3 = new JComboBox();
			raceBox3.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
			raceBox3.setToolTipText("");
			raceBox3.setBounds(417, 237, 105, 20);
			panel.add(raceBox3);
			playerCount += 1;
		}

		/**
		 * If 0<x<=4 players have been selected,
		 * create JLabel for player input textbox
		 */
		if(numOfPlayers > 3) {
			JLabel nameLabel = new JLabel("Name:");
			nameLabel.setBounds(532, 136, 86, 20);
			panel.add(nameLabel);

			//Sets bounds for the textfield	
			txtPlayer4 = new JTextField();
			txtPlayer4.setBounds(527, 152, 105, 20);
			panel.add(txtPlayer4);
			txtPlayer4.setColumns(10);

			//First dropdown menu containing race		
			colorBox4 = new JComboBox();
			colorBox4.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
			colorBox4.setBounds(527, 185, 105, 20);
			panel.add(colorBox4);

			//Second dropdown menu containing race		
			raceBox4 = new JComboBox();
			raceBox4.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
			raceBox4.setToolTipText("");
			raceBox4.setBounds(527, 237, 105, 20);
			panel.add(raceBox4);
			playerCount += 1;
		}

		//JLabel for picture, creates bounds
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(0, 0, 792, 576);
		panel.add(picLabel);
		// return panel;
	}	

	public void addStartButtonActionListener(ActionListener listener) {
		startButton.addActionListener(listener);//{
	}

	//	 startButton.addActionListener(new ActionListener(){
	//		 public void actionPerformed(ActionEvent e){
	public void assign() {
		if(!txtPlayer1.getText().isEmpty() && playerCount == 1) {
			player1 = new Player(txtPlayer1.getText(), colorBox1.getSelectedIndex(), difficulty,
					raceBox1.getSelectedIndex());
		}
		else if(!txtPlayer1.getText().isEmpty() && !txtPlayer2.getText().isEmpty() && playerCount == 2) {
			player1 = new Player(txtPlayer1.getText(), colorBox1.getSelectedIndex(), difficulty,
					raceBox1.getSelectedIndex());

			player2 = new Player(txtPlayer2.getText(), colorBox2.getSelectedIndex(), difficulty,
					raceBox2.getSelectedIndex());
		}
		else if(!txtPlayer1.getText().isEmpty() && !txtPlayer2.getText().isEmpty()
				&& !txtPlayer3.getText().isEmpty() && playerCount == 3) {
			player1 = new Player(txtPlayer1.getText(), colorBox1.getSelectedIndex(), difficulty,
					raceBox1.getSelectedIndex());

			player2 = new Player(txtPlayer2.getText(), colorBox2.getSelectedIndex(), difficulty,
					raceBox2.getSelectedIndex());

			player3 = new Player(txtPlayer3.getText(), colorBox3.getSelectedIndex(), difficulty,
					raceBox3.getSelectedIndex());
		}
		else if(!txtPlayer1.getText().isEmpty() && !txtPlayer2.getText().isEmpty()
				&& !txtPlayer3.getText().isEmpty() && !txtPlayer4.getText().isEmpty() && playerCount == 4) {
			player1 = new Player(txtPlayer1.getText(), colorBox1.getSelectedIndex(), difficulty,
					raceBox1.getSelectedIndex());

			player2 = new Player(txtPlayer2.getText(), colorBox2.getSelectedIndex(), difficulty,
					raceBox2.getSelectedIndex());

			player3 = new Player(txtPlayer3.getText(), colorBox3.getSelectedIndex(), difficulty,
					raceBox3.getSelectedIndex());

			player4 = new Player(txtPlayer4.getText(), colorBox4.getSelectedIndex(), difficulty,
					raceBox4.getSelectedIndex());
		}
		//If there is no player 1, it will not continue
		if(player1.getName() != null) {
			panel.setVisible(false);
		}
	}

	public JComponent getMainComponent() {
		return panel;
	}
	
	public void setDifficulty(int level) {
		difficulty = level;
	}

	public Player[] getPlayers() {
		Player[] players = new Player[1];
		if(playerCount == 1) {
			players[0] = player1;
		}
		else if(playerCount ==2) {
			players = new Player[2];
			players[0] = player1;
			players[1] = player2;
		}
		else if(playerCount ==3) {
			players = new Player[3];
			players[0] = player1;
			players[1] = player2;
			players[2] = player3;
		}
		else if(playerCount == 4) {
			players = new Player[4];
			players[0] = player1;
			players[1] = player2;
			players[2] = player3;
			players[3] = player4;
		}
		return players;
	}
}
