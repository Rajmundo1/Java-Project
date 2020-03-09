package gunpowder_plot;
import java.util.ArrayList;

/**  
 * Abasztrakt Tile osztály.
 * Implementálja az ITimed interfészt.
 * Minden mezõ õsosztálya. 
 */
public abstract class Tile implements ITimed {
	/**
	 * A mezõt elfoglaló állat.
	 */
	protected Animal occupant = null;
	/**
	 * A mezõ szomszédainak listája.
	 */
	protected ArrayList<Tile> neighbors = new ArrayList<Tile>();
	
	/**  
	 * Az Tile absztrakt osztály Tick metódusa. Ez a függvény felel a mezõkön történõ idõzítésekért.
	 * @param - Nincs paramétere.
	 * @return void
	 */
	public void Tick() { }
	
	/**  
	 * Az Tile absztrakt osztály GetNeighbors metódusa. Egy mezõ szomszédait lehet vele lekérdezni
	 * @param - Nincs paramétere.
	 * @return neighbors - a szomszédokat tartalmazõ lista attribútum.
	 */
	public ArrayList<Tile> GetNeighbors() {
		return neighbors;
	}
	
	/**  
	 * Az Tile absztrakt osztály SetNeighbors metódusa. Egy mezõ szomszédait lehet vele beállítani.
	 * @param neighbors - egy szomszédot tartalmazó lista.
	 * @return void
	 */
	public void SetNeighbors (ArrayList<Tile> neighbors) {
		this.neighbors = neighbors;	
	}
	
	/**  
	 * Az Tile absztrakt osztály GetOccupant metódusa. Egy adott mezõt elfoglaló állat lekérdezésére szolgál.
	 * @param - Nincs paramétere.
	 * @return occupant - az adott mezõn álló állat.
	 */
	public Animal GetOccupant() {
		return occupant;
	}
	
	/**  
	 * Az Tile absztrakt osztály absztrakt StepOn metódusa.
	 * Részletesen a leszármazottakban van kifejtve.
	 * @param animal - A mezõre lépni kívánó állat.
	 * @return void
	 */
	public abstract void StepOn(Animal animal);
	
	/**  
	 * Az Tile absztrakt osztály StepOff metódusa. A mezõrõl való lelépést biztosítja.
	 * @param animal - A mezõrõl lelépni kívánó állat.
	 * @return void
	 */
	public void StepOff(Animal animal) {
		occupant = null;	
	}
	
	/**  
	 * Az Tile absztrakt osztály JumpOn metódusa. A mezõn való ugrást biztosítja.
	 * @param - Nincs paramétere.
	 * @return void
	 */
	public void JumpOn() { }
}
