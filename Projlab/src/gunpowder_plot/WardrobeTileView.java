package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**
 * WardrobeTileView oszt�ly, mely a TileView-b�l sz�rmazik.
 */
public class WardrobeTileView extends TileView {
	/**
	 * Elt�rolunk egy NormalTile-t.
	 */
	private NormalTile tile;
	
	/**
	 * WardrobeTileView oszt�ly konstruktora.
	 * @param t - NormalTile t�pus.
	 * @param b - Pontokb�l �ll� lista.
	 */
	public WardrobeTileView(NormalTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**
	 * WardrobeTileView oszt�ly GetTile f�ggv�nye, mely visszaadja az elt�rolt Tile-t.
	 * @return tile - Tile.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**
	 * WardrobeTileView oszt�ly Draw met�dusa.
	 * @param graphics - Graphics t�pus.
	 * @return - void.
	 */
	@Override
	public void Draw(Graphics graphics) {
		super.Draw(graphics);
		
		Point center = GetCenter();
		Color wood = new Color(139, 69, 19);
		
		// Ajt�k:
		graphics.setColor(wood);
		graphics.fillRect(center.x-15, center.y-20, 30, 40);
		
		graphics.fillPolygon(new int[]{center.x+6,  center.x+15, center.x+6},
	             new int[]{center.y+20, center.y+20, center.y+25}, 
	             3);
		graphics.drawPolygon(new int[]{center.x+6,  center.x+14, center.x+6},
	             new int[]{center.y+19, center.y+19, center.y+24}, 
	             3);
		
		// Belt�r:
		graphics.setColor(new Color(244, 164, 96));
		graphics.fillRect(center.x-2, center.y-19, 8, 38);
		
		graphics.fillPolygon(new int[]{center.x-2,  center.x+15, center.x-2},
				             new int[]{center.y-19, center.y-19, center.y-13}, 
				             3);
		
		// V�z:
		graphics.setColor(wood);
		graphics.drawRect(center.x-15, center.y-20, 30, 39);
		graphics.drawRect(center.x-14, center.y-19, 28, 37);
		
		// Foganty�k:
		graphics.setColor(Color.black);
		graphics.drawOval(center.x-7, center.y-1, 2, 2);
		graphics.drawOval(center.x+9, center.y+2, 1, 2);
		
	}
}
