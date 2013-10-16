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
	
	private Tile[][] tiles;
	private JPanel panel;
	private JButton[][] buttons;
	private ImageIcon riverImage;
	private ImageIcon plainImage;
	private ImageIcon mountainImage;
	private int index;
	private Player[] players;
	private int selectionRounds = 0;
	private JFrame frame;
	private int selectionSkips = 0;
	private int playerTurn = 0;
	private int numberOfPlayers;
	private int dialogResult;
	
	
	
	
	
	/**
	* Create the panel.
	*/
	public Overworld() {
		super(new GridLayout(5, 9));
		buttons = new JButton[5][9];
		setPreferredSize(new Dimension(800, 800));
		index = 0;
		
		/*
		riverImage = new ImageIcon("Openingpage.jpg");
		plainImage = new ImageIcon(XXX);
		mountainImage = new ImageIcon(XXX);
		*/
		
		
		for(int i = 0; i < 5; ++i) {
			for(int j = 0; j < 9; ++j) {
				addTile(i, j);
			}
		}
		
		
		Mountains m1 = new Mountains(2, 1);
		tiles[0][2] = m1;
		buttons[0][2].setIcon(new ImageIcon(m1.getImage()));
		Mountains m2 = new Mountains(6, 3);
		tiles[0][6] = m2;
		buttons[0][6].setIcon(new ImageIcon(m2.getImage()));
		Mountains m3 = new Mountains(10, 1);
		tiles[1][1] = m3;
		buttons[1][1].setIcon(new ImageIcon(m3.getImage()));
		Mountains m4 = new Mountains(17, 3);
		tiles[1][8] = m1;
		buttons[1][8].setIcon(new ImageIcon(m4.getImage()));
		Mountains m5 = new Mountains(18, 1);
		tiles[2][0] = m5;
		buttons[2][0].setIcon(new ImageIcon(m5.getImage()));
		Mountains m6 = new Mountains(26, 1);
		tiles[2][8] = m6;
		buttons[2][8].setIcon(new ImageIcon(m6.getImage()));
		Mountains m7 = new Mountains(28, 2);
		tiles[3][1] = m7;
		buttons[3][1].setIcon(new ImageIcon(m7.getImage()));
		Mountains m8 = new Mountains(33, 2);
		tiles[3][6] = m8;
		buttons[3][6].setIcon(new ImageIcon(m8.getImage()));
		Mountains m9 = new Mountains(38, 2);
		tiles[4][2] = m9;
		buttons[4][2].setIcon(new ImageIcon(m9.getImage()));
		Mountains m10 = new Mountains(44, 2);
		tiles[4][8] = m10;
		buttons[4][8].setIcon(new ImageIcon(m10.getImage()));
		
		
		River r1 = new River(4);
		tiles[0][4] = r1;
		buttons[0][4].setIcon(new ImageIcon(r1.getImage()));
		River r2 = new River(13);
		tiles[1][4] = r2;
		buttons[1][4].setIcon(new ImageIcon(r2.getImage()));
		River r3 = new River(31);
		tiles[3][4] = r3;
		buttons[3][4].setIcon(new ImageIcon(r3.getImage()));
		River r4 = new River(40);
		tiles[4][4] = r4;
		buttons[4][4].setIcon(new ImageIcon(r4.getImage()));
		
	}
	
	public JButton addTile(int i, int j) {
		JButton button = new JButton(buttons[i][j].getImage()); //image variable goes inside bracket
		buttons[i][j] = button;
		//Plains v = new Plains(index);
		//tiles[i][j] = v;
		++index;
		//button.addActionListener(new pressedButton(panel, button, i ,j));
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
				if(playerTurn != numberOfPlayers - 1) {
					increasePlayerTurns();
					selectionPhaseTurn();
				}
				else {
					increaseSelectionRound();
					resetPlayerTurns();
					if(selectionSkips != numberOfPlayers) {
						selectionSkips = 0;
						selectionPhaseTurn();
					}
				}
			}
		}
	}
	
	public void productionPhaseTurn() {

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
	
	
	/*
	public static Tile tileFactory(int i, int j){
		if (j == 4 && i != 2){
			return new River(i,j);
		}
		else if (i == 0 && j == 2 || i == 1 && j == 1 || i == 2 && j == 8 ){
			return new Mountains(i,j,1);
		}
		else if (i == 3 && j == 1 || i == 3 && j == 6 ||
				i == 4 && j == 2 || i ==4 && j == 8){
			return new Mountains(i,j,2);
		}
		else if (i == 1 && j == 8 || i == 2 && j == 0
				|| i == 0 && j == 6){
			return new Mountains(i,j,3);
		}
		else if (i == 4 && j == 2){
			return new Town();
		}
		else{
			return new Plains(i,j);
		}
	}*/
	
	
}
