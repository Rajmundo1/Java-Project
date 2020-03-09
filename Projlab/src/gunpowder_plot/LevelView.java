package gunpowder_plot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * LevelView oszt�ly, mely megval�s�tja az IDrawable interf�szt.
 */
public class LevelView implements IDrawable {
	/**
	 * Elt�rolunk egy szintet.
	 */
	private Level level;
	
	/**
	 * LevelView oszt�ly konstruktora.
	 * @param l - Level t�pus.
	 */
	public LevelView(Level l) {
		level = l;
	}
	
	/**
	 * LevelView oszt�ly Draw met�dusa mely kirajzol egy param�terk�nt kapott objektumot.
	 * @param graphics - Graphics.
	 * @return - void.
	 */
	@Override
	public void Draw(Graphics graphics) {
		boolean endOfGame = level.GetEndOfGame();
		
		if(endOfGame) {
			// Takar�s:
			graphics.setColor(new Color(0, 0, 0, 170));
			graphics.fillRect(0, 0, 810, 460);
			
			// J�t�k v�ge ki�r�s:
			graphics.setColor(Color.white);
			graphics.setFont(new Font("Arial", Font.PLAIN, 34));
			graphics.drawString("End of Game � Points: " + level.GetPoints(), 810/2-200, 460/2);
		}
		else {
			// Pontok ki�r�sa:
			graphics.setColor(Color.black);
			graphics.setFont(new Font("Arial", Font.PLAIN, 14));
			graphics.drawString("Points: " + level.GetPoints(), 10, 20);
		}

	}

}
