package gunpowder_plot;
/**  
 * Abasztrakt Animal oszt�ly.
 * Implement�lja az ITimed interf�szt.
 * Minden �llat �soszt�lya. 
 */
public abstract class Animal implements ITimed{
	
	/**
	 * boolean t�pus� v�ltoz�, mely megmondja, hogy az �llat �letben van-e.
	 */
	protected boolean alive = true; 
	/**
	 * Registry t�pus� v�ltoz�, amely a nyilv�ntart�s fontos eleme.
	 */
	protected Registry registry;
	/**
	 * A mez�, amelyen az �llat �ll.
	 */
	protected Tile tile = null;
	
	/**  
	 * Az Animal oszt�ly absztrakt Tick met�dusa. Id�z�t�sben van szerepe.
	 * R�szletesen a lesz�rmazottakban van kifejtve.
	 * @param - Nincsen param�tere.
	 * @return void
	 */
	public abstract void Tick();
	
	/**  
	 * Az Animal oszt�ly absztrakt StepTo met�dusa. Mez�re l�p�st biztos�t.
	 * R�szletesen a lesz�rmazottakban van kifejtve.
	 * @param tile - Tile t�pus� mez�.
	 * @return void
	 */
	public abstract void StepTo(Tile tile);
	
	/**  
	 * Az Animal oszt�ly absztrakt BreakChain met�dusa. L�nc megszak�t�s�ra szolg�l.
	 * R�szletesen a lesz�rmazottakban van kifejtve.
	 * @param deserter - Animal t�pus� objektum, amely a l�ncot megszak�tja.
	 * @return void
	 */
	public abstract void BreakChain(Animal deserter);
	
	/**  
	 * Az Animal oszt�ly absztrakt Fall met�dusa. Az �llat lezuhan�s�t biztos�tja.
	 * R�szletesen a lesz�rmazottakban van kifejtve.
	 * @param - Nincsen param�tere.
	 * @return void
	 */
	public abstract void Fall();
	
	/**  
	 * Az Animal oszt�ly absztrakt Meet met�dusa. K�t �llat tal�lkoz�s�t reprezent�lja.
	 * R�szletesen a lesz�rmazottakban van kifejtve.
	 * @param animal - A m�sik �llat.
	 * @return boolean - �tadta-e a hely�t. (helycsere)
	 */
	public abstract boolean Meet (Animal animal);
	
	/**  
	 * Az Animal oszt�ly absztrakt Meet met�dusa. �llat tal�lkoz�s�t reprezent�lja Pand�val.
	 * R�szletesen a lesz�rmazottakban van kifejtve.
	 * @param panda - Panda t�pus� objektum, akivel az �llat tal�lkozik.
	 * @return void
	 */
	public abstract void Meet (Panda panda);
	
	/**  
	 * Az Animal oszt�ly absztrakt Meet met�dusa. �llat tal�lkoz�s�t reprezent�lja Or�ngut�nnal.
	 * R�szletesen a lesz�rmazottakban van kifejtve.
	 * @param orangutan - Orangutan t�pus� objektum, akivel az �llat tal�lkozik.
	 * @return void
	 */
	public abstract void Meet (Orangutan orangutan);
	
	
	/**  
	 * Az Animal oszt�ly Stimulate met�dusa. Ez a f�ggv�ny reprezent�lja azt az esetet, amikor egy j�t�kg�p hat egy �llatra.
	 * @param tile - SlotMachineTile t�pus� mez�
	 * @return void
	 */
	public void Stimulate (SlotMachineTile tile) { }

	/**  
	 * Az Animal oszt�ly Stimulate met�dusa. Ez a f�ggv�ny reprezent�lja azt az esetet, amikor egy csokiautomata hat egy �llatra.
	 * @param tile - VendingMachineTile t�pus� mez�
	 * @return void
	 */
	public void Stimulate (VendingMachineTile tile) { }
	
	/**  
	 * Az Animal oszt�ly Stimulate met�dusa. Ez a f�ggv�ny reprezent�lja azt az esetet, amikor egy fotel hat egy �llatra.
	 * @param tile - ArmchairTile t�pus� mez�
	 * @return void
	 */
	public void Stimulate (ArmchairTile tile) { }
	
	/**  
	 * Az Animal oszt�ly absztrakt SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Animal r�l�pett-e egy NormalTile mez�re.
	 * @param tile - NormalTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	public abstract boolean SteppedOn (NormalTile tile);
	
	/**  
	 * Az Animal oszt�ly absztrakt SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Animal r�l�pett-e egy BrittleTile mez�re.
	 * @param tile - BrittleTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	public abstract boolean SteppedOn (BrittleTile tile);
	
	/**  
	 * Az Animal oszt�ly absztrakt SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Animal r�l�pett-e egy EntryTile mez�re.
	 * @param tile - EntryTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	public abstract boolean SteppedOn (EntryTile tile);
	
	/**  
	 * Az Animal oszt�ly absztrakt SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Animal r�l�pett-e egy ExitTile mez�re.
	 * @param tile - ExitTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	public abstract boolean SteppedOn (ExitTile tile);
	
	/**  
	 * Az Animal oszt�ly absztrakt SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Animal r�l�pett-e egy ZooTile mez�re.
	 * @param tile - ZooTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	public abstract boolean SteppedOn (ZooTile tile);
	
	/**  
	 * Az Animal oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy �llat r�l�pett-e egy MachineTile mez�re.
	 * @param tile - MachineTile t�pus� mez�
	 * @return boolean - siker�lt, vagy nem.
	 */
	public  boolean SteppedOn (MachineTile tile) {
		return false;
	}
	
	/**  
	 * Az Animal oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy �llat r�l�pett-e egy ArmchairTile mez�re.
	 * @param tile - ArmchairTile t�pus� mez�
	 * @return boolean - siker�lt, vagy nem.
	 */
	public  boolean SteppedOn (ArmchairTile tile) { 
		return false;
	}

	/**
	 * Az Animal oszt�ly GetTile f�ggv�nye, mely visszaadja, hogy melyik csemp�n (ha van ilyen) �ll az �llat.
	 * @return tile - Tile t�pus, az �llat itt �ll.
	 */
	public Tile GetTile() {
		return tile;
	}
	
}
