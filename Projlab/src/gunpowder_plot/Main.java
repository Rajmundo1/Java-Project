package gunpowder_plot;

/**
 * A fõprogram, mely elindítja a játékot.
 * @author Gunpowder Plot
 */
public class Main {
	/**
	 * A program belépési pontja. Felépít egy MVC-szerkezetet, ezáltal elindítva a játék egy példányát.
	 * @param args - A program a neki adott argumentumokat figyelmen kívül hagyja.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		GameController controller = new GameController(frame);
		frame.setVisible(true);
	}
}
