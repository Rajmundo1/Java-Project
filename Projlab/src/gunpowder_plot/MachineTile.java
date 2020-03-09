package gunpowder_plot;

/**  
 * Absztrakt MachineTile oszt�ly.
 * A Tile �soszt�lyb�l sz�rmazik.
 * Ez az oszt�ly felel�s a g�p mez�k reprezent�l�s��rt. 
 */
public abstract class MachineTile extends Tile {

	/**  
	 * A MachineTile oszt�ly StepOn met�dusa. Ez a f�ggv�ny azt a szitu�ci�t reprezent�lja, amikor egy �llat r� szeretne l�pni erre a mez�re.
	 * @param animal - Egy Animal objektum, amely r� szeretne l�pni erre a mez�re.
	 * @return void
	 */
	public void StepOn(Animal animal) {
		if(animal.SteppedOn(this))
			occupant = animal;
	}
	/**
	 * Az MachineTile oszt�ly toString met�dusa. Ez a f�ggv�ny megh�vja a Tile oszt�ly toStrig met�dus�t. 
	 * @param - Ennek a f�ggv�nynek nincsen param�tere.
	 * @return String - ki�rand� sz�veg.
	 */
	public String toString() {
		return super.toString();
	}
}
