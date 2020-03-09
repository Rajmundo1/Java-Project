package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**
 * SlotMachineTileView osztály mely a TileView osztályból származik.
 */
public class SlotMachineTileView extends TileView {
	/**
	 * Eltároljuk a SlotMachineTile-t.
	 */
	private SlotMachineTile tile;
	
	/**
	 * SlotMachineTileView osztály konstruktora.
	 * @param t - SlotMachineTile.
	 * @param b - Pontokból álló lista.
	 */
	public SlotMachineTileView(SlotMachineTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**
	 * SlotMachineTileView osztály GetTile metódusa.
	 * @return tile - Tile típus.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**
	 * SlotMachineTileView osztály Draw metódusa.
	 * @param graphics - Graphics típus.
	 * @return - void.
	 */
	@Override
	public void Draw(Graphics graphics) {
		super.Draw(graphics);
		
		// Gépház:
		Point center = GetCenter();
		
		graphics.setColor(new Color(255, 211, 0));
		graphics.fillRect(center.x-17, center.y-20, 34, 40);
		graphics.setColor(Color.black);
		graphics.drawRect(center.x-17, center.y-20, 34, 40);
		
		// Gombok:
		for(int i = 0; i < 4; ++i) {
			graphics.setColor(Color.white);
			graphics.fillRect(center.x-12+i*7, center.y+4, 3, 3);
			graphics.setColor(Color.black);
			graphics.drawRect(center.x-12+i*7, center.y+4, 3, 3);
		}
		
		// Reel:
		graphics.setColor(Color.white);
		graphics.fillRect(center.x-8,  center.y-15, 17, 14);
		
		graphics.setColor(Color.black);
		graphics.drawRect(center.x-12, center.y-15, 24, 14);
		
		graphics.setColor(new Color(0, 0, 240));
		graphics.fillRect(center.x-8,  center.y-11, 6, 7);
		graphics.setColor(new Color(240, 0, 0));
		graphics.fillRect(center.x-3,  center.y-11, 7, 7);
		graphics.setColor(new Color(0, 200, 0));
		graphics.fillRect(center.x+3,  center.y-11, 6, 7);
		
		graphics.setColor(Color.black);
		graphics.drawRect(center.x-8,  center.y-14, 5, 12);
		graphics.drawRect(center.x-3,  center.y-14, 6, 12);
		graphics.drawRect(center.x+3,  center.y-14, 5, 12);
	}
}
