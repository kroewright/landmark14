package landmark;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * @author Landmark - Team 14
 *
 */
public class GameDriver{ 

	private static final String OPEN = "openScrn";
	private static final String SEL = "SelPg";
	private static final String MAP = "map";
	private CardLayout cardlayout; // = new CardLayout();
	private JPanel mainPanel; // = new JPanel(cardlayout);
	private OpeningScreen openingScreen; // = new OpeningScreen();
	private Selpage selPage; // = new Selpage();
	private Overworld overworld; // = new Overworld();
	private int numOfPlayers = 0;
	private int isStandard = 0;
	private int difficulty = 0;
	private static JFrame frame;

	/**
	 * The Constructor sets the main panel
	 */
	public GameDriver() {
		cardlayout = new CardLayout();
		mainPanel = new JPanel(cardlayout);
		openingScreen = new OpeningScreen();
		selPage = new Selpage();
		overworld = new Overworld();
		mainPanel.add(openingScreen.getMainComponent(), OPEN);
		mainPanel.add(overworld, MAP);

		/**
		 * Action listener for the NEXT button of the openingScreen.
		 * Opens the SelectionPage to set name, color and race for each player.
		 */
		openingScreen.addBtnNextActionListener (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numOfPlayers = openingScreen.getNumOfPlayers();
				isStandard = openingScreen.getIsStandard();
				difficulty = openingScreen.getDifficulty();

				if(numOfPlayers != 0 && isStandard != 0 && difficulty != 0){
					selPage.setSelpage(numOfPlayers);
					selPage.setDifficulty(difficulty);
					mainPanel.add(selPage.getMainComponent(), SEL);	
					cardlayout.show(mainPanel, SEL);
				}
			}
		});

		/**
		 * Action listener for the START button of the selPage.
		 * Opens the main screen with the Standard Map.
		 */
		selPage.addStartButtonActionListener (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selPage.assign();
				overworld.setPlayers(selPage.getPlayers());
				overworld.setFrame(frame);
				cardlayout.show(mainPanel, MAP);
				overworld.selectionPhase();
			}
		});
	}
	
	/**
	 * Returns the main panel.
	 * 
	 */
	private JComponent getPanel() {
		return mainPanel;

	}
	
	/**
	 * Creates the frame to hold game panels.
	 */
	private static void createAndShowUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 953, 617);

		frame.setContentPane(new GameDriver().getPanel());
		//frame.getContentPane().add(new GameDriver().getPanel());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}		
	
	/**
	 * Starts the game.
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				createAndShowUI();
			}
		});
	}
}

