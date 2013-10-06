package landmark;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class OpeningScreen extends JFrame {
    static int numOfPlayers=0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpeningScreen frame = new OpeningScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OpeningScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 617);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		
		
		JPanel center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		BufferedImage myPicture = null;
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("Openingpage.jpg");
			myPicture = ImageIO.read(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Picture not found");
		}
		
		
		
		
		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setBounds(367, 586, 58, 23);
		lblPlayers.setFont(new Font("Garuda", Font.BOLD, 17));
		center.add(lblPlayers);
		
		
		
		
		
		JButton btn2 = new JButton("2");
		btn2.setBackground(new Color(204, 255, 204));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg2) {
				numOfPlayers = 2;				
			}
		});
		btn2.setBounds(330, 392, 65, 69);
		center.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg3) {
				numOfPlayers = 3;
			}
		});
		btn3.setBounds(427, 392, 58, 69);
		center.add(btn3);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				numOfPlayers = 1;
			}
		});
		btn1.setBounds(245, 392, 58, 69);
		center.add(btn1);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg4) {
				numOfPlayers = 4;
			}
		});
		btn4.setBounds(516, 392, 58, 69);
		center.add(btn4);
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(18, 5, 792, 576);
		center.add(picLabel);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel south = new JPanel();
		south.setBackground(new Color(255, 204, 0));
		contentPane.add(south, BorderLayout.SOUTH);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setFont(new Font("Garuda", Font.BOLD, 17));
		lblDifficulty.setHorizontalAlignment(SwingConstants.LEFT);
		south.add(lblDifficulty);
		
		JRadioButton rdbtnBeginner = new JRadioButton("Beginner");
		rdbtnBeginner.setBackground(new Color(255, 204, 0));
		
		JRadioButton rdbtnAdvanced = new JRadioButton("Advanced");
		rdbtnAdvanced.setBackground(new Color(255, 204, 0));
		
		JRadioButton rdbtnTournament = new JRadioButton("Tournament");
		rdbtnTournament.setBackground(new Color(255, 204, 0));

		ButtonGroup bg1 = new ButtonGroup( );
		bg1.add(rdbtnBeginner);
		bg1.add(rdbtnAdvanced);
		bg1.add(rdbtnTournament);

		south.add(rdbtnBeginner);
		south.add(rdbtnAdvanced);
		south.add(rdbtnTournament);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				}
		});
		south.add(btnStart);
		
		
		
		
	}
}
