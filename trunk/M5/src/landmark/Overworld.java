package landmark;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JPanel panel;
	private JButton[][] buttons = new JButton[5][9];
	private Player[] players;
	private int selectionRounds = 0;
	private JFrame frame;
	private int selectionSkips = 0;
	private int playerTurn = 0;
	private int numberOfPlayers;
	private int mapType = 1; //default map is standard map = 1 and random map = 2
	private ProductionPhaseTurn productionTurn;
	private TownPanel town;
	
	/**
     * Create the panel.
	 */
	public Overworld() {
		super(new GridLayout(5, 9));
		setPreferredSize(new Dimension(1469, 720));
		setMapType(mapType);
	}
	
	/**
	 * Method that sets the map type, standard or random
	 * 
	 * @param mapType - 1 is standard, 2 is random, default is 1
	 */
	public void setMapType(int mapType) {
		this.mapType = mapType;
		
		for(int i = 0; i < 5; ++i) {
			for(int j = 0; j < 9; ++j) {
				if(mapType == 1) {
					addTileStandardMap(i, j);
				}
				else if(mapType == 2) {
					//Insert code here to make random map using new tile factory
				}
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
		Tile p = tileFactory(i, j);
		JButton button = new JButton();
		button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Tiles/" + p.getImage())));
		buttons[i][j] = button;
		tiles[i][j] = p;
		add(button);
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
	public void addMapButtonActionListener(ActionListener listener) {
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
	 *
	 */
	public static Tile tileFactory(int i, int j){
		int location = (i*j)+j;
		
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
}
