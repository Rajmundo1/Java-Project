package gunpowder_plot;

/**  
 * SpringingPanda osztály.
 * A Panda osztályból származik.
 * Ez az osztály felelõs az ugrálós panda reprezentálásáért. 
 */
public class SpringingPanda extends Panda{
	/**
	 * SpringingPanda konstruktor.
	 * @param r - Registry típus, megadja hogy a Panda melyik Registryhez tartozzon.
	 */
	public SpringingPanda(Registry r) {
		registry = r;
		registry.Add();
	}
	
	/**  
	 * A SpringingPanda osztály Stimulate metódusa. Ez a függvény reprezentálja azt az esetet, amikor az ugrálós panda ugrik egyet az automata sípolásától.
	 * Ennek hatására a panda ugrik egyet a mezõn.
	 * @param tile - VendingMachineTile típusú mezõ.
	 * @return void
	 */
	public void Stimulate (VendingMachineTile tile) {
		this.tile.JumpOn();	
	}
}
