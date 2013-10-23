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
	
	final private int productionRound;
	private Player player;
	JPanel panel;
	private JLabel time;

	//Sets the player and the layout for Production Phase
	public TownPanel(final Player player, final int productionRound){		
		this.player = player;
		this.productionRound = productionRound;
		
		setLayout(new BorderLayout(0, 0));

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

		add(panel);
		panel.setLayout(null);


		//Button for energy
		JButton Energy = new JButton("Energy");
		Energy.setBounds(781, 117, 89, 74);
		panel.add(Energy);

		//Button for Food
		JButton Food = new JButton("Food");
		Food.setBounds(1040, 117, 89, 74);
		panel.add(Food);

		//Button for Ore
		JButton btnOre = new JButton("Ore");
		btnOre.setBounds(521, 124, 89, 60);
		panel.add(btnOre);

		//Button for Assay Office
		JButton btnAssay = new JButton("Assay");
		btnAssay.setBounds(266, 340, 89, 169);
		panel.add(btnAssay);

		//Button for Pub Office
		JButton btnPub = new JButton("Pub");
		btnPub.setBounds(694, 356, 89, 100);
		panel.add(btnPub);

		//ActionListener for btnPub
				btnPub.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Clock timer = player.getTimer();
						int timeLeft = timer.getCurrentTime();
						JOptionPane.showMessageDialog(panel, "You just got a $" +
								player.goToPub(timeLeft, productionRound) +
								" money bonus! \nMoney: $" + player.getMoney());
					
						//Ends a player's turn and activate the another player
						
						    int turn = timer.getTurn();
						    Overworld map = timer.getMap();
						    Player[] players = timer.getPlayers();
						    GameDriver driver = timer.getDriver();
						    	
						    	if(timer.getTurn() == (players.length - 1)) {
						    		turn = 0;
						    		players = map.orderPlayersByScore(players);
						    	}
						    	else {
						    		turn += 1;
						    	}
						    	
						    	
						    	JOptionPane.showMessageDialog(panel, players[turn].getName() + " begin production phase!"
						    			, "Production Phase", JOptionPane.INFORMATION_MESSAGE);
						    	
						    	ProductionPhaseTurn productionTurn = new ProductionPhaseTurn(players, map);
						    	map.setProduction(productionTurn);
						    	driver.changeToMapPanel(map);
						    }
				});


		//Button for Land Office
		JButton btnLand = new JButton("Land");
		btnLand.setBounds(481, 361, 89, 118);
		panel.add(btnLand);

		//Button for Mules
		JButton btnMules = new JButton("Mules");
		btnMules.setBounds(1040, 457, 89, 100);
		panel.add(btnMules);

		//Arrow keys for time left label
		time = new JLabel();
		time.setForeground(Color.YELLOW);
		time.setBounds(270, 585, 29, 20);
		panel.add(time);

		//Labels time left on the game screen
		JLabel lblTimeLeft = new JLabel("Time Left: ");
		lblTimeLeft.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimeLeft.setForeground(Color.YELLOW);
		lblTimeLeft.setBounds(187, 578, 100, 31);
		panel.add(lblTimeLeft);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TownPanel.class.getResource("/Tiles/storeBig.gif")));
		lblNewLabel.setBounds(0, 0, 1449, 720);
		panel.add(lblNewLabel);
	}

	public JLabel getTimeLabel() {
		return time;
	}

	public JPanel getMainComponent(){
		return panel;
	}
}
