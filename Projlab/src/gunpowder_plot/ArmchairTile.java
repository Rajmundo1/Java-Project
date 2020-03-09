package gunpowder_plot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**  
 * ArmchairTile osztály.
 * A Tile õsosztályból származik.
 * Ez az osztály felelõs a fotel reprezentálásáért. 
 */
public class ArmchairTile extends Tile{
	
	/**  
	 * Az ArmchairTile osztály Tick metódusa. Ez a mezõ megpróbálja maga felé csalogatni a szomszédos mezõkön álló állatokat.
	 * Ez az esemény meghatározott idõközönként történik.
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
			
			for (Animal o : occupants) {
				o.Stimulate(this); // itt megváltozhat az occupant
				if(occupant != null)
					break;
			}
					
		}
	}
	
	
	/**  
	 * Az ArmchairTile osztály StepOn metódusa. Ez a függvény azt a szituációt reprezentálja, amikor egy állat rá szeretne lépni erre a mezõre.
	 * @param animal - Egy Animal objektum, amely rá szeretne lépni erre a mezõre.
	 * @return void
	 */
	@Override
	public void StepOn(Animal animal) {
		if(animal.SteppedOn(this)) {
			occupant = animal;
		}			
	}
}
