package gunpowder_plot;
/**  
 * Orangutan oszt�ly.
 * Az Animal �soszt�lyb�l sz�rmazik.
 * Ez az oszt�ly hivatott az or�ngut�nok reprezent�l�s�ra. 
 */
public class Orangutan extends Animal {
	/**
	 * Id�z�t�shez sz�ks�ges sz�ml�l�
	 */
	private int tickCount = 2;
	/**
	 * Egy Panda t�pus� objektum, amely a l�ncban val� k�vetkez� elem. Alap�rtelmez�s szerint null.
	 */
	private Panda nextInChain = null;
	/**
	 * Orangutan �llapota. Alap�rtelmez�s szerinte Gathering - azaz gy�jt�s.
	 */
	private OrangutanState state = OrangutanState.Gathering;
	/**
	 * K�vetkez� mez�, amelyre l�pne. Alap�rtelmez�s szerint null.
	 */
	private Tile nextStep = null;
	/**
	 * A sz�ks�ges l�p�sek sz�ma, hogy az Or�ngut�n ism�t foghasson Pand�t. Alap�rtelmezett �rt�ke 3.
	 */
	private int stepsSinceChainStolen = 3;
	
	public Orangutan(Registry r) {
		registry = r;
		registry.Add();
	}
	
	/**  
	 * Az Orangutan oszt�ly Tick met�dusa. A l�ptet�sekben �s id�z�t�sben van kulcsszerepe.
	 * @param Nincs param�tere.
	 * @return void
	 */	
	public void Tick() {
		if(tickCount != Integer.MAX_VALUE)
			++tickCount;
		
		switch(state)
		{
			case Gathering:
				break;
			
			case Exiting:
				if(tickCount == 3) {
					tickCount = 0;
					nextStep.StepOn(this);
				}
				break;
				
			case Caging:
				if(nextInChain != null && tickCount == 3) {
					tickCount = 0;
					nextInChain.StepTo(tile);
					Panda nextnext = nextInChain.GetNextInChain();
					if(nextnext != null)
						nextnext.ChainNew(this);
					nextInChain.Cage();
					nextInChain = nextnext;
				}
				else if(nextInChain == null) {
					nextStep.StepOn(this);
				}
				break;
			
			case Queuing:
				nextStep.StepOn(this);
				break;
		}
	}
		
	/**  
	 * Az Orangutan oszt�ly StepTo met�dusa. Ez a f�ggv�ny felel�s az or�ngut�n l�ptet�s��rt.
	 * @param tile - Az a mez� objektum, amelyre az or�ngut�n l�pni szeretne.
	 * @return void
	 */
	@Override
	public void StepTo(Tile tile) {
		if (alive && ((state == OrangutanState.Gathering && tickCount >= 2) || stepsSinceChainStolen == 0)) { 
			if(this.tile == null || this.tile.GetNeighbors().contains(tile)) {
				tickCount = 0;
				tile.StepOn(this);
			}				
		}	
	}

	/**  
	 * Az Orangutan oszt�ly BreakChain met�dusa. Ez a f�ggv�ny felel�s az or�ngut�n l�nc�nak megszak�t�s��rt.
	 * @param deserter - az az Animal objektum, amely megszak�tja a l�ncot.
	 * @return void
	 */
	@Override
	public void BreakChain(Animal deserter) {
		if(deserter == this) {
			if(nextInChain != null) {
				nextInChain.BreakChain(deserter);
				nextInChain = null;
			}
		} 
		else if(deserter == nextInChain) {
			nextInChain = null;
		}	
		else {
			stepsSinceChainStolen = 0;
			nextInChain = null;
		}
	}

	/**  
	 * Az Orangutan oszt�ly Fall met�dusa. Ez a f�ggv�ny felel�s az or�ngut�n lezuhan�s��rt.
	 * @param - Ennek a f�ggv�nynek nincs param�tere.
	 * @return void
	 */
	@Override
	public void Fall() {
		registry.Remove();
		BreakChain(this);
		tile = null;
		alive = false;
	}

	/**  
	 * Az Orangutan oszt�ly Meet met�dusa. Ez a f�ggv�ny reprezent�lja az or�ngut�n tal�lkoz�s�t egy �llattal.
	 * @param animal - Animal objektum, amellyel az or�ngut�n tal�lkozik.
	 * @return boolean - �tadta-e a hely�t.
	 */
	@Override
	public boolean Meet(Animal animal) {
		Tile oldTile = tile;
		
		animal.Meet(this); // Itt a tile attrib�tum a l�nc elrabl�sakor megv�ltozhat.
		
		if(tile != oldTile) { // A l�nc elrabl�sra ker�lt.
			state = OrangutanState.Gathering;
			stepsSinceChainStolen = 0;
		}
			
		return (tile != oldTile);
	}
	
	
	/**  
	 * Az Orangutan oszt�ly Meet met�dusa. Ez a f�ggv�ny reprezent�lja az or�ngut�n tal�lkoz�s�t egy Pand�val.
	 * Az or�ngut�n a pand�val val� tal�lkoz�skor l�ncba f�zi a pand�t.
	 * @param panda - Panda objektum, amellyel az or�ngut�n tal�lkozik.
	 * @return void
	 */
	@Override
	public void Meet(Panda panda) {
		if(stepsSinceChainStolen >= 3){
		if(panda.Chain(nextInChain, this)) {
			tile.StepOff(this);
			
			Panda nextnext = nextInChain;
			nextInChain = panda;
			panda.StepTo(tile);
			
			if(nextInChain != null) { // a panda egyes steppedOn f�ggv�nyeiben elengedheti az or�ngut�n kez�t 
				if(nextnext != null)
					nextnext.ChainNew(panda);
			}
			else {
				nextInChain = nextnext;
				tile.StepOn(this);
			}
			}
		}
	}

	
	/**  
	 * Az Orangutan oszt�ly Meet met�dusa. Ez a f�ggv�ny reprezent�lja az or�ngut�n tal�lkoz�s�t egy m�sik or�ngut�nnal.
	 * @param orangutan - Orangutan objektum, amellyel az or�ngut�n tal�lkozik.
	 * @return void
	 */
	@Override
	public void Meet(Orangutan orangutan) {	
		if(nextInChain == null && stepsSinceChainStolen >= 3) {
			nextInChain = orangutan.GetNextInChain();
			
			if(nextInChain != null) {
				orangutan.BreakChain(this);
				nextInChain.ChainNew(this);
				tile.StepOff(this);
				orangutan.StepTo(tile);	
				tile = null;
			}	
		}
	}

	/**  
	 * Az Orangutan oszt�ly nextInChain attrib�tuma k�rdezhet� le.
	 * @return Panda - az or�ngut�n l�nc�ban els� panda
	 */
	public Panda GetNextInChain()
	{
		return nextInChain;
	}
	/**  
	 * Az Orangutan oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Orangutan r�l�pett-e egy NormalTile mez�re.
	 * @param tile - NormalTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	@Override
	public boolean SteppedOn(NormalTile tile) {
		boolean stepSuccessful = SteppedOnTile(tile);
		return stepSuccessful;
	}

	
	/**  
	 * Az Orangutan oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Orangutan r�l�pett-e egy BrittleTile mez�re.
	 * @param tile - BrittleTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	@Override
	public boolean SteppedOn(BrittleTile tile) {
		boolean stepSuccessful = SteppedOnTile(tile);
		return stepSuccessful;
	}

	/**  
	 * Az Orangutan oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Orangutan r�l�pett-e egy EntryTile mez�re.
	 * Mindek�zben be�ll�tja az or�ngut�n �ppen aktu�lis �llapot�t att�l f�gg�en, hogy a kivezet�s mely szakasz�ban van.
	 * @param tile - EntryTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	@Override
	public boolean SteppedOn(EntryTile tile) {
		boolean stepSuccessful = false;
		
		if(state == OrangutanState.Caging) {
			tile.JoinQueue(this);
			state = OrangutanState.Queuing;
		}
		else if(state == OrangutanState.Queuing ||
			   (state == OrangutanState.Gathering && (this.tile == tile || this.tile == null || stepsSinceChainStolen == 0))) {
			stepSuccessful = SteppedOnTile(tile);
			if(stepSuccessful) {
				state = OrangutanState.Gathering;
				nextStep = null;
				tickCount = 0;
			}
		}
		return stepSuccessful;
	}

	/**  
	 * Az Orangutan oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Orangutan r�l�pett-e egy ExitTile mez�re.
	 * Mindek�zben be�ll�tja az or�ngut�n �ppen aktu�lis �llapot�t att�l f�gg�en, hogy a kivezet�s mely szakasz�ban van.
	 * @param tile - ExitTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	@Override
	public boolean SteppedOn(ExitTile tile) {
		boolean stepSuccessful = false;
		
		if(state == OrangutanState.Gathering) {
			Panda originalNextInChain = nextInChain;
			
			stepSuccessful = true;
			
			Animal occupant = tile.GetOccupant();
			if(occupant != null)
				stepSuccessful = occupant.Meet((Animal)this);
			
			if(stepSuccessful) {
				nextStep = tile.GetWayOut();
				
				if(originalNextInChain == nextInChain)
					StepOff(this.tile, tile);
				else
					this.tile = tile;
				
				state = OrangutanState.Exiting;
			}
		}
		
		if(stepSuccessful && stepsSinceChainStolen < 3)
			++stepsSinceChainStolen;
		
		return stepSuccessful;
	}

	/**  
	 * Az Orangutan oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Orangutan r�l�pett-e egy ZooTile mez�re.
	 * Mindek�zben be�ll�tja az or�ngut�n �ppen aktu�lis �llapot�t att�l f�gg�en, hogy a kivezet�s mely szakasz�ban van.
	 * @param tile - ZooTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	@Override
	public boolean SteppedOn(ZooTile tile) {
		if(state == OrangutanState.Exiting) {
			tile.GetOccupant();
			nextStep = tile.GetWayIn();
			StepOff(this.tile, tile);
			state = OrangutanState.Caging;
			
			if(stepsSinceChainStolen < 3)
				++stepsSinceChainStolen;
		}
		
		return (state == OrangutanState.Exiting);
	}
	
	/**  
	 * Az Orangutan oszt�ly SteppedOnTile met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Orangutan
	 * sikeresen r�l�pett-e egy Tile mez�re.
	 * A f�ggv�ny kezeli az esetleges tal�lkoz�sokat is az �llatok k�z�tt.
	 * @param commonTile - Tile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	private boolean SteppedOnTile(Tile commonTile) {
		Panda originalNextInChain = nextInChain;
		
		boolean meetingSuccessful = true;
		
		Animal occupant = commonTile.GetOccupant();
		if(occupant != null)
			meetingSuccessful = occupant.Meet((Animal)this);
		
		if(meetingSuccessful) {
			if(originalNextInChain == nextInChain)
				StepOff(tile, commonTile);
			else
				tile = commonTile;
		}
		
		if(meetingSuccessful && stepsSinceChainStolen < 3)
			++stepsSinceChainStolen;
		
		return meetingSuccessful;
	}
	
	/**  
	 * Az Orangutan oszt�ly StepOff met�dusa. Ez a f�ggv�ny felel�s a r�gi mez�r�l val� lel�p�s�rt �s
	 * a l�ncban k�vetekz� �llat h�z�s��rt.
	 * @param oldTile - Tile t�pus� mez�, amely a kor�bbit szimboliz�lja
	 * @param newTile - Tile t�pus� mez�, amely az �jat szimboliz�lja.
	 * @return void
	 */
	private void StepOff(Tile oldTile, Tile newTile) {
		if(oldTile != null && oldTile != newTile)
			oldTile.StepOff(this);
		
		if(nextInChain != null)
			nextInChain.StepTo(oldTile);
		
		tile = newTile;
	}
}
