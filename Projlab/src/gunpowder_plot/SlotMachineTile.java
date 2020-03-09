package gunpowder_plot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**  
 * SlotMachineTile osztály.
 * A Tile õsosztályból származik.
 * Ez az osztály felelõs a játékgép reprezentálásáért. 
 */
public class SlotMachineTile extends MachineTile{
	
	/**  
	 * A SlotMachineTile osztály Tick metódusa. Ez a mezõ csilingelõ hangot áraszt a szomszédos mezõkre.
	 * A csilingelés meghatározott idõközönként történik.
	 * @param - Ennek a függvénynek nincsenek paraméterei
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
