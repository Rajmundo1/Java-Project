package gunpowder_plot;

/**  
 * SpringingPanda oszt�ly.
 * A Panda oszt�lyb�l sz�rmazik.
 * Ez az oszt�ly felel�s az ugr�l�s panda reprezent�l�s��rt. 
 */
public class SpringingPanda extends Panda{
	/**
	 * SpringingPanda konstruktor.
	 * @param r - Registry t�pus, megadja hogy a Panda melyik Registryhez tartozzon.
	 */
	public SpringingPanda(Registry r) {
		registry = r;
		registry.Add();
	}
	
	/**  
	 * A SpringingPanda oszt�ly Stimulate met�dusa. Ez a f�ggv�ny reprezent�lja azt az esetet, amikor az ugr�l�s panda ugrik egyet az automata s�pol�s�t�l.
	 * Ennek hat�s�ra a panda ugrik egyet a mez�n.
	 * @param tile - VendingMachineTile t�pus� mez�.
	 * @return void
	 */
	public void Stimulate (VendingMachineTile tile) {
		this.tile.JumpOn();	
	}
}
