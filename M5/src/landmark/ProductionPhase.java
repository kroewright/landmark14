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
import java.awt.BorderLayout;

public class ProductionPhase extends JPanel {
	private Player player;
	
	
	
	public ProductionPhase(Player player){
		this.player = player;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.setBounds(338, 254, 89, 23);
		panel.add(btnEndTurn);
	}
}
