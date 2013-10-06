package landmark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class selpage extends JPanel {

	private JPanel panel;
	private JTextField txtPlayer;
	private JTextField txtEnterYourName;
	private JTextField txtEnterName;
	private JTextField textField_3;

	
	
	
	public JPanel generate(){
		JPanel panel = new JPanel();
		
		
		BufferedImage myPicture = null;
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("Start_Page.jpg");
			myPicture = ImageIO.read(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Picture not found");
		}
		panel.setLayout(null);
		//frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		txtPlayer = new JTextField();
		txtPlayer.setBounds(187, 152, 86, 20);
		panel.add(txtPlayer);
		txtPlayer.setColumns(100);
		
		txtEnterYourName = new JTextField();
		txtEnterYourName.setBounds(309, 152, 86, 20);
		panel.add(txtEnterYourName);
		txtEnterYourName.setColumns(10);
		
		txtEnterName = new JTextField();
		txtEnterName.setBounds(425, 152, 86, 20);
		panel.add(txtEnterName);
		txtEnterName.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(531, 152, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(200, 237, 80, 20);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
		comboBox_1.setBounds(200, 183, 80, 20);
		panel.add(comboBox_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
		comboBox_3.setBounds(317, 185, 80, 20);
		panel.add(comboBox_3);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
		comboBox_5.setBounds(433, 185, 80, 20);
		panel.add(comboBox_5);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
		comboBox_7.setBounds(539, 185, 80, 20);
		panel.add(comboBox_7);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
		comboBox_2.setToolTipText("");
		comboBox_2.setBounds(315, 237, 80, 20);
		panel.add(comboBox_2);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
		comboBox_4.setToolTipText("");
		comboBox_4.setBounds(431, 237, 80, 20);
		panel.add(comboBox_4);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
		comboBox_6.setToolTipText("");
		comboBox_6.setBounds(537, 237, 80, 20);
		panel.add(comboBox_6);
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(0, 0, 792, 576);
		panel.add(picLabel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.BLUE);
		layeredPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		layeredPane.setBackground(Color.CYAN);
		layeredPane.setBounds(209, 202, 100, 100);
		panel.add(layeredPane);
	
		
		return panel;
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//selpage window = new selpage();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public selpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.     
	 */
	private void initialize() {
		
		BufferedImage myPicture = null;
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("Start_Page.jpg");
			myPicture = ImageIO.read(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Picture not found");
		}
		panel.setLayout(null);
		//frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		txtPlayer = new JTextField();
		txtPlayer.setBounds(187, 152, 86, 20);
		panel.add(txtPlayer);
		txtPlayer.setColumns(100);
		
		txtEnterYourName = new JTextField();
		txtEnterYourName.setBounds(309, 152, 86, 20);
		panel.add(txtEnterYourName);
		txtEnterYourName.setColumns(10);
		
		txtEnterName = new JTextField();
		txtEnterName.setBounds(425, 152, 86, 20);
		panel.add(txtEnterName);
		txtEnterName.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(531, 152, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(200, 237, 80, 20);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
		comboBox_1.setBounds(200, 183, 80, 20);
		panel.add(comboBox_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
		comboBox_3.setBounds(317, 185, 80, 20);
		panel.add(comboBox_3);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
		comboBox_5.setBounds(433, 185, 80, 20);
		panel.add(comboBox_5);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
		comboBox_7.setBounds(539, 185, 80, 20);
		panel.add(comboBox_7);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
		comboBox_2.setToolTipText("");
		comboBox_2.setBounds(315, 237, 80, 20);
		panel.add(comboBox_2);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
		comboBox_4.setToolTipText("");
		comboBox_4.setBounds(431, 237, 80, 20);
		panel.add(comboBox_4);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
		comboBox_6.setToolTipText("");
		comboBox_6.setBounds(537, 237, 80, 20);
		panel.add(comboBox_6);
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(0, 0, 792, 576);
		panel.add(picLabel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.BLUE);
		layeredPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		layeredPane.setBackground(Color.CYAN);
		layeredPane.setBounds(209, 202, 100, 100);
		panel.add(layeredPane);
	}
}