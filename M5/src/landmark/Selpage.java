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
import javax.swing.JOptionPane;
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
	private Player[] players;
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

	@SuppressWarnings("rawtypes")
	private JComboBox colorBox1;
	@SuppressWarnings("rawtypes")
	private JComboBox colorBox2;
	@SuppressWarnings("rawtypes")
	private JComboBox colorBox3;
	@SuppressWarnings("rawtypes")
	private JComboBox colorBox4;

	@SuppressWarnings("rawtypes")
	private JComboBox raceBox1;
	@SuppressWarnings("rawtypes")
	private JComboBox raceBox2;
	@SuppressWarnings("rawtypes")
	private JComboBox raceBox3;
	@SuppressWarnings("rawtypes")
	private JComboBox raceBox4;

	private JButton startButton;
	//private int playerCount;

	/**
	 * The Constructor creates the panel for the players selection screen .
	 */
	public Selpage() {
		panel = new JPanel();
		panel.setBackground(new Color(255, 204, 0)); //sets background
		panel.setBorder(new EmptyBorder(5, 5, 5, 5)); //sets border
		panel.setLayout(new BorderLayout(0, 0)); //sets layout


		//Creates start button to get to the main game page
		startButton = new JButton("START");
		startButton.setBounds(628,450,200,50);
		panel.add(startButton);
	}

	/**
	 * The setPage method sets the right configuration
	 * of the selection screen based on the number of players picked.
	 * 
	 * @param numOfPlayers
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
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

		//playerCount = 0;

		/**
		 * If 0<x<=4 players have been selected,
		 * create JLabel for player input textbox
		 */
		if(numOfPlayers > 0) {
			JLabel nameLabel = new JLabel("Name:");
			nameLabel.setBounds(514, 180, 86, 20);
			panel.add(nameLabel);

			//Sets bounds for the textfield
			txtPlayer1 = new JTextField();
			txtPlayer1.setBounds(514, 200, 105, 20);  
			panel.add(txtPlayer1);
			txtPlayer1.setColumns(10);

			//First dropdown menu containing race	
			raceBox1 = new JComboBox();
			raceBox1.setModel(new DefaultComboBoxModel(
					new String[] {"Business", "Scientist", "Engineer", "CS"}));
			raceBox1.setToolTipText("");
			raceBox1.setBounds(514, 280, 105, 20);
			panel.add(raceBox1);

			//Second dropdown menu containing player color
			colorBox1 = new JComboBox();
			colorBox1.setModel(new DefaultComboBoxModel(
					new String[] {"Gold", "Navy", "White", "Black"}));
			colorBox1.setBounds(514, 240, 105, 20);
			panel.add(colorBox1);
			//playerCount += 1;
		}
		/**
		 * If 0<x<=4 players have been selected,
		 * create JLabel for player input textbox
		 */
		if(numOfPlayers > 1) {
			JLabel nameLabel = new JLabel("Name:");
			nameLabel.setBounds(632, 180, 86, 20);
			panel.add(nameLabel);

			//Sets bounds for the textfield
			txtPlayer2 = new JTextField();
			txtPlayer2.setBounds(632, 200, 105, 20);
			panel.add(txtPlayer2);
			txtPlayer2.setColumns(10);

			//First dropdown menu containing race	
			colorBox2 = new JComboBox();
			colorBox2.setModel(new DefaultComboBoxModel(
					new String[] {"Gold", "Navy", "White", "Black"})); 
			colorBox2.setBounds(632, 240, 105, 20);
			panel.add(colorBox2);

			//Second dropdown menu containing race		
			raceBox2 = new JComboBox();
			raceBox2.setModel(new DefaultComboBoxModel(
					new String[] {"Business", "Scientist", "Engineer", "CS"}));
			raceBox2.setToolTipText("");
			raceBox2.setBounds(632, 280, 105, 20);  
			panel.add(raceBox2);
			//playerCount += 1;
		}

		/**
		 * If 0<x<=4 players have been selected,
		 * create JLabel for player input textbox
		 */
		if(numOfPlayers > 2) {
			JLabel nameLabel = new JLabel("Name:");
			nameLabel.setBounds(750, 180, 86, 20);
			panel.add(nameLabel);	

			//Sets bounds for the textfield	
			txtPlayer3 = new JTextField();
			txtPlayer3.setBounds(750, 200, 97, 20);
			panel.add(txtPlayer3);
			txtPlayer3.setColumns(10);

			//First dropdown menu containing race	
			colorBox3 = new JComboBox();
			colorBox3.setModel(new DefaultComboBoxModel(
					new String[] {"Gold", "Navy", "White", "Black"}));
			colorBox3.setBounds(750, 240, 97, 20);
			panel.add(colorBox3);

			//Second dropdown menu containing race		
			raceBox3 = new JComboBox();
			raceBox3.setModel(new DefaultComboBoxModel(
					new String[] {"Business", "Scientist", "Engineer", "CS"}));
			raceBox3.setToolTipText("");
			raceBox3.setBounds(750, 280, 97, 20);
			panel.add(raceBox3);
			//playerCount += 1;
		}

		/**
		 * If 0<x<=4 players have been selected,
		 * create JLabel for player input textbox
		 */
		if(numOfPlayers > 3) {
			JLabel nameLabel = new JLabel("Name:");
			nameLabel.setBounds(860, 180, 86, 20);
			panel.add(nameLabel);

			//Sets bounds for the textfield	
			txtPlayer4 = new JTextField();
			txtPlayer4.setBounds(860, 200, 97, 20);
			panel.add(txtPlayer4);
			txtPlayer4.setColumns(10);

			//First dropdown menu containing race		
			colorBox4 = new JComboBox();
			colorBox4.setModel(new DefaultComboBoxModel(
					new String[] {"Gold", "Navy", "White", "Black"}));
			colorBox4.setBounds(860, 240, 97, 20);
			panel.add(colorBox4);

			//Second dropdown menu containing race		
			raceBox4 = new JComboBox();
			raceBox4.setModel(new DefaultComboBoxModel(
					new String[] {"Business", "Scientist", "Engineer", "CS"}));
			raceBox4.setToolTipText("");
			raceBox4.setBounds(860, 280, 97, 20);
			panel.add(raceBox4);
			//playerCount += 1;
		}

		//JLabel for picture, creates bounds
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(330, 60, 792, 576);
		panel.add(picLabel);
	}	

	/**
	 * The addStartButtonActionListener method adds the action listener 
	 * for the Start button.
	 * 
	 * @param listener
	 */
	public void addStartButtonActionListener(ActionListener listener) {
		startButton.addActionListener(listener);//{
	}
	
	/**
	 * The createPlayers method configures players.
	 * 
	 * @param numOfPlayers
	 * @return Returns array of players
	 */
	public Player[] createPlayers(int numOfPlayers) {  
		players = new Player[numOfPlayers];
		int i = players.length - numOfPlayers;

		try{
			if(numOfPlayers > 0) {

				if(txtPlayer1.getText().trim().isEmpty()) {
					throw new BadNameException(i+1);
				}

				else {
					player1 = new Player(txtPlayer1.getText().trim(), colorBox1.getSelectedIndex(),
							difficulty, raceBox1.getSelectedIndex());
					players[i] = player1;
					i++;
				}
			}

			if(numOfPlayers > 1) {

				if(txtPlayer2.getText().trim().isEmpty()) {
					throw new BadNameException(i+1);
				}

				if (colorBox2.getSelectedIndex() == colorBox1.getSelectedIndex()) {
					throw new BadColorException(i+1);
				}

			/*	if (raceBox2.getSelectedIndex() == raceBox1.getSelectedIndex()) {
					throw new BadRaceException(i+1);
				}*/

				else {

					player2 = new Player(txtPlayer2.getText().trim(), colorBox2.getSelectedIndex(),
							difficulty, raceBox2.getSelectedIndex());
					players[i] = player2;
					i++;
				}
			}

			if(numOfPlayers > 2) {

				if(txtPlayer3.getText().trim().isEmpty()) {
					throw new BadNameException(i+1);
				}

				if (colorBox3.getSelectedIndex() == colorBox1.getSelectedIndex()
						|| colorBox3.getSelectedIndex() == colorBox2.getSelectedIndex()) {
					throw new BadColorException(i+1);
				}
/*
				if (raceBox3.getSelectedIndex() == raceBox1.getSelectedIndex()
						|| raceBox3.getSelectedIndex() == raceBox2.getSelectedIndex()) {
					throw new BadRaceException(i+1);
				}
*/
				else {
					player3 = new Player(txtPlayer3.getText().trim(), colorBox3.getSelectedIndex(),
							difficulty, raceBox3.getSelectedIndex());
					players[i] = player3;
					i++;
				}
			}

			if(numOfPlayers > 3) {

				if(txtPlayer4.getText().trim().isEmpty()) {
					throw new BadNameException(i+1);
				}
				if (colorBox4.getSelectedIndex() == colorBox1.getSelectedIndex()
						|| colorBox4.getSelectedIndex() == colorBox2.getSelectedIndex()
						|| colorBox4.getSelectedIndex() == colorBox3.getSelectedIndex()) {
					throw new BadColorException(i+1);
				}

		/*		if (raceBox4.getSelectedIndex() == raceBox1.getSelectedIndex()
						|| raceBox4.getSelectedIndex() == raceBox2.getSelectedIndex()
						|| raceBox4.getSelectedIndex() == raceBox3.getSelectedIndex()){
					throw new BadRaceException(i+1);
				}	
*/
				else {
					player4 = new Player(txtPlayer4.getText().trim(), colorBox4.getSelectedIndex(),
							difficulty, raceBox4.getSelectedIndex());
					players[i] = player4;
					i++;
				}
			}
		}
		catch (BadNameException e){ 
			JOptionPane.showMessageDialog(panel, e.getMessage());
			return null;
		}

		catch (BadColorException e){ 
			JOptionPane.showMessageDialog(panel, e.getMessage());
			return null;
		}

	/*	catch (BadRaceException e){ 
			JOptionPane.showMessageDialog(panel, e.getMessage());
			return null;
		}
*/
		return players;
	}

	/**
	 * The getMainComponent method returns the panel to show 
	 * on the on the frame.
	 * 
	 * @return
	 */
	public JComponent getMainComponent() {
		return panel;
	}
	
	/**
	 * The setDifficulty method sets the level picked by the player(s).
	 * @param level
	 */
	public void setDifficulty(int level) {
		difficulty = level;
	}
}
