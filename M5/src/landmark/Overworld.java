package landmark;

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
	private int dialogResult;
	private int mapType = 1; //default map is standard map = 1 and random map = 2
	
	/**
	* Create the panel.
	*/
	public Overworld() {
		super(new GridLayout(5, 9));
		setPreferredSize(new Dimension(1469, 720));
		setMapType(mapType);
	}
	
	public void setMapType(int mapType) {
		this.mapType = mapType;
		
		for(int i = 0; i < 5; ++i) {
			for(int j = 0; j < 9; ++j) {
				if(mapType == 1) {
					addTileStandardMap(i, j);
				}
				else if(mapType == 2) {
					
				}
			}
		}
	}
	
	public JButton addTileStandardMap(int i, int j) {
		Tile p = tileFactory(i, j);
		JButton button = new JButton();
		button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Tiles/" + p.getImage())));
		buttons[i][j] = button;
		tiles[i][j] = p;
		add(button);
		return button;
	}
	
	public void addMapButtonActionListener(ActionListener listener) {
		for(int i = 0; i < 5; ++i) {
			for(int j = 0; j < 9; ++j) {
				buttons[i][j].addActionListener(listener);;
			}
		}
	}
	
	public void selectionPhaseTurn() {
		String playerName = players[playerTurn].getName();
			   
		if(selectionRounds < 2) {
			JOptionPane.showMessageDialog (frame, (playerName + " select a property."), "Land Selection Phase"
					, JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			dialogResult = JOptionPane.showConfirmDialog (frame, (playerName + " would you like to buy a property for $300? If yes," + 
					" click a property. Money available: $" + players[playerTurn].getMoney()),"Land Selection Phase", dialogButton);
			   
			if(dialogResult == JOptionPane.YES_OPTION) {
				if(players[playerTurn].getMoney() < 300) {
					JOptionPane.showMessageDialog (frame, (playerName + " you do not have enough money!"), "Land Selection Phase"
							, JOptionPane.ERROR_MESSAGE);
					selectionPhaseTurn();
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
						JOptionPane.showMessageDialog (frame, (playerName + " begin production phase!"), "Production Phase"
								, JOptionPane.INFORMATION_MESSAGE);
						
						productionPhaseTurn(players[playerTurn]);
					}
				}
				else {
					increasePlayerTurns();
					selectionPhaseTurn();
				}
			}
		}
	}
	
	public ProductionPhase productionPhaseTurn(Player player) {
		ProductionPhase prodPhase = new ProductionPhase(player);
		return prodPhase;
	}
	
	public JComponent getMainComponent() {
		return panel;
    }
	
	public int getPlayerTurns() {
		return playerTurn;
	}
	
	public int getSelectionSkips() {
		return selectionSkips;
	}
	
	public int getSelectionRounds() {
		return selectionRounds;
	}
	
	public JButton[][] getButtons() {
		return buttons;
	}
	
	public int getDialogResult() {
		return dialogResult;
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}
	   
	public void setPlayers(Player[] people) {
		players = people;
		numberOfPlayers = players.length;
	}
		   
	public void setFrame(JFrame window) {
		frame = window;
	}
	
	public void increaseSelectionSkips() {
		selectionSkips += 1;
	}
	
	public void increaseSelectionRound() {
		selectionRounds += 1;
	}
	
	public void increasePlayerTurns() {
		playerTurn += 1;
	}
	
	public void resetPlayerTurns() {
		playerTurn = 0;
	}
	
	public void resetSelectionSkips() {
		selectionSkips = 0;
	}
	
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
