package gunpowder_plot;

/**  
 * DefatigablePanda oszt�ly.
 * A Panda oszt�lyb�l sz�rmazik.
 * Ez az oszt�ly felel�s a f�rad�kony panda reprezent�l�s��rt. 
 */
public class DefatigablePanda extends Panda {
	/**
	 * Megadja, hogy a panda kipihent �llapotban van-e.
	 */
	private boolean rested; 
	/**
	 * Megadja, hogy a panda �ppen pihen-e.
	 */
	private boolean resting;
	
	public DefatigablePanda(Registry r) {
		registry = r;
		registry.Add();
	}
	
	/**  
	 * A DefatigablePanda oszt�ly Stimulate met�dusa. Ez a f�ggv�ny reprezent�lja azt az esetet, amikor egy fotel hat egy f�rad�kony pand�ra.
	 * Figyelembe kell venni azokat az eseteket, amikor a panda �ppen pihen, vagy kipihent �llapotban van.
	 * @param tile - ArmchairTile t�pus� mez�
	 * @return void
	 */
	public void Stimulate (ArmchairTile tile) {
		if (!rested && !resting) {
			tile.StepOn(this);
		}	
	}
	
	
	/**  
	 * A DefatigablePanda oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy DefatigablePanda r�l�pett-e egy ArmchairTile mez�re.
	 * Amennyiben a panda l�ncban volt, akkor a fotel mez�re l�p�s hat�s�ra a l�nca felbomlik.
	 * @param tile - ArmchairTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	public boolean SteppedOn(ArmchairTile tile) {
		boolean willStep = !rested && !resting;
		if(willStep) {
			this.tile.StepOff(this);
			BreakChain(this);
			this.tile = tile;
			resting = true;
		}
		return willStep;
	}
	
	/**  
	 * A DefatigablePanda oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy DefatigablePanda r�l�pett-e egy NormalTile mez�re.
	 * A mez� foglalt is lehet. Ilyenkor k�t �llat tal�lkozik, �s a megfelel� Meet f�ggv�ny h�v�dik.
	 * @param tile - NormalTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	public boolean SteppedOn(NormalTile tile) {
		return TakeStep(tile);
	}
	
	/**  
	 * A DefatigablePanda oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy DefatigablePanda r�l�pett-e egy DefatigablePanda mez�re.
	 * A mez� foglalt is lehet. Ilyenkor k�t �llat tal�lkozik, �s a megfelel� Meet f�ggv�ny h�v�dik.
	 * @param tile - BrittleTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	public boolean SteppedOn(BrittleTile tile) {
		return TakeStep(tile);
	}
	
	/**
	 * A DefatigablePanda oszt�ly TakeStep met�dusa. Amellett, hogy elv�gzi a l�p�st, friss�ti a DefatigablePanda �llapot�t is.
	 * @param tile - Tile t�pus� mez�. Ide k�s�rli meg l�ptetni a pand�t.
	 * @return boolean - siker�lt, vagy nem.
	 */
	private boolean TakeStep(Tile tile) {
		boolean stepSuccessful = SteppedOnTile(tile);
		
		if(stepSuccessful) {
			if(resting) {
				rested = true;
				resting = false;
			}
			else if(rested) {
				rested = false;
			}
		}
		
		return stepSuccessful;
	}
}
