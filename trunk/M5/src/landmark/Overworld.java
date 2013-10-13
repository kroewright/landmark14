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

import landmark.Tiles.Plains;

public class Overworld extends JPanel {
	
	private Tile[][] tiles;
	private BufferedImage picture;
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
		riverImage = new ImageIcon(XXX);
		plainImage = new ImageIcon(XXX);
		mountainImage = new ImageIcon(XXX);
		*/
		/*
		River r = new River();
		Mountain m1 = new Mountain(1);
		Mountain m2 = new Mountain(2);
		Mountain m3 = new Mountain(3);
		*/
		
		
		for(int i = 0; i < 5; ++i) {
			for(int j = 0; j < 9; ++j) {
				addTile(i, j);
			}
		}
		
		//Still need to go through buttons and add appro. tile type
		
	}
	
	public JButton addTile(int i, int j) {
		JButton button = new JButton("P");
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
