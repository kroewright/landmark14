package landmark;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameDriver{ 

	private static final String OPEN = "openScrn";
	private static final String SEL = "SelPg";
	private static final String MAP = "map";
	private CardLayout cardlayout = new CardLayout();
	private JPanel mainPanel = new JPanel(cardlayout);
	private OpeningScreen openingScreen = new OpeningScreen();
	private Selpage selPage = new Selpage();
	private Overworld overworld = new Overworld();
	private int numOfPlayers = 0;
	private int isStandard = 0;
	private int difficulty = 0;

	public GameDriver() {
		mainPanel.add(openingScreen.getPanel(), OPEN);
		mainPanel.add(overworld.getMainComponent(), MAP);

		openingScreen.addBtnNextActionListener (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numOfPlayers = openingScreen.getNumOfPlayers();
				isStandard = openingScreen.getIsStandard();
				difficulty = openingScreen.getDifficulty();

				if(numOfPlayers != 0 && isStandard != 0 && difficulty != 0){
					selPage.setSelpage(numOfPlayers);
					mainPanel.add(selPage.getMainComponent(), SEL);	
					cardlayout.show(mainPanel, SEL);
				}
			}
		});

		selPage.addStartButtonActionListener (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selPage.assign();
				cardlayout.show(mainPanel, MAP);
			}
		});
	}

	private JComponent getPanel() {
		return mainPanel;

	}
	private static void createAndShowUI() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 953, 617);

		frame.setContentPane(new GameDriver().getPanel());
		//frame.getContentPane().add(new GameDriver().getPanel());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}		

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				createAndShowUI();
			}
		});
	}
}

