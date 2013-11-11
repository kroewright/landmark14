package landmark;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

/**
 * 
 * @author landmark - team 14
 * 
 * Class that adds action listeners to the town panel for the 
 * purchase of store items.
 *
 */
public class PresenterStoreTownPanel implements Serializable {
	public static Store store;
	private TownPanel town;
	
	public PresenterStoreTownPanel(TownPanel town){
		this.town= town;
		
		System.out.println("Presenter");
		
	}
	
	/**
	 * Constructor that contains the town panel and the store in
	 * which the action listeners are added to.
	 * 
	 * @param town
	 * @param store
	 */
	public static void addListeners(TownPanel town, final Store store){
	
		town.setOreActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.oreButt();
			}
		});
		
		town.setEnergyActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.energyButt();
			}
		});
		
		town.setFoodActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.foodButt();
			}
		});
		
		town.setMulesActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.muleButt();
			}
		});
	}
}
