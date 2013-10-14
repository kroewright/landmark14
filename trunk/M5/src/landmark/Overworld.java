package landmark;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
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

public class Overworld extends JPanel {
	
	private Tile[][] tiles;
	private JPanel panel;
	private JButton[][] buttons;
	private ImageIcon riverImage;
	private ImageIcon plainImage;
	private ImageIcon mountainImage;
	private int index;
	
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
		
		/*
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
		*/
	}
	
	public JButton addTile(int i, int j) {
		JButton button = new JButton("P"); //image variable goes inside bracket
		buttons[i][j] = button;
		//Plains v = new Plains(index);
		//tiles[i][j] = v;
		++index;
		button.addActionListener(new pressedButton(button, i ,j));
		add(button);
		return button;
	}
	
	private class pressedButton implements ActionListener
	{
		private JButton button;
		private int i;
		private int j;
		
		/**
		 * A constructor that takes in the pressed button and its
		 * coordinates on the GridLayout so it can be picked from
		 * the array.
		 * 
		 * @param button
		 * @param i
		 * @param j
		 */
		public pressedButton(JButton button, int i, int j)
		{
			this.button = button;
			this.i = i;
			this.j = j;
		}
		
		/**
		 * This method runs when the button is pushed. It checks 
		 * to see if the pushed button is a valid move, moves 
		 * the player to the spot if the move is valid, and then gets
		 * the new valid moves and changes their color to yellow.
		 * 
		 * @param e
		 */
		public void actionPerformed(ActionEvent e) {
			button.setBackground(Color.GREEN);
			updateUI();
		}
	}
	
	   public JComponent getMainComponent() {
           return panel;
       }

}
