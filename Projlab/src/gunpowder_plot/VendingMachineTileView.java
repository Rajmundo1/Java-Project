package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**
 * VendingMachineTileView oszt�ly mely a TileView-b�l sz�rmazik.
 */
public class VendingMachineTileView extends TileView {
	/**
	 * Elt�rolunk egy VendingMachineTile-t.
	 */
	private VendingMachineTile tile;
	
	/**
	 * VendingMachineTileView oszt�ly konstruktora.
	 * @param t - VendingMachineTile t�pus.
	 * @param b - Pontokb�l �ll� lista.
	 */
	public VendingMachineTileView(VendingMachineTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**
	 * VendingMachineTileView oszt�ly GetTile f�ggv�nye, mely visszaadja az elt�rolt VendingMachineTile-t.
	 * @return tile - Tile t�pus.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**
	 * VendingMachineTileView oszt�ly Draw met�dusa.
	 * @param graphics - Graphics t�pus.
	 * @return - void.
	 */
	@Override
	public void Draw(Graphics graphics) {
		super.Draw(graphics);
		
		// G�ph�z:
		Point center = GetCenter();
		
		graphics.setColor(new Color(89, 190, 89));
		graphics.fillRect(center.x-17, center.y-20, 34, 40);
		graphics.setColor(Color.black);
		graphics.drawRect(center.x-17, center.y-20, 34, 40);
		
		// Kiad�:
		graphics.setColor(Color.black);
		graphics.fillRect(center.x-8, center.y+11, 16, 5);
		graphics.drawRect(center.x-8, center.y+11, 16, 5);
		
		// �rut�r:
		graphics.setColor(new Color(54, 115, 115));
		graphics.fillRect(center.x-12, center.y-17, 24, 24);
		graphics.setColor(Color.black);
		graphics.drawRect(center.x-12, center.y-17, 24, 24);
		
		// Polcok:
		graphics.setColor(Color.black);
		graphics.drawLine(center.x-11, center.y-9, center.x+11, center.y-9);
		graphics.drawLine(center.x-11, center.y-1, center.x+11, center.y-1);
		
		// Csokik:
		for(int x = 0; x < 3; ++x) {
			for(int y = 0; y < 3; ++y) {
				graphics.setColor(new Color(
						((y == 1) ? 230 : 0),
						((y == 2) ? 230 : 0),
						((y == 0) ? 255 : 0)));
				graphics.fillRect(center.x-9+x*7, center.y-15+y*8, 4, 5);
				graphics.setColor(Color.black);
				graphics.drawRect(center.x-9+x*7, center.y-15+y*8, 4, 5);
			}
		}
		
	}
}
