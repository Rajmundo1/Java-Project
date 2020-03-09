package gunpowder_plot;
import java.util.ArrayList;

/**  
 * EntryTile osztály.
 * A Tile õsosztályból származik.
 * Ez az osztály felelõs a belépõ mezõ reprezentálásáért. 
 */
public class EntryTile extends Tile{
	/**
	 * Egy várakozási sor az állatoknak, mert egyszerre csak egy állat lehet a mezõn.
	 */
	private ArrayList<Animal> queue = new ArrayList<Animal>();
	
	/**  
	 * Az EntryTile osztály StepOn metódusa. Ez a függvény azt a szituációt reprezentálja, amikor egy állat rá szeretne lépni erre a mezõre.
	 * @param animal - Egy Animal objektum, amely rá szeretne lépni erre a mezõre.
	 * @return void
	 */
	@Override
	public void StepOn(Animal animal) {
		if(!queue.contains(animal) || queue.get(0) == animal)
			if(animal.SteppedOn(this)) {
				occupant = animal;
				if(!queue.isEmpty() && queue.get(0) == occupant)
					queue.remove(0);
			}
	}
	
	
	/**  
	 * Az EntryTile osztály JoinQueue metódusa. Ez a függvény adja hozzá az állatot az EntryTile várakozási sorához.
	 * @param animal - Animal típusú objektum.
	 * @return void
	 */
	public void JoinQueue(Animal animal) {
		queue.add(animal);	
	}
}
