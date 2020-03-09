package gunpowder_plot;
import java.util.List;
import java.util.ArrayList;

/**  
 * Level osztály.
 * Ez az osztály felelõs a pálya inicializálásért, valamint az idõzítésért, továbbá a játék végéért. 
 */
public class Level {
	/**
	 * Játékban részt vevõ feliratkozott objektumok listája.
	 */
	private List<ITimed> subscribers = new ArrayList<ITimed>();
	/**
	 * Pandák nyilvántartása.
	 */
	private Registry pandaRegistry;
	/**
	 * Orángutánok nyilvántartása.
	 */
	private Registry orangutanRegistry; 
	/**
	 * Játék vége.
	 */
	private boolean endOfGame = false;
	
	/**
	 * Level osztály konstruktora.
	 * @param pRegistry - Registry típus.
	 * @param oRegistry - Registry típus.
	 */
	public Level(Registry pRegistry, Registry oRegistry) {
		pandaRegistry = pRegistry;
		orangutanRegistry = oRegistry;
	}

	/**
	 * Hozzáad egy idõzíthetõ objektumot az idõzítendõ objektumok listájához.
	 * @param sub - ITimed típus.
	 * @return - void.
	 */
	public void addSubscriber(ITimed sub) {
		subscribers.add(sub);
	}
	
	/**  
	 * Minden feliratkozott objektum tick függvényének hívásával segíti az idõzítéseket.
	 */
	public void SendTick() { 
		if(!endOfGame)
			for (ITimed item : subscribers)
				item.Tick();
	}
	
	/**  
	 * Ez a függvény felelõs a játék végéért, és a pontok lekérdezéséért.
	 */
	public void End() { 	
		endOfGame = true;
	}
	
	/**
	 * A Level osztály GetEndOfGame függvénye, mely visszaadja, hogy a játék vége bekövetkezett már vagy sem.
	 * @return endOfGame - boolean típus.
	 */
	public boolean GetEndOfGame() {
		return endOfGame;
	}
	
	/**
	 * A Level osztály GetPoints függvénye, mely visszaadja, hogy a játék során mennyi pontot gyûjtöttünk össze.
	 * @return - int típus.
	 */
	public int GetPoints() {
		return (orangutanRegistry.GetPoints() + pandaRegistry.GetPoints());
	}
}
