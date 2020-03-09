package gunpowder_plot;
/**  
 * Abasztrakt Animal osztály.
 * Implementálja az ITimed interfészt.
 * Minden állat õsosztálya. 
 */
public abstract class Animal implements ITimed{
	
	/**
	 * boolean típusú változó, mely megmondja, hogy az állat életben van-e.
	 */
	protected boolean alive = true; 
	/**
	 * Registry típusú változó, amely a nyilvántartás fontos eleme.
	 */
	protected Registry registry;
	/**
	 * A mezõ, amelyen az állat áll.
	 */
	protected Tile tile = null;
	
	/**  
	 * Az Animal osztály absztrakt Tick metódusa. Idõzítésben van szerepe.
	 * Részletesen a leszármazottakban van kifejtve.
	 * @param - Nincsen paramétere.
	 * @return void
	 */
	public abstract void Tick();
	
	/**  
	 * Az Animal osztály absztrakt StepTo metódusa. Mezõre lépést biztosít.
	 * Részletesen a leszármazottakban van kifejtve.
	 * @param tile - Tile típusú mezõ.
	 * @return void
	 */
	public abstract void StepTo(Tile tile);
	
	/**  
	 * Az Animal osztály absztrakt BreakChain metódusa. Lánc megszakítására szolgál.
	 * Részletesen a leszármazottakban van kifejtve.
	 * @param deserter - Animal típusú objektum, amely a láncot megszakítja.
	 * @return void
	 */
	public abstract void BreakChain(Animal deserter);
	
	/**  
	 * Az Animal osztály absztrakt Fall metódusa. Az állat lezuhanását biztosítja.
	 * Részletesen a leszármazottakban van kifejtve.
	 * @param - Nincsen paramétere.
	 * @return void
	 */
	public abstract void Fall();
	
	/**  
	 * Az Animal osztály absztrakt Meet metódusa. Két állat találkozását reprezentálja.
	 * Részletesen a leszármazottakban van kifejtve.
	 * @param animal - A másik állat.
	 * @return boolean - Átadta-e a helyét. (helycsere)
	 */
	public abstract boolean Meet (Animal animal);
	
	/**  
	 * Az Animal osztály absztrakt Meet metódusa. Állat találkozását reprezentálja Pandával.
	 * Részletesen a leszármazottakban van kifejtve.
	 * @param panda - Panda típusú objektum, akivel az állat találkozik.
	 * @return void
	 */
	public abstract void Meet (Panda panda);
	
	/**  
	 * Az Animal osztály absztrakt Meet metódusa. Állat találkozását reprezentálja Orángutánnal.
	 * Részletesen a leszármazottakban van kifejtve.
	 * @param orangutan - Orangutan típusú objektum, akivel az állat találkozik.
	 * @return void
	 */
	public abstract void Meet (Orangutan orangutan);
	
	
	/**  
	 * Az Animal osztály Stimulate metódusa. Ez a függvény reprezentálja azt az esetet, amikor egy játékgép hat egy állatra.
	 * @param tile - SlotMachineTile típusú mezõ
	 * @return void
	 */
	public void Stimulate (SlotMachineTile tile) { }

	/**  
	 * Az Animal osztály Stimulate metódusa. Ez a függvény reprezentálja azt az esetet, amikor egy csokiautomata hat egy állatra.
	 * @param tile - VendingMachineTile típusú mezõ
	 * @return void
	 */
	public void Stimulate (VendingMachineTile tile) { }
	
	/**  
	 * Az Animal osztály Stimulate metódusa. Ez a függvény reprezentálja azt az esetet, amikor egy fotel hat egy állatra.
	 * @param tile - ArmchairTile típusú mezõ
	 * @return void
	 */
	public void Stimulate (ArmchairTile tile) { }
	
	/**  
	 * Az Animal osztály absztrakt SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Animal rálépett-e egy NormalTile mezõre.
	 * @param tile - NormalTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	public abstract boolean SteppedOn (NormalTile tile);
	
	/**  
	 * Az Animal osztály absztrakt SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Animal rálépett-e egy BrittleTile mezõre.
	 * @param tile - BrittleTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	public abstract boolean SteppedOn (BrittleTile tile);
	
	/**  
	 * Az Animal osztály absztrakt SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Animal rálépett-e egy EntryTile mezõre.
	 * @param tile - EntryTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	public abstract boolean SteppedOn (EntryTile tile);
	
	/**  
	 * Az Animal osztály absztrakt SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Animal rálépett-e egy ExitTile mezõre.
	 * @param tile - ExitTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	public abstract boolean SteppedOn (ExitTile tile);
	
	/**  
	 * Az Animal osztály absztrakt SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Animal rálépett-e egy ZooTile mezõre.
	 * @param tile - ZooTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	public abstract boolean SteppedOn (ZooTile tile);
	
	/**  
	 * Az Animal osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy állat rálépett-e egy MachineTile mezõre.
	 * @param tile - MachineTile típusú mezõ
	 * @return boolean - sikerült, vagy nem.
	 */
	public  boolean SteppedOn (MachineTile tile) {
		return false;
	}
	
	/**  
	 * Az Animal osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy állat rálépett-e egy ArmchairTile mezõre.
	 * @param tile - ArmchairTile típusú mezõ
	 * @return boolean - sikerült, vagy nem.
	 */
	public  boolean SteppedOn (ArmchairTile tile) { 
		return false;
	}

	/**
	 * Az Animal osztály GetTile függvénye, mely visszaadja, hogy melyik csempén (ha van ilyen) áll az állat.
	 * @return tile - Tile típus, az állat itt áll.
	 */
	public Tile GetTile() {
		return tile;
	}
	
}
