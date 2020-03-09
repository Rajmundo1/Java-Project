package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * OrangutanView osztály, mely megvalósítja az IDrawable interfészt.
 */
public class OrangutanView implements IDrawable {
	/**
	 * Eltárolunk egy orángutánt.
	 */
	private Orangutan orangutan;
	/**
	 * Eltárolunk egy FloorView-t.
	 */
	private FloorView floor;
	
	/**
	 * OrangutanView osztály konstruktora.
	 * @param m - Orangutan típus.
	 * @param f - FloorView típus.
	 */
	public OrangutanView(Orangutan m, FloorView f) {
		orangutan = m;
		floor = f;
	}
	
	/**
	 * OrangutanView osztály Draw metódusa.
	 * @param graphics - Graphics.
	 * @return - void.
	 */
	@Override
	public void Draw(Graphics graphics) {
		TileView tile = floor.GetTileByModelReference(orangutan.GetTile()); 
		if(tile != null) {
			Point tileCenter = tile.GetCenter();
			
			// Fül:
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
	 * OrangutanView osztály GetOrangutan függvénye, mely vissza adja az eltárolt orángutánt.
	 * @return orangutan - Orangutan típus.
	 */
	public Orangutan GetOrangutan() {
		return orangutan;
	}
	
	/**
	 * OrangutanView osztály IsUnder függvénye, mely megmondja hogy adott pontnál van e az Orángután "alatt" csempe.
	 * @param point - Point típus.
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
