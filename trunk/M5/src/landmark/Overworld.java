package landmark;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import landmark.Tiles.Mountains;
import landmark.Tiles.Plains;
import landmark.Tiles.River;
import landmark.Tiles.Town;

/**
 * 
 * @author landmark - team 14
 *
 */

@SuppressWarnings("serial")
public class Overworld extends JPanel {
	
	private Tile[][] tiles = new Tile[5][9];
	private static Tile[][] randTiles = new Tile[5][9];
	private JPanel panel;
	private JPanel grid;
	private JPanel playerPanel;
	private JButton[][] buttons = new JButton[5][9];
	private Player[] players;
	private int selectionRounds = 0;
	private JFrame frame;
	private int selectionSkips = 0;
	private int playerTurn = 0;
	private int numberOfPlayers;
	private int mapType = 1; //default map is standard map = 1 and random map = 2
	private ProductionPhaseTurn productionTurn;
	private JList player1;
	private JList player2;
	private JList player3;
	private JList player4;
	private String player1Name;
	private String player2Name;
	private String player3Name;
	private String player4Name;
	
	/**
     * Create the panel.
	 */
	public Overworld() {
		super(new BorderLayout());
		grid = new JPanel(new GridLayout(5, 9));
		add(grid, BorderLayout.CENTER);
		playerPanel = new JPanel();
		playerPanel.setBackground(new Color(207,181,59));
		add(playerPanel, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(1480, 820));
		setMapType(mapType);
	}
	
	/**
	 * Method that sets the map type, standard or random
	 * 
	 * @param mapType - 1 is standard, 2 is random, default is 1
	 */
	public void setMapType(int mapType) {
		this.mapType = mapType;
		
		if(mapType == 2){
			Random rand = new Random();
			initializeRandTiles(rand);
		}
		
		
		for(int i = 0; i < 5; ++i) {
			for(int j = 0; j < 9; ++j) {
				addTileStandardMap(i, j);
			
				
			}
		}
	}
	
	/**
	 * Method that adds tile to the standard map.
	 * 
	 * @param i
	 * @param j
	 */
	public void addTileStandardMap(int i, int j) {
		Tile p;
		if(mapType == 1){
			p = tileFactory(i, j);
			}
		else {
			p = randTiles[i][j];
		}
		
		JButton button = new JButton();
		button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Tiles/" + p.getImage())));
		buttons[i][j] = button;
		tiles[i][j] = p;
		grid.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectionSkips < numberOfPlayers) {
					for(int i = 0; i < 5; ++i) {
						for(int j = 0; j < 9; ++j) {
							if(e.getSource() == buttons[i][j]) {
								if(i == 2 && j == 4) {
					
									String playerName = players[playerTurn].getName();
									JOptionPane.showMessageDialog(frame, playerName + " you cannot have the town! Please " +
											"select another property.", "Land Selection Phase", JOptionPane.ERROR_MESSAGE);
								}
								else if (selectionRounds < 2) {
									if(tiles[i][j].getOwner() == null) {
										players[playerTurn].addTileOwned(tiles[i][j]);
										buttons[i][j].setIcon(new ImageIcon(getClass().getClassLoader().
												getResource("Tiles/" + tiles[i][j].getImage())));

										if(playerTurn != numberOfPlayers - 1) {
											increasePlayerTurns();
										}
										else {
											increaseSelectionRound();
											resetPlayerTurns();
										}
									}
									else {
										JOptionPane.showMessageDialog(frame, "This property is already owned! Please " +
												"select another property.", "Land Selection Phase", JOptionPane.ERROR_MESSAGE);
									}
								}
								else {
									if(tiles[i][j].getOwner() == null) {
										players[playerTurn].buyLandSelectionPhase(tiles[i][j]);
										setPlayerPanel(numberOfPlayers);
										buttons[i][j].setIcon(new ImageIcon(getClass().getClassLoader().
												getResource("Tiles/" + tiles[i][j].getImage())));

										if(playerTurn != numberOfPlayers - 1) {
											increasePlayerTurns();
										}
										else {
											increaseSelectionRound();
											resetPlayerTurns();
										}
										resetSelectionSkips();
									}
									else {
										JOptionPane.showMessageDialog(frame, "This property is already owned! Please " +
												"select another property.", "Land Selection Phase", JOptionPane.ERROR_MESSAGE);
									}
								}
							}
						}
					}
					selectionPhaseTurn();
				}
			}
		});
	}
	
	/**
	 * Action listener for when a player only clicks on the town after the selection phase is finished.
	 */
	public void addTownButtonActionListener(ActionListener listener) {
			buttons[2][4].addActionListener(listener);
	}
	
	/**
	 * Method that shows which player's turn it is in the game.
	 * Allows them to buy property based on how much money they have.
	 */
	public void selectionPhaseTurn() {
		String playerName = players[playerTurn].getName();
			   
		if(selectionRounds < 2) {
			JOptionPane.showMessageDialog(frame, (playerName + " select a property."), "Land Selection Phase"
					, JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(frame, (playerName + " would you like to buy a property for $300? If yes," + 
					" click a property. Money available: $" + players[playerTurn].getMoney()),"Land Selection Phase", dialogButton);
			   
			if(dialogResult == JOptionPane.YES_OPTION) {
				if(players[playerTurn].getMoney() < 300) {
					JOptionPane.showMessageDialog(frame, (playerName + " you do not have enough money!"), "Land Selection Phase"
							, JOptionPane.ERROR_MESSAGE);
					
					selectionSkips += 1;
					
					if(playerTurn == numberOfPlayers - 1) {
						increaseSelectionRound();
						resetPlayerTurns();
						if(selectionSkips != numberOfPlayers) {
							resetSelectionSkips();
							selectionPhaseTurn();
						}
						else {
							players = orderPlayersByScore(players);							
							playerName = players[playerTurn].getName();
							JOptionPane.showMessageDialog(frame, (playerName + " begin production phase!"), "Production Phase"
									, JOptionPane.INFORMATION_MESSAGE);
							
							productionTurn = new ProductionPhaseTurn(players, this);
						}
					}
					else {
						increasePlayerTurns();
						selectionPhaseTurn();
					}
				}
			}
			else if(dialogResult == JOptionPane.NO_OPTION) {
				selectionSkips += 1;
				
				if(playerTurn == numberOfPlayers - 1) {
					increaseSelectionRound();
					resetPlayerTurns();
					if(selectionSkips != numberOfPlayers) {
						resetSelectionSkips();
						selectionPhaseTurn();
					}
					else {
						players = orderPlayersByScore(players);

						playerName = players[playerTurn].getName();
						JOptionPane.showMessageDialog(frame, (playerName + " begin production phase!"), "Production Phase"
								, JOptionPane.INFORMATION_MESSAGE);
						
						productionTurn = new ProductionPhaseTurn(players, this);
					}
				}
				else {
					increasePlayerTurns();
					selectionPhaseTurn();
				}
			}
		}
	}
	
	//Creates a new production phase
	public ProductionPhaseTurn getProductionTurn() {
		return productionTurn;
	}
	
	//Returns main panel
	public JComponent getMainComponent() {
		return panel;
    }
	
	public JPanel getPlayerPanel() {
		return playerPanel;
	}
	
	//Returns number of player turns
	public int getPlayerTurns() {
		return playerTurn;
	}
	
	//Returns the number of times a player has selected no
	public int getSelectionSkips() {
		return selectionSkips;
	}
	
	//Returns number of rounds played, 
	//a round is complete when all players have gone
	public int getSelectionRounds() {
		return selectionRounds;
	}
	
	//Sets the number of players in a given game
	public void setPlayers(Player[] people) {
		players = people;
		numberOfPlayers = players.length;
		
		switch(numberOfPlayers) {
			case 1:
				player1Name = players[0].getName();
				break;
			case 2:
				player1Name = players[0].getName();
				player2Name = players[1].getName();
				break;
			case 3:
				player1Name = players[0].getName();
				player2Name = players[1].getName();
				player3Name = players[2].getName();
				break;
			case 4:
				player1Name = players[0].getName();
				player2Name = players[1].getName();
				player3Name = players[2].getName();
				player4Name = players[3].getName();
				break;
		}
		
		setPlayerPanel(numberOfPlayers);
	}
	
	public void setProduction(ProductionPhaseTurn turn) {
		productionTurn = turn;
	}
	
	//Sets the JFrame window for the game
	public void setFrame(JFrame window) {
		frame = window;
	}
	
	//Increments number of times a player has selected no by 1
	public void increaseSelectionSkips() {
		selectionSkips += 1;
	}
	
	//Increments the number of rounds played by 1
	public void increaseSelectionRound() {
		selectionRounds += 1;
	}
	
	//Increments numbers of player turns by 1
	public void increasePlayerTurns() {
		playerTurn += 1;
	}
	
	//Resets the number of player turns back to 0
	public void resetPlayerTurns() {
		playerTurn = 0;
	}
	
	//Resets the number of times a player has selected no back to 0
	public void resetSelectionSkips() {
		selectionSkips = 0;
	}
	
	
	
	/**
	 * Tile factory that places tiles on the map.
	 * @param i - row
	 * @param j - column
	 * @return Tile - tile created
	 */
	public static Tile tileFactory(int i, int j){
		int numOfColumns = 9;
		int location = (i*numOfColumns)+j;
		
		if (i != 2 && j == 4){
			return new River(location);
		}
		else if (i == 0 && j == 2 || i == 1 && j == 1 || i == 2 && j == 8 ){
			return new Mountains(location,1);
		}
		else if (i == 3 && j == 1 || i == 3 && j == 6 ||
				i == 4 && j == 2 || i ==4 && j == 8){
			return new Mountains(location,2);
		}
		else if (i == 1 && j == 8 || i == 2 && j == 0
				|| i == 0 && j == 6){
			return new Mountains(location,3);
		}
		else if (i == 2 && j == 4){
			return new Town();
		}
		else{
			return new Plains(location);
		}
	}
	
	
	/**
	 * Randomized Tile factory
	 * 
	 * This function first creates a linked list holding a tuple
	 * of the row and column for each tile. it then uses a random
	 * number generator to add it to a randomized list of coordinates
	 * named randomCoors. Which would look as follows:
	 *  [ [1,4] , [2,3] , [0,8] ..... ] etc. 
	 *  The coordinates are then placed in a Tile[][] called
	 *  randTiles, after being instantiated.
	 * 
	 * @param Random object
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void initializeRandTiles(Random r){
		int[][] randomCoors = new int[45][2];
		
		
		List nums = new LinkedList();
		for(int i = 0; i<5; i++){
			for(int j=0; j<9; j++){
				int[] tup = new int[2];
				tup[0] = i;
				tup[1] = j;
				nums.add(tup);
			}
		}

		int size = 45;
		for(int i = 0; i<45;i++){
			int randy = r.nextInt(size);
			int[] tup = (int[])nums.remove(randy);
			size--;
			randomCoors[i] = tup;
		}
		
		for(int i = 0; i<5; i++){
			for(int j = 0; j<9; j++){
				int[] tup = randomCoors[i*9+j];
				randTiles[i][j] = tileFactory(tup[0],tup[1]);
				System.out.print(i);
				System.out.print(j);
			}
		}
	}
	
	/**
	 * 
	 * Orders the list of players using an insertion sort :)
	 * 
	 * @param unordered list of players
	 * @return ordered list of players
	 */
	public Player[] orderPlayersByScore(Player[] players){
		Player holder;
		int k;
		for(int i=1;i<players.length;i++){
			holder = players[i];
			for(k=i-1;	k>=0 ;k--){
				if(holder.getScore() < players[k].getScore()){
					players[k+1]=players[k];
				}
				else break;
				
			}
			players[k+1]=holder;
		}
		for(Player el: players){
			System.out.print(el.getName());
			System.out.println(el.getScore());
		}
		
		
		return players;
	}
	
	
	/*
	 * Note for future construction:
	 * 	
	 * In order to allow Mule's to appear graphically on the screen, methods allowing
	 * each tile in the grid to have items added to them need to be implemented. 
	 * Some sort of getTileAt(i,j) and then addToTile(Tile t, JLabel mulePic) should be made
	 * 
	 * -Mason
	 */
	public Tile getTileAt(int i, int j){
		return null;
	}
	
	public void addToTile(Tile t, JLabel mulePicture){
		
	}
	
	/**
	 * Creates the panel on the bottom of the map so players
	 * can see their metrics.
	 * 
	 * @param numOfPlayers
	 */
	public void setPlayerPanel(int numOfPlayers) {
		
		/**
		 * If 1 players has been selected,
		 * create a JList for him.
		 */
		if(numOfPlayers > 0) {
			for(Player p : players) {
				if(player1Name == p.getName()) {
					DefaultListModel player1Info = new DefaultListModel();
					player1Info.addElement(player1Name);
					player1Info.addElement("Money: $" + p.getMoney());
					player1Info.addElement("Food: " + p.getFood());
					player1Info.addElement("Energy: " + p.getEnergy());
					player1Info.addElement("Ore: " + p.getOre());
					if(player1 != null) {
						playerPanel.remove(player1);
					}
					player1 = new JList(player1Info);
					playerPanel.add(player1);
				}
			}
		}
		
		/**
		 * If 2 players have been selected,
		 * create JList for another player.
		 */
		if(numOfPlayers > 1) {
			for(Player p : players) {
				if(player2Name == p.getName()) {
					DefaultListModel player2Info = new DefaultListModel();
					player2Info.addElement(player2Name);
					player2Info.addElement("Money: $" + p.getMoney());
					player2Info.addElement("Food: " + p.getFood());
					player2Info.addElement("Energy: " + p.getEnergy());
					player2Info.addElement("Ore: " + p.getOre());
					if(player2 != null) {
						playerPanel.remove(player2);
					}
					player2 = new JList(player2Info);
					playerPanel.add(player2);
				}
			}
		}

		/**
		 * If 3 players have been selected,
		 * create another JList.
		 */
		if(numOfPlayers > 2) {
			for(Player p : players) {
				if(player3Name == p.getName()) {
					DefaultListModel player3Info = new DefaultListModel();
					player3Info.addElement(player3Name);
					player3Info.addElement("Money: $" + p.getMoney());
					player3Info.addElement("Food: " + p.getFood());
					player3Info.addElement("Energy: " + p.getEnergy());
					player3Info.addElement("Ore: " + p.getOre());
					if(player3 != null) {
						playerPanel.remove(player3);
					}
					player3 = new JList(player3Info);
					playerPanel.add(player3);
				}
			}
		}

		/**
		 * If 4 players have been selected,
		 * create another JList.
		 */
		if(numOfPlayers > 3) {
			for(Player p : players) {
				if(player4Name == p.getName()) {
					DefaultListModel player4Info = new DefaultListModel();
					player4Info.addElement(player4Name);
					player4Info.addElement("Money: $" + p.getMoney());
					player4Info.addElement("Food: " + p.getFood());
					player4Info.addElement("Energy: " + p.getEnergy());
					player4Info.addElement("Ore: " + p.getOre());
					if(player4 != null) {
						playerPanel.remove(player4);
					}
					player4 = new JList(player4Info);
					playerPanel.add(player4);
				}
			}
		}
		updateUI();
	}	
}
