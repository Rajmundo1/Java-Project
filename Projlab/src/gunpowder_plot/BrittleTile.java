package gunpowder_plot;

import java.util.Random;

/**  
 * BrittleTile osztály.
 * A Tile õsosztályból származik.
 * Ez az osztály felelõs a törékeny mezõ reprezentálásáért. 
 */
public class BrittleTile extends Tile{

	/**
	 * A mezõ életereje.
	 */
	private int health = 20;
	
	/**
	 * BrittleTile osztály konstruktora.
	 */
	public BrittleTile() {	}
		
	/**  
	 * A BrittleTile osztály StepOn metódusa. Ez a függvény azt a szituációt reprezentálja, amikor egy állat rá szeretne lépni erre a mezõre.
	 * Amennyiben a csempe élettartama <= 0, az rálépõ állat lezuhan.
	 * @param animal - Egy Animal objektum, amely rá szeretne lépni erre a mezõre.
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
	 * A BrittleTile osztály JumpOn metódusa. Ez a metódus a csempén való ugrást hivatott reprezentálni.
	 * A csempe élettartama az ugrás következtében meghatározott ponttal csökken.
	 * Amennyiben a csempe élettartama <= 0, a rajta tartózkodó állat az ugrás után lezuhan.
	 * @param - Ennek a függvénynek nincs paramétere.
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
	 * A BrittleTile osztály GetHealth metódusa, mely visszaadja a csempe életerejét.
	 * @param - Ennek a függvénynek nincs paramétere.
	 * @return health - int típus.
	 */
	public int GetHealth() {
		return health;
	}
}
