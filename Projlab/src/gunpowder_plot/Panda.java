package gunpowder_plot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**  
 * Absztrakt Panda osztály.
 * Az Animal õsosztályból származik.
 * Ez az osztály hivatott a pandák reprezentálására.
 */
public abstract class Panda extends Animal {
	/**
	 * Az õt megelõzõ állat a láncban.
	 */
	protected Animal previousInChain = null;
	/**
	 * Egy Panda típusú objektum, amely a láncban való következõ elem.
	 */
	protected Panda nextInChain = null;
	/**
	 * Egy boolean típusú objektum, mely megadja, hogy a Panda újonnan befogott, vagy sem.
	 */
	protected boolean newlyChained = false;
	/**
	 * boolean típusú változó, amely megadja, hogy visszatért-e az állatkertbe.
	 */
	protected boolean caged = false;
	
	/**  
	 * A Panda osztály setChain metódusa. A láncba fûzésben van kiemelkedõ szerepe.
	 * @param previos - Az elõtte lévõ állat
	 * @param next - Az utána álló panda
	 * @return void
	 */	
	public void setChain(Animal previous, Panda next) {
		previousInChain = previous;
		nextInChain = next;
	}
	
	/**  
	 * A Panda osztály Tick metódusa. A léptetésekben és idõzítésben van kulcsszerepe.
	 * @param Nincs paramétere.
	 * @return void
	 */	

	public void Tick() {
		boolean random = (new Random().nextInt(10) == 0); // 10%
		boolean willStep = random; 
        if(alive && !caged && previousInChain == null && tile != null && willStep){
            List<Tile> neighbors = new ArrayList<Tile>(tile.GetNeighbors());
            while(neighbors.size() > 0)
            {
            	int direction = new Random().nextInt(neighbors.size());
            	
                Tile tileBefore = tile;

                neighbors.get(direction).StepOn(this);

                if(tileBefore == tile)
                    neighbors.remove(direction);
                else
                    break;
            }
        }
	}
			
	/**  
	 * A Panda osztály StepTo metódusa. Ez a függvény felelõs a panda léptetéséért. 
	 * @param tile - Az a mezõ objektum, amelyre a panda lépni szeretne.
	 * @return void
	 */	
	public void StepTo(Tile tile) {
		tile.StepOn(this);	
	}
	
	/**  
	 * A Panda osztály BreakChain metódusa. Ez a függvény felelõs az pandák láncának megszakításáért.
	 * @param deserter - az az Animal objektum, amely megszakítja a láncot.
	 * @return void
	 */
	public void BreakChain(Animal deserter) {
		if(deserter == this) {
			if(previousInChain != null) {
				previousInChain.BreakChain(this);
				previousInChain = null;
				}
			if(nextInChain != null) {
				nextInChain.BreakChain(this);
				nextInChain = null;
				}
		}
		
		if(deserter == previousInChain) {
			if(nextInChain != null) {
				nextInChain.BreakChain(this);
			}
			previousInChain = null;
			nextInChain = null;
				
		}
		
		if(deserter == nextInChain)
			nextInChain = null;	
	}
	
	/**  
	 * A Panda osztály Fall metódusa. Ez a függvény felelõs az panda lezuhanásáért.
	 * @param - Ennek a függvénynek nincs paramétere.
	 * @return void
	 */
	public void Fall() {
		registry.Remove();
		BreakChain(this);
		tile = null;
		alive = false;
	}
	
	/**  
	 * A Panda osztály Meet metódusa. Ez a függvény reprezentálja a panda találkozását egy állattal.
	 * @param animal - Animal objektum, amellyel a panda találkozik.
	 * @return boolean - átadta-e a helyét.
	 */
	public boolean Meet (Animal animal) {
		Animal originalPreviousInChain = previousInChain;   
		animal.Meet(this); // previousInChain itt változhat
		return (originalPreviousInChain != previousInChain);
	}
	
	/**  
	 * A Panda osztály Meet metódusa. Ez a függvény reprezentálja a panda találkozását egy másik pandával.
	 * @param panda - Panda objektum, amellyel a panda találkozik.
	 * @return void
	 */
	public void Meet (Panda panda) { }
	
	/**  
	 * A Panda osztály Meet metódusa. Ez a függvény reprezentálja a panda találkozását egy orángutánnal.
	 * @param orangutan - Orangutan objektum, amellyel a panda találkozik.
	 * @return void
	 */
	public void Meet (Orangutan orangutan) { }
	
	/**  
	 * A Panda osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Panda rálépett-e egy NormalTile mezõre.
	 * @param tile - NormalTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */

	public boolean SteppedOn (NormalTile tile) {
		boolean stepSuccessful = SteppedOnTile(tile);
		return stepSuccessful;
	}
	
	/**  
	 * A Panda osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Panda rálépett-e egy BrittleTile mezõre.
	 * @param tile - BrittleTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	public boolean SteppedOn (BrittleTile tile) {
		boolean stepSuccessful = SteppedOnTile(tile);
		return stepSuccessful;
	}
	
	/**  
	 * A Panda osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Panda rálépett-e egy EntryTile mezõre.
	 * @param tile - EntryTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	public boolean SteppedOn (EntryTile tile) {
		BreakChain(this);
		newlyChained = false;
		return false;
	}
	
	/**  
	 * A Panda osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Panda rálépett-e egy ExitTile mezõre.
	 * @param tile - ExitTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	public boolean SteppedOn (ExitTile tile) {
		boolean returnValue = steppedOnForbiddenTile(tile);
		return returnValue;
	}
	
	
	/**  
	 * A Panda osztály SteppedOn metódusa. Ez a függvény mondja meg, hogy egy Panda rálépett-e egy ZooTile mezõre.
	 * @param tile - ZooTile típusú mezõ.
	 * @return boolean - sikerült, vagy nem.
	 */
	public boolean SteppedOn (ZooTile tile) {
		boolean returnValue = steppedOnForbiddenTile(tile);
		return returnValue;
	}
	
	/**  
	 * A Panda osztály ChainNew metódusa. Akkor hívódik meg, amikor a panda láncban marad, viszont az elõtte lévõ állat kiléte változik. 
	 * Például eddig egy orángután vezette, de egy új panda került elé a láncba, így most már az új panda lesz a láncban elõtte lévõ.
	 * @param previous - Animal objektum, ami az õt megelõzõ állatot szimbolizálja.
	 * @return void
	 */
	public void ChainNew(Animal previous) {
		previousInChain = previous;	
	}
	
	/**  
	 * A Panda osztály GetNextInChain metódusa. Ez a függvény megadja a következõ pandát a láncban.
	 * @param - Ennek a függvénynek nincsen paramétere.
	 * @return Panda típusú objektum, amely a következõ a láncban.
	 */
	public Panda GetNextInChain() {
		return nextInChain;
	}
	
	/**  
	 * A Panda osztály Chain metódusa. Láncolás esetén hívódik.
	 * @param next - Panda objektum, amely a láncba kerül.
	 * @return boolean - panda elfogadja-e a láncolást, vagy sem.
	 */
	public boolean Chain(Panda next, Animal previous) {
		if(previousInChain == null) {
			previousInChain = previous;
			nextInChain = next;
			newlyChained = true;
			return true;
		}
		
		return false;
	}
	
	/**  
	 * A Panda osztály Cage metódusa. Az állatkertbe való visszavezetéskor hívódik.
	 * A kivezetett panda után a játékos pontot kap, mely a megfelelõ Registryben nyilvántartásra kerül.
	 * A kivezetett panda ezután eltûnik a nyilvántartásból, mint létezõ panda.
	 * @param next - Panda objektum, amely a láncba kerül.
	 * @return boolean - panda elfogadja-e a láncolást, vagy sem.
	 */
	public void Cage () {
		caged = true;
		registry.AddPoints(1);
		registry.Remove();
		this.previousInChain = null;
		this.nextInChain = null;
	}
	
	/**  	  
	 * Az Panda osztály SteppedOnTile metódusa. Ez a függvény felelõs az állat paraméterben kapott csempére léptetéséért.	 
	 * @param commonTile - Tile típus.
	 * @return meetingSuccesful - boolean típus.
	 */
	protected boolean SteppedOnTile(Tile commonTile) {
		boolean meetingSuccessful = true;
		
		Animal occupant = commonTile.GetOccupant();
		if(occupant != null)
			meetingSuccessful = occupant.Meet((Animal)this);
		
		if(meetingSuccessful)
				StepOff(tile, commonTile);
		
		return meetingSuccessful;
	}
	
	/**  	  
	 * Az Panda osztály steppedOnForbiddenTile metódusa. Ez a függvény felelõs érte hogy eldöntse, hogy az állat tiltott mezõre lépett e.	 
	 * @param forbiddentile - Tile típus.
	 * @return  - boolean típus.
	 */
	protected boolean steppedOnForbiddenTile(Tile forbiddentile)
	{
		if(previousInChain != null)
			StepOff(tile, forbiddentile);
		
		return previousInChain != null;
	}
	
	
	/**  	  
	 * Az Panda osztály StepOff metódusa. Ez a függvény felelõs a régi mezõrõl való lelépésrt és 	 
	 * a láncban következõ állat húzásárét. 	 
	 * @param oldTile - a korábbi mezõ	 
	 * @param newTile - az új mezõ 
	 */
	protected void StepOff(Tile oldTile, Tile newTile) {
		if(oldTile != null)
			oldTile.StepOff(this);
		
		if(nextInChain != null && !newlyChained)
			nextInChain.StepTo(oldTile);
		
		if(newlyChained)
			newlyChained = false;
		
		tile = newTile;
	}
	
	/**  	  
	 * Az Panda osztály GetPreviousInChain metódusa. Ez a függvény adja vissza a Panda elõtt álló állatot.	 
	 * @return previousInChain - Animal típus.
	 */
	public Animal GetPreviousInChain() {
		return previousInChain;
	}
}
