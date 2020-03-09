package gunpowder_plot;

/**  
 * Absztrakt MachineTile osztály.
 * A Tile õsosztályból származik.
 * Ez az osztály felelõs a gép mezõk reprezentálásáért. 
 */
public abstract class MachineTile extends Tile {

	/**  
	 * A MachineTile osztály StepOn metódusa. Ez a függvény azt a szituációt reprezentálja, amikor egy állat rá szeretne lépni erre a mezõre.
	 * @param animal - Egy Animal objektum, amely rá szeretne lépni erre a mezõre.
	 * @return void
	 */
	public void StepOn(Animal animal) {
		if(animal.SteppedOn(this))
			occupant = animal;
	}
	/**
	 * Az MachineTile osztály toString metódusa. Ez a függvény meghívja a Tile osztály toStrig metódusát. 
	 * @param - Ennek a függvénynek nincsen paramétere.
	 * @return String - kiírandó szöveg.
	 */
	public String toString() {
		return super.toString();
	}
}
