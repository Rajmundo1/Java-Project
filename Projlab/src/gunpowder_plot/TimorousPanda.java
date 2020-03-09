package gunpowder_plot;

/**  
 * TimorousPanda oszt�ly.
 * A Panda oszt�lyb�l sz�rmazik.
 * Ez az oszt�ly felel�s az ijed�s panda reprezent�l�s��rt. 
 */
public class TimorousPanda extends Panda{
	/**
	 * TimorousPanda konstruktor.
	 * @param r - Registry t�pus, megadja hogy a Panda melyik Registryhez tartozzon.
	 */
	public TimorousPanda(Registry r) {
		registry = r;
		registry.Add();
	}
	
	/**  
	 * A TimorousPanda oszt�ly Stimulate met�dusa. Ez a f�ggv�ny reprezent�lja azt az esetet, amikor az ijed�s panda megijed az j�t�kg�p csilingel�s�t�l.
	 * Amikor megijed, akkor elengedi a m�g�tte �ll� panda kez�t.
	 * @param tile - SlotMachineTile t�pus� mez�
	 * @return void
	 */
	public void Stimulate (SlotMachineTile tile) {
		BreakChain(this);	
	}
}
