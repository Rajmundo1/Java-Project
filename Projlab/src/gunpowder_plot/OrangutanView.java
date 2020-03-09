package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * OrangutanView oszt�ly, mely megval�s�tja az IDrawable interf�szt.
 */
public class OrangutanView implements IDrawable {
	/**
	 * Elt�rolunk egy or�ngut�nt.
	 */
	private Orangutan orangutan;
	/**
	 * Elt�rolunk egy FloorView-t.
	 */
	private FloorView floor;
	
	/**
	 * OrangutanView oszt�ly konstruktora.
	 * @param m - Orangutan t�pus.
	 * @param f - FloorView t�pus.
	 */
	public OrangutanView(Orangutan m, FloorView f) {
		orangutan = m;
		floor = f;
	}
	
	/**
	 * OrangutanView oszt�ly Draw met�dusa.
	 * @param graphics - Graphics.
	 * @return - void.
	 */
	@Override
	public void Draw(Graphics graphics) {
		TileView tile = floor.GetTileByModelReference(orangutan.GetTile()); 
		if(tile != null) {
			Point tileCenter = tile.GetCenter();
			
			// F�l:
			graphics.setColor(new Color(139, 69, 19));
			graphics.fillOval(tileCenter.x-26, tileCenter.y-13, 12, 14);
			graphics.fillOval(tileCenter.x+14, tileCenter.y-13, 12, 14);
			graphics.setColor(Color.black);
			graphics.drawOval(tileCenter.x-26, tileCenter.y-13, 12, 14);
			graphics.drawOval(tileCenter.x+14, tileCenter.y-13, 12, 14);
			
			// Fej:
			graphics.setColor(new Color(139, 69, 19));
			graphics.fillOval(tileCenter.x - 20, tileCenter.y - 20, 40, 40);
			graphics.setColor(Color.black);
			graphics.drawOval(tileCenter.x - 20, tileCenter.y - 20, 40, 40);
			
			// Szemek:
			graphics.setColor(Color.white);
			graphics.fillOval(tileCenter.x-12, tileCenter.y-10, 8, 8);
			graphics.fillOval(tileCenter.x+4, tileCenter.y-10, 8, 8);
			graphics.setColor(Color.black);
			graphics.drawOval(tileCenter.x-12, tileCenter.y-10, 8, 8);
			graphics.drawOval(tileCenter.x+4, tileCenter.y-10, 8, 8);
			
			graphics.drawOval(tileCenter.x-9, tileCenter.y-7, 2, 2);
			graphics.drawOval(tileCenter.x+7, tileCenter.y-7, 2, 2);
			
			// Orr:
			graphics.setColor(Color.gray);
			graphics.fillOval(tileCenter.x-7, tileCenter.y, 14, 18);
			graphics.setColor(Color.black);
			graphics.drawOval(tileCenter.x-7, tileCenter.y, 14, 18);
			
			graphics.setColor(Color.black);
			graphics.fillOval(tileCenter.x-3, tileCenter.y+4, 2, 2);
			graphics.fillOval(tileCenter.x+2, tileCenter.y+4, 2, 2);
			graphics.fillOval(tileCenter.x-4, tileCenter.y+10, 8, 3);
			graphics.drawOval(tileCenter.x-4, tileCenter.y+10, 8, 3);

		}
	}
	
	/**
	 * OrangutanView oszt�ly GetOrangutan f�ggv�nye, mely vissza adja az elt�rolt or�ngut�nt.
	 * @return orangutan - Orangutan t�pus.
	 */
	public Orangutan GetOrangutan() {
		return orangutan;
	}
	
	/**
	 * OrangutanView oszt�ly IsUnder f�ggv�nye, mely megmondja hogy adott pontn�l van e az Or�ngut�n "alatt" csempe.
	 * @param point - Point t�pus.
	 * @return - boolean.
	 */
	public boolean IsUnder(Point point) {
		TileView tile = floor.GetTileByModelReference(orangutan.GetTile()); 
		if(tile != null) {
			Point tileCenter = tile.GetCenter();
			double dist = point.distance(tileCenter);
			return (dist <= 20);
		}
		return false;
	}

}
