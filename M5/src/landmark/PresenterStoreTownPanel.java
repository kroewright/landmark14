package landmark;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresenterStoreTownPanel {
	private Store store;
	private TownPanel town;
	
	public PresenterStoreTownPanel(TownPanel town){
		this.town= town;
		
		System.out.println("Presenter");
		
	}
	
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
