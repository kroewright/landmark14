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

public class ProductionPhase extends JPanel {
	private Player player;
	JPanel panel;
	
	
	public ProductionPhase(Player player){
		this.player = player;
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
		
		JButton Energy = new JButton("Energy");
		Energy.setBounds(781, 117, 89, 74);
		panel.add(Energy);
		
		JButton Food = new JButton("Food");
		Food.setBounds(1040, 117, 89, 74);
		panel.add(Food);
		
		JButton btnOre = new JButton("Ore");
		btnOre.setBounds(521, 124, 89, 60);
		panel.add(btnOre);
		
		JButton btnAssay = new JButton("Assay");
		btnAssay.setBounds(266, 340, 89, 169);
		panel.add(btnAssay);
		
		JButton btnLand = new JButton("Land");
		btnLand.setBounds(481, 361, 89, 118);
		panel.add(btnLand);
		
		JButton btnMules = new JButton("Mules");
		btnMules.setBounds(1040, 457, 89, 100);
		panel.add(btnMules);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(270, 585, 29, 20);
		panel.add(spinner);
		
		JLabel lblTimeLeft = new JLabel("Time Left");
		lblTimeLeft.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimeLeft.setForeground(Color.YELLOW);
		lblTimeLeft.setBounds(187, 578, 71, 31);
		panel.add(lblTimeLeft);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ProductionPhase.class.getResource("/Tiles/storeBig.gif")));
		lblNewLabel.setBounds(0, 0, 1449, 720);
		panel.add(lblNewLabel);
	}
	
	
	public JPanel getMainComponent(){
		return panel;
	}
}
