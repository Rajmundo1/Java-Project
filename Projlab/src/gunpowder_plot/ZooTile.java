package gunpowder_plot;
import java.util.ArrayList;
import java.util.List;

/**  
 * ZooTile osztály.
 * A Tile õsosztályból származik.
 * Ez az osztály felelõs az állatkert mezõ reprezentálásáért. 
 */
public class ZooTile extends Tile{
	/**
	 * Belépõ mezõ.
	 */
	private Tile wayIn;
	/**
	 * Állatok listája.
	 */
	private List<Animal> animals = new ArrayList<Animal>();
	
	/**  
	 * A ZooTile osztály StepOn metódusa. Ez a függvény azt a szituációt reprezentálja, amikor egy állat rá szeretne lépni erre a mezõre.
	 * @param animal - Egy Animal objektum, amely rá szeretne lépni erre a mezõre.
	 * @return void
	 */
	@Override
	public void StepOn(Animal animal) {
		if(animal.SteppedOn(this)) {
			animals.add(animal);
		}	
	}

	/**  
	 * A ZooTile osztály GetWayIn metódusa. A wayIn attribútum getter függvénye.
	 * Tulajdonképpen a pályára vezetõ mezõt adja meg.
	 * @param - Ennek a függvénynek nincsen paramétere
	 * @return wayIn - wayIn attribútum
	 */
	public Tile GetWayIn() {
		return wayIn;
	}
	
	/**  
	 * A ZooTile osztály SetWayIn metódusa. A wayIn attribútum setter függvénye.
	 * Tulajdonképpen a pályára vezetõ mezõt lehet vele beállítani.
	 * @param tile - a mezõ, ami a bejáratot adja majd meg
	 * @return void
	 */
	public void SetWayIn (Tile tile) {
		wayIn = tile;	
	}
	
	/**  
	 * A ZooTile osztály StepOff metódusa. A ZooTile mezõrõl való lelépést biztosítja.
	 * @param animal - Az éppen lelépni szándékozó Animal objektum.
	 * @return void
	 */
	public void StepOff(Animal animal) {
		animals.remove(animal);	
	}
}
