package gunpowder_plot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**  
 * Absztrakt Panda oszt�ly.
 * Az Animal �soszt�lyb�l sz�rmazik.
 * Ez az oszt�ly hivatott a pand�k reprezent�l�s�ra.
 */
public abstract class Panda extends Animal {
	/**
	 * Az �t megel�z� �llat a l�ncban.
	 */
	protected Animal previousInChain = null;
	/**
	 * Egy Panda t�pus� objektum, amely a l�ncban val� k�vetkez� elem.
	 */
	protected Panda nextInChain = null;
	/**
	 * Egy boolean t�pus� objektum, mely megadja, hogy a Panda �jonnan befogott, vagy sem.
	 */
	protected boolean newlyChained = false;
	/**
	 * boolean t�pus� v�ltoz�, amely megadja, hogy visszat�rt-e az �llatkertbe.
	 */
	protected boolean caged = false;
	
	/**  
	 * A Panda oszt�ly setChain met�dusa. A l�ncba f�z�sben van kiemelked� szerepe.
	 * @param previos - Az el�tte l�v� �llat
	 * @param next - Az ut�na �ll� panda
	 * @return void
	 */	
	public void setChain(Animal previous, Panda next) {
		previousInChain = previous;
		nextInChain = next;
	}
	
	/**  
	 * A Panda oszt�ly Tick met�dusa. A l�ptet�sekben �s id�z�t�sben van kulcsszerepe.
	 * @param Nincs param�tere.
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
	 * A Panda oszt�ly StepTo met�dusa. Ez a f�ggv�ny felel�s a panda l�ptet�s��rt. 
	 * @param tile - Az a mez� objektum, amelyre a panda l�pni szeretne.
	 * @return void
	 */	
	public void StepTo(Tile tile) {
		tile.StepOn(this);	
	}
	
	/**  
	 * A Panda oszt�ly BreakChain met�dusa. Ez a f�ggv�ny felel�s az pand�k l�nc�nak megszak�t�s��rt.
	 * @param deserter - az az Animal objektum, amely megszak�tja a l�ncot.
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
	 * A Panda oszt�ly Fall met�dusa. Ez a f�ggv�ny felel�s az panda lezuhan�s��rt.
	 * @param - Ennek a f�ggv�nynek nincs param�tere.
	 * @return void
	 */
	public void Fall() {
		registry.Remove();
		BreakChain(this);
		tile = null;
		alive = false;
	}
	
	/**  
	 * A Panda oszt�ly Meet met�dusa. Ez a f�ggv�ny reprezent�lja a panda tal�lkoz�s�t egy �llattal.
	 * @param animal - Animal objektum, amellyel a panda tal�lkozik.
	 * @return boolean - �tadta-e a hely�t.
	 */
	public boolean Meet (Animal animal) {
		Animal originalPreviousInChain = previousInChain;   
		animal.Meet(this); // previousInChain itt v�ltozhat
		return (originalPreviousInChain != previousInChain);
	}
	
	/**  
	 * A Panda oszt�ly Meet met�dusa. Ez a f�ggv�ny reprezent�lja a panda tal�lkoz�s�t egy m�sik pand�val.
	 * @param panda - Panda objektum, amellyel a panda tal�lkozik.
	 * @return void
	 */
	public void Meet (Panda panda) { }
	
	/**  
	 * A Panda oszt�ly Meet met�dusa. Ez a f�ggv�ny reprezent�lja a panda tal�lkoz�s�t egy or�ngut�nnal.
	 * @param orangutan - Orangutan objektum, amellyel a panda tal�lkozik.
	 * @return void
	 */
	public void Meet (Orangutan orangutan) { }
	
	/**  
	 * A Panda oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Panda r�l�pett-e egy NormalTile mez�re.
	 * @param tile - NormalTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */

	public boolean SteppedOn (NormalTile tile) {
		boolean stepSuccessful = SteppedOnTile(tile);
		return stepSuccessful;
	}
	
	/**  
	 * A Panda oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Panda r�l�pett-e egy BrittleTile mez�re.
	 * @param tile - BrittleTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	public boolean SteppedOn (BrittleTile tile) {
		boolean stepSuccessful = SteppedOnTile(tile);
		return stepSuccessful;
	}
	
	/**  
	 * A Panda oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Panda r�l�pett-e egy EntryTile mez�re.
	 * @param tile - EntryTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	public boolean SteppedOn (EntryTile tile) {
		BreakChain(this);
		newlyChained = false;
		return false;
	}
	
	/**  
	 * A Panda oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Panda r�l�pett-e egy ExitTile mez�re.
	 * @param tile - ExitTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	public boolean SteppedOn (ExitTile tile) {
		boolean returnValue = steppedOnForbiddenTile(tile);
		return returnValue;
	}
	
	
	/**  
	 * A Panda oszt�ly SteppedOn met�dusa. Ez a f�ggv�ny mondja meg, hogy egy Panda r�l�pett-e egy ZooTile mez�re.
	 * @param tile - ZooTile t�pus� mez�.
	 * @return boolean - siker�lt, vagy nem.
	 */
	public boolean SteppedOn (ZooTile tile) {
		boolean returnValue = steppedOnForbiddenTile(tile);
		return returnValue;
	}
	
	/**  
	 * A Panda oszt�ly ChainNew met�dusa. Akkor h�v�dik meg, amikor a panda l�ncban marad, viszont az el�tte l�v� �llat kil�te v�ltozik. 
	 * P�ld�ul eddig egy or�ngut�n vezette, de egy �j panda ker�lt el� a l�ncba, �gy most m�r az �j panda lesz a l�ncban el�tte l�v�.
	 * @param previous - Animal objektum, ami az �t megel�z� �llatot szimboliz�lja.
	 * @return void
	 */
	public void ChainNew(Animal previous) {
		previousInChain = previous;	
	}
	
	/**  
	 * A Panda oszt�ly GetNextInChain met�dusa. Ez a f�ggv�ny megadja a k�vetkez� pand�t a l�ncban.
	 * @param - Ennek a f�ggv�nynek nincsen param�tere.
	 * @return Panda t�pus� objektum, amely a k�vetkez� a l�ncban.
	 */
	public Panda GetNextInChain() {
		return nextInChain;
	}
	
	/**  
	 * A Panda oszt�ly Chain met�dusa. L�ncol�s eset�n h�v�dik.
	 * @param next - Panda objektum, amely a l�ncba ker�l.
	 * @return boolean - panda elfogadja-e a l�ncol�st, vagy sem.
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
	 * A Panda oszt�ly Cage met�dusa. Az �llatkertbe val� visszavezet�skor h�v�dik.
	 * A kivezetett panda ut�n a j�t�kos pontot kap, mely a megfelel� Registryben nyilv�ntart�sra ker�l.
	 * A kivezetett panda ezut�n elt�nik a nyilv�ntart�sb�l, mint l�tez� panda.
	 * @param next - Panda objektum, amely a l�ncba ker�l.
	 * @return boolean - panda elfogadja-e a l�ncol�st, vagy sem.
	 */
	public void Cage () {
		caged = true;
		registry.AddPoints(1);
		registry.Remove();
		this.previousInChain = null;
		this.nextInChain = null;
	}
	
	/**  	  
	 * Az Panda oszt�ly SteppedOnTile met�dusa. Ez a f�ggv�ny felel�s az �llat param�terben kapott csemp�re l�ptet�s��rt.	 
	 * @param commonTile - Tile t�pus.
	 * @return meetingSuccesful - boolean t�pus.
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
	 * Az Panda oszt�ly steppedOnForbiddenTile met�dusa. Ez a f�ggv�ny felel�s �rte hogy eld�ntse, hogy az �llat tiltott mez�re l�pett e.	 
	 * @param forbiddentile - Tile t�pus.
	 * @return  - boolean t�pus.
	 */
	protected boolean steppedOnForbiddenTile(Tile forbiddentile)
	{
		if(previousInChain != null)
			StepOff(tile, forbiddentile);
		
		return previousInChain != null;
	}
	
	
	/**  	  
	 * Az Panda oszt�ly StepOff met�dusa. Ez a f�ggv�ny felel�s a r�gi mez�r�l val� lel�p�srt �s 	 
	 * a l�ncban k�vetkez� �llat h�z�s�r�t. 	 
	 * @param oldTile - a kor�bbi mez�	 
	 * @param newTile - az �j mez� 
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
	 * Az Panda oszt�ly GetPreviousInChain met�dusa. Ez a f�ggv�ny adja vissza a Panda el�tt �ll� �llatot.	 
	 * @return previousInChain - Animal t�pus.
	 */
	public Animal GetPreviousInChain() {
		return previousInChain;
	}
}
