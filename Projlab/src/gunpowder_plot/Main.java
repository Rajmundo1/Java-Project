package gunpowder_plot;

/**
 * A f�program, mely elind�tja a j�t�kot.
 * @author Gunpowder Plot
 */
public class Main {
	/**
	 * A program bel�p�si pontja. Fel�p�t egy MVC-szerkezetet, ez�ltal elind�tva a j�t�k egy p�ld�ny�t.
	 * @param args - A program a neki adott argumentumokat figyelmen k�v�l hagyja.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		GameController controller = new GameController(frame);
		frame.setVisible(true);
	}
}
