package gunpowder_plot;

/**  
 * ExitTile osztály.
 * A Tile õsosztályból származik.
 * Ez az osztály felelõs a kilépõ mezõ reprezentálásáért. 
 */
public class ExitTile extends Tile{
	/**
	 * A kilépõ mezõ.
	 */
	private Tile wayOut;
	
	/**  
	 * Az ExitTile osztály GetWayOut metódusa. A wayOut attribútum getter függvénye.
	 * Tulajdonképpen a pályáról való kiutat adja meg.
	 * @param - Ennek a függvénynek nincsen paramétere
	 * @return wayOut - wayOut attribútum
	 */
	public Tile GetWayOut() {
		return wayOut;
	}
	
	
	/**  
	 * Az ExitTile osztály SetWayOut metódusa. A wayOut attribútum setter függvénye.
	 * Tulajdonképpen a pályáról való kiutat lehet vele beállítani.
	 * @param tile - a mezõ, ami a kijáratot adja majd meg
	 * @return void
	 */
	public void SetWayOut(Tile tile) {
		wayOut = tile;	
	}
	
	
	/**  
	 * Az ExitTile osztály StepOn metódusa. Ez a függvény azt a szituációt reprezentálja, amikor egy állat rá szeretne lépni erre a mezõre.
	 * @param animal - Egy Animal objektum, amely rá szeretne lépni erre a mezõre.
	 * @return void
	 */
	@Override
	public void StepOn(Animal animal) {
		if(animal.SteppedOn(this))
			occupant = animal;
	}
}
