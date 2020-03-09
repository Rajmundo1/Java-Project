package gunpowder_plot;

/**  
 * ExitTile oszt�ly.
 * A Tile �soszt�lyb�l sz�rmazik.
 * Ez az oszt�ly felel�s a kil�p� mez� reprezent�l�s��rt. 
 */
public class ExitTile extends Tile{
	/**
	 * A kil�p� mez�.
	 */
	private Tile wayOut;
	
	/**  
	 * Az ExitTile oszt�ly GetWayOut met�dusa. A wayOut attrib�tum getter f�ggv�nye.
	 * Tulajdonk�ppen a p�ly�r�l val� kiutat adja meg.
	 * @param - Ennek a f�ggv�nynek nincsen param�tere
	 * @return wayOut - wayOut attrib�tum
	 */
	public Tile GetWayOut() {
		return wayOut;
	}
	
	
	/**  
	 * Az ExitTile oszt�ly SetWayOut met�dusa. A wayOut attrib�tum setter f�ggv�nye.
	 * Tulajdonk�ppen a p�ly�r�l val� kiutat lehet vele be�ll�tani.
	 * @param tile - a mez�, ami a kij�ratot adja majd meg
	 * @return void
	 */
	public void SetWayOut(Tile tile) {
		wayOut = tile;	
	}
	
	
	/**  
	 * Az ExitTile oszt�ly StepOn met�dusa. Ez a f�ggv�ny azt a szitu�ci�t reprezent�lja, amikor egy �llat r� szeretne l�pni erre a mez�re.
	 * @param animal - Egy Animal objektum, amely r� szeretne l�pni erre a mez�re.
	 * @return void
	 */
	@Override
	public void StepOn(Animal animal) {
		if(animal.SteppedOn(this))
			occupant = animal;
	}
}
