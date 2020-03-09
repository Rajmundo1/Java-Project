package gunpowder_plot;
import java.util.ArrayList;

/**  
 * EntryTile oszt�ly.
 * A Tile �soszt�lyb�l sz�rmazik.
 * Ez az oszt�ly felel�s a bel�p� mez� reprezent�l�s��rt. 
 */
public class EntryTile extends Tile{
	/**
	 * Egy v�rakoz�si sor az �llatoknak, mert egyszerre csak egy �llat lehet a mez�n.
	 */
	private ArrayList<Animal> queue = new ArrayList<Animal>();
	
	/**  
	 * Az EntryTile oszt�ly StepOn met�dusa. Ez a f�ggv�ny azt a szitu�ci�t reprezent�lja, amikor egy �llat r� szeretne l�pni erre a mez�re.
	 * @param animal - Egy Animal objektum, amely r� szeretne l�pni erre a mez�re.
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
	 * Az EntryTile oszt�ly JoinQueue met�dusa. Ez a f�ggv�ny adja hozz� az �llatot az EntryTile v�rakoz�si sor�hoz.
	 * @param animal - Animal t�pus� objektum.
	 * @return void
	 */
	public void JoinQueue(Animal animal) {
		queue.add(animal);	
	}
}
