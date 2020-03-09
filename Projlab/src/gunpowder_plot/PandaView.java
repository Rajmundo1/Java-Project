package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * PandaView oszt�ly, mely megval�s�tja az IDrawable interf�szt.
 */
public abstract class PandaView implements IDrawable {
	/**
	 * Elt�rolunk egy FloorView-t.
	 */
	protected FloorView floor;
	
	/**
	 * PandaView oszt�ly konstruktora.
	 * @param f - FloorView t�pus.
	 */
	public PandaView(FloorView f) {
		floor = f;
	}
	
	/**
	 * PandaView oszt�ly absztrakt Draw f�ggv�nye.
	 */
	@Override
	abstract public void Draw(Graphics graphics);
	
	/**
	 * PandaView oszt�ly Draw f�ggv�nye, mely a megadott param�tereknek megfelel�en kirajzol egy objektumot.
	 * @param graphics - Graphics t�pus, ide rajzol.
	 * @param center - Point t�pus, ek�r� rajzolja a pand�t.
	 * @param ears - Color t�pus, ilyen sz�n� f�leket rajzol a pand�nak.
	 * @param chained - boolean t�pus, ha igaz, a kirajzolt panda jobb fels� sark�hoz egy l�nc ikont rajzol.
	 */
	public void Draw(Graphics graphics, Point center, Color ears, boolean chained) {
		// F�lek:
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

		// L�nc:
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
