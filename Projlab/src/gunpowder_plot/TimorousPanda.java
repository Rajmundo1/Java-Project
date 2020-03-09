package gunpowder_plot;

/**  
 * TimorousPanda osztály.
 * A Panda osztályból származik.
 * Ez az osztály felelõs az ijedõs panda reprezentálásáért. 
 */
public class TimorousPanda extends Panda{
	/**
	 * TimorousPanda konstruktor.
	 * @param r - Registry típus, megadja hogy a Panda melyik Registryhez tartozzon.
	 */
	public TimorousPanda(Registry r) {
		registry = r;
		registry.Add();
	}
	
	/**  
	 * A TimorousPanda osztály Stimulate metódusa. Ez a függvény reprezentálja azt az esetet, amikor az ijedõs panda megijed az játékgép csilingelésétõl.
	 * Amikor megijed, akkor elengedi a mögötte álló panda kezét.
	 * @param tile - SlotMachineTile típusú mezõ
	 * @return void
	 */
	public void Stimulate (SlotMachineTile tile) {
		BreakChain(this);	
	}
}
