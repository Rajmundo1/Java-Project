package gunpowder_plot;
import java.util.ArrayList;
import java.util.List;

/**  
 * ZooTile oszt�ly.
 * A Tile �soszt�lyb�l sz�rmazik.
 * Ez az oszt�ly felel�s az �llatkert mez� reprezent�l�s��rt. 
 */
public class ZooTile extends Tile{
	/**
	 * Bel�p� mez�.
	 */
	private Tile wayIn;
	/**
	 * �llatok list�ja.
	 */
	private List<Animal> animals = new ArrayList<Animal>();
	
	/**  
	 * A ZooTile oszt�ly StepOn met�dusa. Ez a f�ggv�ny azt a szitu�ci�t reprezent�lja, amikor egy �llat r� szeretne l�pni erre a mez�re.
	 * @param animal - Egy Animal objektum, amely r� szeretne l�pni erre a mez�re.
	 * @return void
	 */
	@Override
	public void StepOn(Animal animal) {
		if(animal.SteppedOn(this)) {
			animals.add(animal);
		}	
	}

	/**  
	 * A ZooTile oszt�ly GetWayIn met�dusa. A wayIn attrib�tum getter f�ggv�nye.
	 * Tulajdonk�ppen a p�ly�ra vezet� mez�t adja meg.
	 * @param - Ennek a f�ggv�nynek nincsen param�tere
	 * @return wayIn - wayIn attrib�tum
	 */
	public Tile GetWayIn() {
		return wayIn;
	}
	
	/**  
	 * A ZooTile oszt�ly SetWayIn met�dusa. A wayIn attrib�tum setter f�ggv�nye.
	 * Tulajdonk�ppen a p�ly�ra vezet� mez�t lehet vele be�ll�tani.
	 * @param tile - a mez�, ami a bej�ratot adja majd meg
	 * @return void
	 */
	public void SetWayIn (Tile tile) {
		wayIn = tile;	
	}
	
	/**  
	 * A ZooTile oszt�ly StepOff met�dusa. A ZooTile mez�r�l val� lel�p�st biztos�tja.
	 * @param animal - Az �ppen lel�pni sz�nd�koz� Animal objektum.
	 * @return void
	 */
	public void StepOff(Animal animal) {
		animals.remove(animal);	
	}
}
