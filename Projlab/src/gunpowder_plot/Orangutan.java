package gunpowder_plot;
/**  
 * Orangutan osztály.
 * Az Animal õsosztályból származik.
 * Ez az osztály hivatott az orángutánok reprezentálására. 
 */
public class Orangutan extends Animal {
	/**
	 * Idõzítéshez szükséges számláló
	 */
	private int tickCount = 2;
	/**
	 * Egy Panda típusú objektum, amely a láncban való következõ elem. Alapértelmezés szerint null.
	 */
	private Panda nextInChain = null;
	/**
	 * Orangutan állapota. Alapértelmezés szerinte Gathering - azaz gyûjtés.
	 */
	private OrangutanState state = OrangutanState.Gathering;
	/**
	 * Következõ mezõ, amelyre lépne. Alapértelmezés szerint null.
	 */
	private Tile nextStep = null;
	/**
	 * A szükséges lépések száma, hogy az Orángután ismét foghasson Pandát. Alapértelmezett értéke 3.
	 */
	private int stepsSinceChainStolen = 3;
	
	public Orangutan(Registry r) {
		registry = r;
		registry.Add();
	}
	
	/**  
	 * Az Orangutan osztály Tick metódusa. A léptetésekben és idõzítésben van kulcsszerepe.
	 * @param Nincs paramétere.
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
	 * Az Orangutan osztály StepTo metódusa. Ez a függvény felelõs az orángután léptetéséért.
	 * @param tile - Az a mezõ objektum, amelyre az orángután lépni szeretne.
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
	 * Az Orangutan osztály BreakChain metódusa. Ez a függvény felelõs az orángután láncának megszakításáért.
	 * @param deserter - az az Animal objektum, amely megszakítja a láncot.
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
	 * Az Orangutan osztály Fall metódusa. Ez a függvény felelõs az orángután lezuhanásáért.
	 * @param - Ennek a függvénynek nincs paramétere.
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
	 * Az Orangutan osztály Meet metódusa. Ez a függvény reprezentálja az orángután találkozását egy állattal.
	 * @param animal - Animal objektum, amellyel az orángután találkozik.
	 * @return boolean - átadta-e a helyét.
	 */
	@Override
	public boolean Meet(Animal animal) {
		Tile oldTile = tile;
		
		animal.Meet(this); // Itt a tile attribútum a lánc elrablásakor megváltozhat.
		
		if(tile != oldTile) { // A lánc elrablásra került.
			state = OrangutanState.Gathering;
			stepsSinceChainStolen = 0;
		}
			
		return (tile != oldTile);
	}
	
	
	/**  
	 * Az Orangutan osztály Meet metódusa. Ez a függvény reprezentálja az orángután találkozását egy Pandával.
	 * Az orángután a pandával való találkozáskor láncba fûzi a pandát.
	 * @param panda - Panda objektum, amellyel az orángután találkozik.
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
			
			if(nextInChain != null) { // a panda egyes steppedOn függvényeiben elengedheti az orángután kezét 
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
	 * Az Orangutan osztály Meet metódusa. Ez a függvény reprezentálja az orángután találkozását egy másik orángutánnal.
	 * @param orangutan - Orangutan objektum, amellyel az orángután találkozik.
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
	 * Az Orangutan osztály nextInChain attribútuma kérdezhetõ le.
	 * @return Panda - az orángután láncában elsõ panda
	 */
	public Panda GetNextInChain()
	{
		return nextInChain;
	}
	/**  
	 * Az Orangutan osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Orangutan rálépett-e egy NormalTile mezõre.
	 * @param tile - NormalTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	@Override
	public boolean SteppedOn(NormalTile tile) {
		boolean stepSuccessful = SteppedOnTile(tile);
		return stepSuccessful;
	}

	
	/**  
	 * Az Orangutan osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Orangutan rálépett-e egy BrittleTile mezõre.
	 * @param tile - BrittleTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	@Override
	public boolean SteppedOn(BrittleTile tile) {
		boolean stepSuccessful = SteppedOnTile(tile);
		return stepSuccessful;
	}

	/**  
	 * Az Orangutan osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Orangutan rálépett-e egy EntryTile mezõre.
	 * Mindeközben beállítja az orángután éppen aktuális állapotát attól függõen, hogy a kivezetés mely szakaszában van.
	 * @param tile - EntryTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
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
	 * Az Orangutan osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Orangutan rálépett-e egy ExitTile mezõre.
	 * Mindeközben beállítja az orángután éppen aktuális állapotát attól függõen, hogy a kivezetés mely szakaszában van.
	 * @param tile - ExitTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
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
	 * Az Orangutan osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Orangutan rálépett-e egy ZooTile mezõre.
	 * Mindeközben beállítja az orángután éppen aktuális állapotát attól függõen, hogy a kivezetés mely szakaszában van.
	 * @param tile - ZooTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
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
	 * Az Orangutan osztály SteppedOnTile metódusa. Ez a függvény mondja meg, hogy egy Orangutan
	 * sikeresen rálépett-e egy Tile mezõre.
	 * A függvény kezeli az esetleges találkozásokat is az állatok között.
	 * @param commonTile - Tile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
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
	 * Az Orangutan osztály StepOff metódusa. Ez a függvény felelõs a régi mezõrõl való lelépésért és
	 * a láncban követekzõ állat húzásáért.
	 * @param oldTile - Tile típusú mezõ, amely a korábbit szimbolizálja
	 * @param newTile - Tile típusú mezõ, amely az újat szimbolizálja.
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
