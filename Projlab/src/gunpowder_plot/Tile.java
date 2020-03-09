package gunpowder_plot;
import java.util.ArrayList;

/**  
 * Abasztrakt Tile oszt�ly.
 * Implement�lja az ITimed interf�szt.
 * Minden mez� �soszt�lya. 
 */
public abstract class Tile implements ITimed {
	/**
	 * A mez�t elfoglal� �llat.
	 */
	protected Animal occupant = null;
	/**
	 * A mez� szomsz�dainak list�ja.
	 */
	protected ArrayList<Tile> neighbors = new ArrayList<Tile>();
	
	/**  
	 * Az Tile absztrakt oszt�ly Tick met�dusa. Ez a f�ggv�ny felel a mez�k�n t�rt�n� id�z�t�sek�rt.
	 * @param - Nincs param�tere.
	 * @return void
	 */
	public void Tick() { }
	
	/**  
	 * Az Tile absztrakt oszt�ly GetNeighbors met�dusa. Egy mez� szomsz�dait lehet vele lek�rdezni
	 * @param - Nincs param�tere.
	 * @return neighbors - a szomsz�dokat tartalmaz� lista attrib�tum.
	 */
	public ArrayList<Tile> GetNeighbors() {
		return neighbors;
	}
	
	/**  
	 * Az Tile absztrakt oszt�ly SetNeighbors met�dusa. Egy mez� szomsz�dait lehet vele be�ll�tani.
	 * @param neighbors - egy szomsz�dot tartalmaz� lista.
	 * @return void
	 */
	public void SetNeighbors (ArrayList<Tile> neighbors) {
		this.neighbors = neighbors;	
	}
	
	/**  
	 * Az Tile absztrakt oszt�ly GetOccupant met�dusa. Egy adott mez�t elfoglal� �llat lek�rdez�s�re szolg�l.
	 * @param - Nincs param�tere.
	 * @return occupant - az adott mez�n �ll� �llat.
	 */
	public Animal GetOccupant() {
		return occupant;
	}
	
	/**  
	 * Az Tile absztrakt oszt�ly absztrakt StepOn met�dusa.
	 * R�szletesen a lesz�rmazottakban van kifejtve.
	 * @param animal - A mez�re l�pni k�v�n� �llat.
	 * @return void
	 */
	public abstract void StepOn(Animal animal);
	
	/**  
	 * Az Tile absztrakt oszt�ly StepOff met�dusa. A mez�r�l val� lel�p�st biztos�tja.
	 * @param animal - A mez�r�l lel�pni k�v�n� �llat.
	 * @return void
	 */
	public void StepOff(Animal animal) {
		occupant = null;	
	}
	
	/**  
	 * Az Tile absztrakt oszt�ly JumpOn met�dusa. A mez�n val� ugr�st biztos�tja.
	 * @param - Nincs param�tere.
	 * @return void
	 */
	public void JumpOn() { }
}
