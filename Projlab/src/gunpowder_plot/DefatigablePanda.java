package gunpowder_plot;

/**  
 * DefatigablePanda osztály.
 * A Panda osztályból származik.
 * Ez az osztály felelõs a fáradékony panda reprezentálásáért. 
 */
public class DefatigablePanda extends Panda {
	/**
	 * Megadja, hogy a panda kipihent állapotban van-e.
	 */
	private boolean rested; 
	/**
	 * Megadja, hogy a panda éppen pihen-e.
	 */
	private boolean resting;
	
	public DefatigablePanda(Registry r) {
		registry = r;
		registry.Add();
	}
	
	/**  
	 * A DefatigablePanda osztály Stimulate metódusa. Ez a függvény reprezentálja azt az esetet, amikor egy fotel hat egy fáradékony pandára.
	 * Figyelembe kell venni azokat az eseteket, amikor a panda éppen pihen, vagy kipihent állapotban van.
	 * @param tile - ArmchairTile típusú mezõ
	 * @return void
	 */
	public void Stimulate (ArmchairTile tile) {
		if (!rested && !resting) {
			tile.StepOn(this);
		}	
	}
	
	
	/**  
	 * A DefatigablePanda osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy DefatigablePanda rálépett-e egy ArmchairTile mezõre.
	 * Amennyiben a panda láncban volt, akkor a fotel mezõre lépés hatására a lánca felbomlik.
	 * @param tile - ArmchairTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
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
	 * A DefatigablePanda osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy DefatigablePanda rálépett-e egy NormalTile mezõre.
	 * A mezõ foglalt is lehet. Ilyenkor két állat találkozik, és a megfelelõ Meet függvény hívódik.
	 * @param tile - NormalTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	public boolean SteppedOn(NormalTile tile) {
		return TakeStep(tile);
	}
	
	/**  
	 * A DefatigablePanda osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy DefatigablePanda rálépett-e egy DefatigablePanda mezõre.
	 * A mezõ foglalt is lehet. Ilyenkor két állat találkozik, és a megfelelõ Meet függvény hívódik.
	 * @param tile - BrittleTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	public boolean SteppedOn(BrittleTile tile) {
		return TakeStep(tile);
	}
	
	/**
	 * A DefatigablePanda osztály TakeStep metódusa. Amellett, hogy elvégzi a lépést, frissíti a DefatigablePanda állapotát is.
	 * @param tile - Tile típusú mezõ. Ide kísérli meg léptetni a pandát.
	 * @return boolean - sikerült, vagy nem.
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
