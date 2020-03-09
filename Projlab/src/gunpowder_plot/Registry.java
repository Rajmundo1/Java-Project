package gunpowder_plot;
/**  
 * Registry oszt�ly.
 * Ez az oszt�ly felel�s a nyilv�ntart�s�rt. 
 */
public class Registry {
	/**
	 * Az �l� �llatok sz�ma.
	 */
	private int remaining = 0;
	/**
	 * A j�t�kos pontsz�ma.
	 */
	private int points = 0;
	/**
	 * Az aktu�lis szint.
	 */
	private Level level;
	
	/**  
	 * A Registry oszt�ly Add met�dusa. Eggyel megn�veli az �letben l�v� �llatok sz�m�t.
	 * @param - Ennek a f�ggv�nynek nincs param�tere.
	 * @return void
	 */
	public void Add() {
		remaining++;
	}
	
	/**  
	 * A Registry oszt�ly Remove met�dusa. Akkor h�v�dik, amikor egy �llat m�r nem "l�tezik".
	 * @param - Ennek a f�ggv�nynek nincs param�tere.
	 * @return void
	 */
	public void Remove() {
		remaining--;
		if(remaining == 0) {
			level.End();
		}	
	}
	
	/**  
	 * A Registry oszt�ly AddPoints met�dusa. Pontsz�mot n�vel a megadott sz�mmal.
	 * @param p - eg�sz sz�m, amely a hozz�adand� pontsz�mot jel�li.
	 * @return void
	 */
	public void AddPoints(int p) {
		points += p; 	
	}
	
	/**  
	 * A Registry oszt�ly GetPoints met�dusa. Lek�rdezhet� vele az aktu�lis pontsz�m.
	 * @param - Ennek a f�ggv�nynek nincs param�tere.
	 * @return points - Az oszt�ly points attrib�tuma, amely egy eg�sz sz�m (int)
	 */
	public int GetPoints() {
		return points;
	}
	
	/**  
	 * A Registry oszt�ly SetLevel met�dusa. Az aktu�lis szint be�ll�t�s�ra szolg�l� f�ggv�ny.
	 * @param l - Level objektum, amely a szintet szimboliz�lja
	 * @return void
	 */
	public void SetLevel(Level l) {
		this.level = l;	
	}
}
