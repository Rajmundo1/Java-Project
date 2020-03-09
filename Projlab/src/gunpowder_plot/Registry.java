package gunpowder_plot;
/**  
 * Registry osztály.
 * Ez az osztály felelõs a nyilvántartásért. 
 */
public class Registry {
	/**
	 * Az élõ állatok száma.
	 */
	private int remaining = 0;
	/**
	 * A játékos pontszáma.
	 */
	private int points = 0;
	/**
	 * Az aktuális szint.
	 */
	private Level level;
	
	/**  
	 * A Registry osztály Add metódusa. Eggyel megnöveli az életben lévõ állatok számát.
	 * @param - Ennek a függvénynek nincs paramétere.
	 * @return void
	 */
	public void Add() {
		remaining++;
	}
	
	/**  
	 * A Registry osztály Remove metódusa. Akkor hívódik, amikor egy állat már nem "létezik".
	 * @param - Ennek a függvénynek nincs paramétere.
	 * @return void
	 */
	public void Remove() {
		remaining--;
		if(remaining == 0) {
			level.End();
		}	
	}
	
	/**  
	 * A Registry osztály AddPoints metódusa. Pontszámot növel a megadott számmal.
	 * @param p - egész szám, amely a hozzáadandó pontszámot jelöli.
	 * @return void
	 */
	public void AddPoints(int p) {
		points += p; 	
	}
	
	/**  
	 * A Registry osztály GetPoints metódusa. Lekérdezhetõ vele az aktuális pontszám.
	 * @param - Ennek a függvénynek nincs paramétere.
	 * @return points - Az osztály points attribútuma, amely egy egész szám (int)
	 */
	public int GetPoints() {
		return points;
	}
	
	/**  
	 * A Registry osztály SetLevel metódusa. Az aktuális szint beállítására szolgáló függvény.
	 * @param l - Level objektum, amely a szintet szimbolizálja
	 * @return void
	 */
	public void SetLevel(Level l) {
		this.level = l;	
	}
}
