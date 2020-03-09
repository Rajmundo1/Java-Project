package gunpowder_plot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * LevelView osztály, mely megvalósítja az IDrawable interfészt.
 */
public class LevelView implements IDrawable {
	/**
	 * Eltárolunk egy szintet.
	 */
	private Level level;
	
	/**
	 * LevelView osztály konstruktora.
	 * @param l - Level típus.
	 */
	public LevelView(Level l) {
		level = l;
	}
	
	/**
	 * LevelView osztály Draw metódusa mely kirajzol egy paraméterként kapott objektumot.
	 * @param graphics - Graphics.
	 * @return - void.
	 */
	@Override
	public void Draw(Graphics graphics) {
		boolean endOfGame = level.GetEndOfGame();
		
		if(endOfGame) {
			// Takarás:
			graphics.setColor(new Color(0, 0, 0, 170));
			graphics.fillRect(0, 0, 810, 460);
			
			// Játék vége kiírás:
			graphics.setColor(Color.white);
			graphics.setFont(new Font("Arial", Font.PLAIN, 34));
			graphics.drawString("End of Game — Points: " + level.GetPoints(), 810/2-200, 460/2);
		}
		else {
			// Pontok kiírása:
			graphics.setColor(Color.black);
			graphics.setFont(new Font("Arial", Font.PLAIN, 14));
			graphics.drawString("Points: " + level.GetPoints(), 10, 20);
		}

	}

}
