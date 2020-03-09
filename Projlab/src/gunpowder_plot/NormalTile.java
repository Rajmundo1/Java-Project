package gunpowder_plot;

/**  
 * NormalTile oszt�ly.
 * A Tile �soszt�lyb�l sz�rmazik.
 * Ez az oszt�ly felel�s a k�z�ns�ges mez�k reprezent�l�s��rt.  
 */
public class NormalTile extends Tile {

	/**  
	 * A NormalTile oszt�ly StepOn met�dusa. Ez a f�ggv�ny azt a szitu�ci�t reprezent�lja, amikor egy �llat r� szeretne l�pni erre a mez�re.
	 * @param animal - Egy Animal objektum, amely r� szeretne l�pni erre a mez�re.
	 * @return void
	 */
	@Override
	public void StepOn(Animal animal) {
		if(animal.SteppedOn(this)) {
			occupant = animal;
		}	
	}
}
