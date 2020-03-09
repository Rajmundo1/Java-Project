package gunpowder_plot;

/**  
 * Az OrangutanState enumeráció.
 * Ez az enumeráció mutatja az orángután aktuális állapotát. 
 */
enum OrangutanState {
	/**
	 * Pandákat gyûjt
	 */
	Gathering,
	/**
	 * Távozik a pályáról
	 */
	Exiting,
	/**
	 * Visszavezeti az állatkertbe a pandákat.
	 */
	Caging,
	/**
	 * Várakozik a pályára történõ visszalépésre.
	 */
	Queuing;
}
