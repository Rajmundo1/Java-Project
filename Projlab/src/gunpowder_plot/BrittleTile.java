package gunpowder_plot;

import java.util.Random;

/**  
 * BrittleTile oszt�ly.
 * A Tile �soszt�lyb�l sz�rmazik.
 * Ez az oszt�ly felel�s a t�r�keny mez� reprezent�l�s��rt. 
 */
public class BrittleTile extends Tile{

	/**
	 * A mez� �letereje.
	 */
	private int health = 20;
	
	/**
	 * BrittleTile oszt�ly konstruktora.
	 */
	public BrittleTile() {	}
		
	/**  
	 * A BrittleTile oszt�ly StepOn met�dusa. Ez a f�ggv�ny azt a szitu�ci�t reprezent�lja, amikor egy �llat r� szeretne l�pni erre a mez�re.
	 * Amennyiben a csempe �lettartama <= 0, az r�l�p� �llat lezuhan.
	 * @param animal - Egy Animal objektum, amely r� szeretne l�pni erre a mez�re.
	 * @return void
	 */
	@Override
	public void StepOn(Animal animal) {
		if(animal.SteppedOn(this)) {
			if(health > 0)
				--health;
			
			if(health <= 0) {
				animal.Fall();
				occupant = null;
			}
			else {
				occupant = animal;
			}
		}
	}
	
	/**  
	 * A BrittleTile oszt�ly JumpOn met�dusa. Ez a met�dus a csemp�n val� ugr�st hivatott reprezent�lni.
	 * A csempe �lettartama az ugr�s k�vetkezt�ben meghat�rozott ponttal cs�kken.
	 * Amennyiben a csempe �lettartama <= 0, a rajta tart�zkod� �llat az ugr�s ut�n lezuhan.
	 * @param - Ennek a f�ggv�nynek nincs param�tere.
	 * @return void
	 */
	public void JumpOn() {
		Random rand = new Random();
		int damage = rand.nextInt(5) + 4;
		health -= Math.min(health, damage);
		
		if (health == 0) {
			occupant.Fall();
			occupant = null;
		}
	}
	
	/**
	 * A BrittleTile oszt�ly GetHealth met�dusa, mely visszaadja a csempe �leterej�t.
	 * @param - Ennek a f�ggv�nynek nincs param�tere.
	 * @return health - int t�pus.
	 */
	public int GetHealth() {
		return health;
	}
}
