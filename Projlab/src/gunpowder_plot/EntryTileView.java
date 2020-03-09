package gunpowder_plot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**
 * EntryTileView osztály, mely a TileView osztályból származik le.
 */
public class EntryTileView extends TileView {
	/**
	 * Eltároljuk az EntryTile-t.
	 */
	private EntryTile tile;
	
	/**
	 * EntryTileView osztály konstruktura, mely a megadott paramétereknek megfelelõen létrehoz egy EntryTileView objektumot.
	 * @param t - EntryTile típus.
	 * @param b - Lista objektum, mely a kirajzoláshoz szükséges pontokat tartalmazza.
	 */
	public EntryTileView(EntryTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**
	 * EntryTileView osztály GetTile függvénye, mely vissza adja az eltárolt Tile-t.
	 * @param - 
	 * @return - Tile típus.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**
	 * EntryTileView osztály Draw függvénye, mely a megadott paraméter alapján kirajzolja az EntryTile-t.
	 * @param graphics - Graphics típus.
	 * @return - void
	 */
	@Override
	public void Draw(Graphics graphics) {
		Draw(graphics, Color.yellow);
		
		// ENTRY sign:
		Point center = GetCenter();
		
		graphics.setColor(new Color(0, 100, 0));
		graphics.fillRect(center.x-20, center.y-8, 40, 16);
		
		graphics.setFont(new Font("Arial", Font.BOLD, 10));
		graphics.setColor(Color.white);
		graphics.drawString("ENTRY", center.x-17, center.y+4);
	}
}
