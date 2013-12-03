package landmark;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

/**
 * 
 * @author Landmark - Team 14
 *
 */
public class GameDriver implements Serializable{ 

	private static final String OPEN = "openScrn";
	private static final String SEL = "SelPg";
	private static final String MAP = "map";
	private static final String TOWN = "town";
	private CardLayout cardlayout; 
	private JPanel mainPanel; 
	private OpeningScreen openingScreen; 
	private Selpage selPage; 
	private Store store;
	static Overworld overworld;
	//private ProductionPhase prodPhase;
	private int numOfPlayers = 0;
	private Player[] players;
	private int isStandard = 1; //default map is standard map = 1 and random map = 2
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
		setOverworld(new Overworld(isStandard));
		mainPanel.add(openingScreen.getMainComponent(), OPEN);
		//mainPanel.add(overworld.getMainComponent(), MAP);
		mainPanel.add(getOverworld(), MAP);

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
						System.out.println("isStandard = " + isStandard);
						setOverworld(new Overworld(isStandard));
						getOverworld().addTownButtonActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) { 
								if(getOverworld().getSelectionSkips() == numOfPlayers && productionRound <= 12) {
									ProductionPhaseTurn turn = getOverworld().getProductionTurn();
									TownPanel town = turn.getTownPanel();
									mainPanel.add(town.getMainComponent(),TOWN);
									cardlayout.show(mainPanel, TOWN);
									//Store store= new Store(overworld.getPlayer(), town);
									//PresenterStoreTownPanel.addListeners(town, store);
								}
							}
						});
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
					getOverworld().setPlayers(players);
					getOverworld().setFrame(frame);
					getOverworld().setDriver(driver);
					mainPanel.add(getOverworld(), MAP);
					cardlayout.show(mainPanel, MAP);
					getOverworld().selectionPhaseTurn();
				}
			}
		});
		
		/**
		 * Action listener for when a player only clicks on the town after the selection phase is finished.
		 */
		getOverworld().addTownButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //BC OF LAW OF DEM. THIS COULD BE MOVED INTO OVERWORLD
				if(getOverworld().getSelectionSkips() == numOfPlayers && productionRound <= 12) {
					ProductionPhaseTurn turn = getOverworld().getProductionTurn();
					TownPanel town = turn.getTownPanel();
					mainPanel.add(town.getMainComponent(),TOWN);
					cardlayout.show(mainPanel, TOWN);
					//Store store= new Store(overworld.getPlayer(), town);
					//PresenterStoreTownPanel.addListeners(town, store);
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
	
	
	
	private static Logger myLogger = Logger.getLogger("landmark.Store");


	/**
     * Save this object via serialization
     * 
     * @param filename the name of the file to save to
     */
   
    
	public void save(String filename) {
			try {
	            /*
	             * Create the object output stream for serialization.
	             * We are wrapping a FileOutputStream since we
	             * want to save to disk.  You can also save to socket
	             * streams or any other kind of stream.
	             */
	           ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
	           
	           /*
	            * The only real call we need.  The stream buffers the output and reuses
	            * data, so if you are serializing very frequently, then the object values might
	            * not actually change because the old serialized object is being reused.
	            * 
	            * To fix this you can try writeUnshared() or you can reset the stream.
	            * out.reset();
	            */
	           out.writeObject(this);
	       } catch (FileNotFoundException e) {
	           myLogger.log(Level.SEVERE, "Save file not found: " + filename, e);
	       } catch (IOException e) {
	           myLogger.log(Level.SEVERE, "General IO Error on saving: " + filename, e);
	       }
	        
	    }
	    
	    /**
	     * This is an example of a factory method
	     * We call this static method to create an
	     * instance of Company from a serialized file.
	     * 
	     * @param filename the name of the file to use
	     * @return an instance of Company initialized from a file.
	     */
	     public static GameDriver getFromFile(String filename) {
	         GameDriver c = null;
	         try {
	             /*
	              * Create the input stream.  Since we want to read from the disk, 
	              * we wrap a file stream.
	              */
	            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
	            /*
	             * Now we can read the entire company in with only one call
	             */
	            c = (GameDriver) in.readObject();
	            
	        } catch (FileNotFoundException e) {
	            myLogger.log(Level.SEVERE, "Load file not found: " + filename, e);
	        } catch (IOException e) {
	            myLogger.log(Level.SEVERE, "General IO Error on loading: " + filename, e);
	        } catch (ClassNotFoundException e) {
	            myLogger.log(Level.SEVERE, "Company class not found on loading: " + filename, e);
	        }
	        return c;
	     }
	    /**
	     * getter and setter for the overworld, to be used by other classes
	     * @return
	     */
		public Overworld getOverworld() {
			return overworld;
		}

		public void setOverworld(Overworld overworld) {
			this.overworld = overworld;
		}
	
}

