package gunpowder_plot;

/**  
 * Az OrangutanState enumer�ci�.
 * Ez az enumer�ci� mutatja az or�ngut�n aktu�lis �llapot�t. 
 */
enum OrangutanState {
	/**
	 * Pand�kat gy�jt
	 */
	Gathering,
	/**
	 * T�vozik a p�ly�r�l
	 */
	Exiting,
	/**
	 * Visszavezeti az �llatkertbe a pand�kat.
	 */
	Caging,
	/**
	 * V�rakozik a p�ly�ra t�rt�n� visszal�p�sre.
	 */
	Queuing;
}
