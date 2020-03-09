package gunpowder_plot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**  
 * ArmchairTile oszt�ly.
 * A Tile �soszt�lyb�l sz�rmazik.
 * Ez az oszt�ly felel�s a fotel reprezent�l�s��rt. 
 */
public class ArmchairTile extends Tile{
	
	/**  
	 * Az ArmchairTile oszt�ly Tick met�dusa. Ez a mez� megpr�b�lja maga fel� csalogatni a szomsz�dos mez�k�n �ll� �llatokat.
	 * Ez az esem�ny meghat�rozott id�k�z�nk�nt t�rt�nik.
	 * @param - Ennek a f�ggv�nynek nincsenek param�terei
	 * @return void
	 */
	public void Tick() {
		boolean random = (new Random().nextInt(20) == 0); // 5%
		boolean willStimulate = random;
		if (willStimulate) {
			List<Animal> occupants = new ArrayList<Animal>();
			
			for(Tile tile : neighbors) {
				Animal o = tile.GetOccupant();
				if(o != null)
					occupants.add(o);
			}
			
			for (Animal o : occupants) {
				o.Stimulate(this); // itt megv�ltozhat az occupant
				if(occupant != null)
					break;
			}
					
		}
	}
	
	
	/**  
	 * Az ArmchairTile oszt�ly StepOn met�dusa. Ez a f�ggv�ny azt a szitu�ci�t reprezent�lja, amikor egy �llat r� szeretne l�pni erre a mez�re.
	 * @param animal - Egy Animal objektum, amely r� szeretne l�pni erre a mez�re.
	 * @return void
	 */
	@Override
	public void StepOn(Animal animal) {
		if(animal.SteppedOn(this)) {
			occupant = animal;
		}			
	}
}
