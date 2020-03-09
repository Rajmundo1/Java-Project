package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * PandaView osztály, mely megvalósítja az IDrawable interfészt.
 */
public abstract class PandaView implements IDrawable {
	/**
	 * Eltárolunk egy FloorView-t.
	 */
	protected FloorView floor;
	
	/**
	 * PandaView osztály konstruktora.
	 * @param f - FloorView típus.
	 */
	public PandaView(FloorView f) {
		floor = f;
	}
	
	/**
	 * PandaView osztály absztrakt Draw függvénye.
	 */
	@Override
	abstract public void Draw(Graphics graphics);
	
	/**
	 * PandaView osztály Draw függvénye, mely a megadott paramétereknek megfelelõen kirajzol egy objektumot.
	 * @param graphics - Graphics típus, ide rajzol.
	 * @param center - Point típus, eköré rajzolja a pandát.
	 * @param ears - Color típus, ilyen színû füleket rajzol a pandának.
	 * @param chained - boolean típus, ha igaz, a kirajzolt panda jobb felsõ sarkához egy lánc ikont rajzol.
	 */
	public void Draw(Graphics graphics, Point center, Color ears, boolean chained) {
		// Fülek:
		graphics.setColor(ears);
		graphics.fillOval(center.x - 30, center.y - 15, 20, 20);
		graphics.fillOval(center.x + 10, center.y - 15, 20, 20);
		graphics.setColor(Color.black);
		graphics.drawOval(center.x - 30, center.y - 15, 20, 20);
		graphics.drawOval(center.x + 10, center.y - 15, 20, 20);
		
		// Fej: 
		graphics.setColor(Color.white);
		graphics.fillOval(center.x - 20, center.y - 15, 40, 36);
		graphics.setColor(Color.black);
		graphics.drawOval(center.x - 20, center.y - 15, 40, 36);
		
		// Szemek:
		graphics.setColor(Color.black);
		graphics.drawOval(center.x-12, center.y-7, 8, 8);
		graphics.drawOval(center.x+4,  center.y-7, 8, 8);
		graphics.drawOval(center.x-9,  center.y-4, 2, 2);
		graphics.drawOval(center.x+7,  center.y-4, 2, 2);
		
		// Orr:
		graphics.setColor(Color.black);
		graphics.fillOval(center.x-5, center.y+3, 11, 6);

		// Lánc:
		if(chained) {
			graphics.setColor(Color.red);
			graphics.drawOval(center.x+15, center.y-24, 10, 6);
			graphics.drawOval(center.x+20, center.y-24, 10, 6);
			
			graphics.setColor(Color.black);
			graphics.drawOval(center.x+16, center.y-23, 10, 6);
			graphics.drawOval(center.x+21, center.y-23, 10, 6);
		}
					
	}
}
