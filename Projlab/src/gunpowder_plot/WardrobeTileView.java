package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**
 * WardrobeTileView osztály, mely a TileView-bõl származik.
 */
public class WardrobeTileView extends TileView {
	/**
	 * Eltárolunk egy NormalTile-t.
	 */
	private NormalTile tile;
	
	/**
	 * WardrobeTileView osztály konstruktora.
	 * @param t - NormalTile típus.
	 * @param b - Pontokból álló lista.
	 */
	public WardrobeTileView(NormalTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**
	 * WardrobeTileView osztály GetTile függvénye, mely visszaadja az eltárolt Tile-t.
	 * @return tile - Tile.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**
	 * WardrobeTileView osztály Draw metódusa.
	 * @param graphics - Graphics típus.
	 * @return - void.
	 */
	@Override
	public void Draw(Graphics graphics) {
		super.Draw(graphics);
		
		Point center = GetCenter();
		Color wood = new Color(139, 69, 19);
		
		// Ajtók:
		graphics.setColor(wood);
		graphics.fillRect(center.x-15, center.y-20, 30, 40);
		
		graphics.fillPolygon(new int[]{center.x+6,  center.x+15, center.x+6},
	             new int[]{center.y+20, center.y+20, center.y+25}, 
	             3);
		graphics.drawPolygon(new int[]{center.x+6,  center.x+14, center.x+6},
	             new int[]{center.y+19, center.y+19, center.y+24}, 
	             3);
		
		// Beltér:
		graphics.setColor(new Color(244, 164, 96));
		graphics.fillRect(center.x-2, center.y-19, 8, 38);
		
		graphics.fillPolygon(new int[]{center.x-2,  center.x+15, center.x-2},
				             new int[]{center.y-19, center.y-19, center.y-13}, 
				             3);
		
		// Váz:
		graphics.setColor(wood);
		graphics.drawRect(center.x-15, center.y-20, 30, 39);
		graphics.drawRect(center.x-14, center.y-19, 28, 37);
		
		// Fogantyúk:
		graphics.setColor(Color.black);
		graphics.drawOval(center.x-7, center.y-1, 2, 2);
		graphics.drawOval(center.x+9, center.y+2, 1, 2);
		
	}
}
