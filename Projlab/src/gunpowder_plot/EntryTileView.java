package gunpowder_plot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**
 * EntryTileView oszt�ly, mely a TileView oszt�lyb�l sz�rmazik le.
 */
public class EntryTileView extends TileView {
	/**
	 * Elt�roljuk az EntryTile-t.
	 */
	private EntryTile tile;
	
	/**
	 * EntryTileView oszt�ly konstruktura, mely a megadott param�tereknek megfelel�en l�trehoz egy EntryTileView objektumot.
	 * @param t - EntryTile t�pus.
	 * @param b - Lista objektum, mely a kirajzol�shoz sz�ks�ges pontokat tartalmazza.
	 */
	public EntryTileView(EntryTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**
	 * EntryTileView oszt�ly GetTile f�ggv�nye, mely vissza adja az elt�rolt Tile-t.
	 * @param - 
	 * @return - Tile t�pus.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**
	 * EntryTileView oszt�ly Draw f�ggv�nye, mely a megadott param�ter alapj�n kirajzolja az EntryTile-t.
	 * @param graphics - Graphics t�pus.
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
