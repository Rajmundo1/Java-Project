package gunpowder_plot;
import java.util.List;
import java.util.ArrayList;

/**  
 * Level oszt�ly.
 * Ez az oszt�ly felel�s a p�lya inicializ�l�s�rt, valamint az id�z�t�s�rt, tov�bb� a j�t�k v�g��rt. 
 */
public class Level {
	/**
	 * J�t�kban r�szt vev� feliratkozott objektumok list�ja.
	 */
	private List<ITimed> subscribers = new ArrayList<ITimed>();
	/**
	 * Pand�k nyilv�ntart�sa.
	 */
	private Registry pandaRegistry;
	/**
	 * Or�ngut�nok nyilv�ntart�sa.
	 */
	private Registry orangutanRegistry; 
	/**
	 * J�t�k v�ge.
	 */
	private boolean endOfGame = false;
	
	/**
	 * Level oszt�ly konstruktora.
	 * @param pRegistry - Registry t�pus.
	 * @param oRegistry - Registry t�pus.
	 */
	public Level(Registry pRegistry, Registry oRegistry) {
		pandaRegistry = pRegistry;
		orangutanRegistry = oRegistry;
	}

	/**
	 * Hozz�ad egy id�z�thet� objektumot az id�z�tend� objektumok list�j�hoz.
	 * @param sub - ITimed t�pus.
	 * @return - void.
	 */
	public void addSubscriber(ITimed sub) {
		subscribers.add(sub);
	}
	
	/**  
	 * Minden feliratkozott objektum tick f�ggv�ny�nek h�v�s�val seg�ti az id�z�t�seket.
	 */
	public void SendTick() { 
		if(!endOfGame)
			for (ITimed item : subscribers)
				item.Tick();
	}
	
	/**  
	 * Ez a f�ggv�ny felel�s a j�t�k v�g��rt, �s a pontok lek�rdez�s��rt.
	 */
	public void End() { 	
		endOfGame = true;
	}
	
	/**
	 * A Level oszt�ly GetEndOfGame f�ggv�nye, mely visszaadja, hogy a j�t�k v�ge bek�vetkezett m�r vagy sem.
	 * @return endOfGame - boolean t�pus.
	 */
	public boolean GetEndOfGame() {
		return endOfGame;
	}
	
	/**
	 * A Level oszt�ly GetPoints f�ggv�nye, mely visszaadja, hogy a j�t�k sor�n mennyi pontot gy�jt�tt�nk �ssze.
	 * @return - int t�pus.
	 */
	public int GetPoints() {
		return (orangutanRegistry.GetPoints() + pandaRegistry.GetPoints());
	}
}
