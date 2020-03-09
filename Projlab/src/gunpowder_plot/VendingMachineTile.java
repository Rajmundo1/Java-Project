package gunpowder_plot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**  
 * VendingMachineTile osztály.
 * A Tile õsosztályból származik.
 * Ez az osztály felelõs a csokiautomata reprezentálásáért. 
 */
public class VendingMachineTile extends MachineTile{
	
	/**  
	 * A VendingMachineTile osztály Tick metódusa. Ez a mezõ sípoló hangot áraszt a szomszédos mezõkre.
	 * A sípolás meghatározott idõközönként történik.
	 * @return void
	 */
	public void Tick() {
		boolean random = (new Random().nextInt(20) == 0); // 5%
		boolean willStimulate = random;
		if (willStimulate) {
			List<Animal> occupants = new ArrayList<Animal>();
			
			for(Tile tile : neighbors) {
				Animal o = tile.GetOccupant();
				if(o != null)
					occupants.add(o);
			}
			
			for (Animal o : occupants)
					o.Stimulate(this);
		}
	}
}
