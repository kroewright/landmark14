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
	private static final String TOWN = "town";
	private CardLayout cardlayout; 
	private JPanel mainPanel; 
	private OpeningScreen openingScreen; 
	private Selpage selPage; 
	private Store store;
	private Overworld overworld;
	//private ProductionPhase prodPhase;
	private int numOfPlayers = 0;
	private Player[] players;
	private int isStandard = 0;
	private int difficulty = 0;
	private static JFrame frame;
	private int productionRound = 1;
	private GameDriver driver;

	/**
	 * The Constructor sets the main panel
	 */
	public GameDriver() {
		this.driver = this;
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
					if(isStandard == 2) {
						overworld.setMapType(isStandard);
					}
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

				players = selPage.createPlayers(numOfPlayers);
				if(null != players) {             
					overworld.setPlayers(players);
					overworld.setFrame(frame);
					overworld.setDriver(driver);
					cardlayout.show(mainPanel, MAP);
					overworld.selectionPhaseTurn();
				}
			}
		});
		
		/**
		 * Action listener for when a player only clicks on the town after the selection phase is finished.
		 */
		overworld.addTownButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //BC OF LAW OF DEM. THIS COULD BE MOVED INTO OVERWORLD
				if(overworld.getSelectionSkips() == numOfPlayers && productionRound <= 12) {
					ProductionPhaseTurn turn = overworld.getProductionTurn();
					TownPanel town = turn.getTownPanel();
					mainPanel.add(town.getMainComponent(),TOWN);
					cardlayout.show(mainPanel, TOWN);
					Store store= new Store(overworld.getPlayer(), town);
					PresenterStoreTownPanel.addListeners(town, store);
				}
			}
		});
	}

	/**
	 * The getPanel method returns the main panel.
	 * 
	 */
	private JComponent getPanel() {
		return mainPanel;
	}
	
	public void changeToMapPanel(JPanel panel) {
		cardlayout.show(mainPanel, MAP);
	}

	/**
	 * The crateAndShowUI method creates the frame to hold game panels.
	 */
	private static void createAndShowUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1480, 820);

		frame.setContentPane(new GameDriver().getPanel());
		//frame.getContentPane().add(new GameDriver().getPanel());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}		

	/**
	 * The man method starts the game.
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				createAndShowUI();
			}
		});
	}
}

