package gunpowder_plot;

/**  
 * NormalTile osztály.
 * A Tile õsosztályból származik.
 * Ez az osztály felelõs a közönséges mezõk reprezentálásáért.  
 */
public class NormalTile extends Tile {

	/**  
	 * A NormalTile osztály StepOn metódusa. Ez a függvény azt a szituációt reprezentálja, amikor egy állat rá szeretne lépni erre a mezõre.
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
