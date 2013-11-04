package landmark;

import javax.swing.JPanel;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import landmark.Tiles.Mountains;
import landmark.Tiles.Plains;
import landmark.Tiles.River;
import landmark.Tiles.Town;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import landmark.Tiles.Mountains;
import landmark.Tiles.Plains;
import landmark.Tiles.River;
import landmark.Tiles.Town;

import java.awt.BorderLayout;

import javax.swing.JSpinner;

import java.awt.Font;

/**
 * 
 * @author Landmark - Team 14
 *
 */

public class TownPanel extends JPanel {

	private Player[] players;
	private Player player;
	private int productionRound;
	private Overworld map;
	private  int turn;
	private JPanel panel;
	private JLabel time;
	private JButton btnPub;
	private JButton btnMap;
	private GameDriver driver;
	private JButton btnOre;
	private JButton btnFood;
	private JButton btnMules;
	private JButton btnEnergy;

	//Sets the player and the layout for Production Phase
	public TownPanel(final Player[] players, final int productionRound, 
			final int turn, final Overworld map, final GameDriver driver){
		super(new BorderLayout());
		this.players = players;
		player = players[turn];
		this.productionRound = productionRound;
		this.turn = turn;
		this.map = map;
		this.driver = driver;
		
		BufferedImage myPicture = null;
		//Try-catch for image for selection screen
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("Tiles/storeBig.gif");
			myPicture = ImageIO.read(input);
		} catch (IOException e) {
			System.out.println("Picture not found");
		}

		panel = new JPanel();
		panel.setLayout(null);
		add(panel);

		
		//Button for energy
		btnEnergy = new JButton("Energy");
		btnEnergy.setBounds(781, 117, 89, 74);
		panel.add(btnEnergy);

		//Button for Food
		btnFood = new JButton("Food");
		btnFood.setBounds(1040, 117, 89, 74);
		panel.add(btnFood);

		//Button for Ore
		btnOre = new JButton("Ore");
		btnOre.setBounds(521, 124, 89, 60);
		panel.add(btnOre);

		//Button for Assay Office
		JButton btnAssay = new JButton("Assay");
		btnAssay.setBounds(266, 340, 89, 169);
		panel.add(btnAssay);

		//Button for Pub Office
		btnPub = new JButton("Pub");
		btnPub.setBounds(694, 356, 89, 100);
		panel.add(btnPub);
		
		//Button for Land Office
		JButton btnLand = new JButton("Land");
		btnLand.setBounds(481, 361, 89, 118);
		panel.add(btnLand);

		//Button for Mules
		btnMules = new JButton("Mules");
		btnMules.setBounds(1040, 457, 89, 100);
		panel.add(btnMules);
		
		//Button for Map
		btnMap = new JButton("Go Back to Map");
		btnMap.setBounds(1175, 550, 150, 100);
		panel.add(btnMap);
		
		/**
		 * Allows the user to go back and forth between the map
		 * and town
		 */
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg2) {
				driver.changeToMapPanel(map);
			}
		});
		
		
		
		//Arrow keys for time left label
		time = new JLabel("50");
		time.setForeground(Color.YELLOW);
		time.setBounds(270, 585, 29, 20);
		panel.add(time);

		//Labels time left on the game screen
		JLabel lblTimeLeft = new JLabel("Time Left: ");
		lblTimeLeft.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimeLeft.setForeground(Color.YELLOW);
		lblTimeLeft.setBounds(187, 578, 100, 31);
		panel.add(lblTimeLeft);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(TownPanel.class.getResource("/Tiles/storeBig.gif")));
		lblNewLabel.setBounds(0, 0, 1449, 720);
		panel.add(lblNewLabel);
		
		Store store= new Store(getPlayer(), this);
		PresenterStoreTownPanel.addListeners(this, store);
	}
	
	public void setOreActionListener(ActionListener E){
		btnOre.addActionListener(E);
	}
	
	public void setFoodActionListener(ActionListener E){
		btnFood.addActionListener(E);
	}
	
	public void setEnergyActionListener(ActionListener E){
		btnEnergy.addActionListener(E);
	}
	
	public void setMulesActionListener(ActionListener E){
		btnMules.addActionListener(E);
	}
	
	public void addPubBtnActionListener(ActionListener listener) {
		btnPub.addActionListener(listener);
	}

	
	/**
	 * This method is called when the user presses the pub button.
	 * The appropriate amount of money is given to the player based
	 * on how much time is left once the pub button is clicked.
	 * 
	 * @param timer
	 */
	public void setPub(final Clock timer) {
	//ActionListener for btnPub
		addPubBtnActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int timeLeft = timer.getCurrentTime();

				JOptionPane.showMessageDialog(panel, "You just got a $" +
						player.goToPub(timeLeft, productionRound) +
						" money bonus! \nMoney: $" + player.getMoney());

				//Ends the player's turn and activate the another player
				if(turn == (players.length - 1)) {
					turn = 0;
					players = map.orderPlayersByScore(players);
				}
				else {
					turn += 1;
				}
				
				if(productionRound == 12) {
					JOptionPane.showMessageDialog(null, "Game over!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				else if(turn == 0 && player == players[players.length - 1]) {
					JOptionPane.showMessageDialog(panel, players[turn].getName() + " begin production phase!"
							, "Production Phase Round " + (productionRound + 1), JOptionPane.INFORMATION_MESSAGE);

					map.setPlayerPanel(players.length);
					ProductionPhaseTurn productionTurn = new ProductionPhaseTurn(players, map, driver);
					map.setProduction(productionTurn);
					driver.changeToMapPanel(map);
				}
				else {
					JOptionPane.showMessageDialog(panel, players[turn].getName() + " begin production phase!"
							, "Production Phase Round " + productionRound, JOptionPane.INFORMATION_MESSAGE);

					map.setPlayerPanel(players.length);
					ProductionPhaseTurn productionTurn = new ProductionPhaseTurn(players, map, driver);
					map.setProduction(productionTurn);
					driver.changeToMapPanel(map);
				}
			}
		});
	}

	public Player getPlayer(){
		return this.player;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public Overworld getMap() {
		return map;
	}
	
	public TownPanel getTP(){
		return this;
	}
	
	public JPanel getPanel(){
		return panel;
	}
	
	
	
	
	/**
	 * Returns the JLabel for the clock.
	 * 
	 * @return time
	 */
	public JLabel getTimeLabel() {
		return time;
	}

	/**
	 * Returns the town panel as a JPanel
	 * 
	 * @return panel
	 */
	public JPanel getMainComponent(){
		return panel;
	}
	
	/**
	 * Sets the GameDriver for the TownPanel in order
	 * to update the graphics.
	 * 
	 * @param driver
	 */
	public void setDriver(GameDriver driver) {
		this.driver = driver;
	}
}
