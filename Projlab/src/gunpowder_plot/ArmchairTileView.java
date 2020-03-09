package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**  
 * ArmchairTileView osztály.
 * Az ArmchairTile osztályból származik.
 * Ez az osztály felelõs a fotel megjelenítéséért. 
 */
public class ArmchairTileView extends TileView {
	/**
	 * ArmchairTile tárolása.
	 */
	private ArmchairTile tile;
	
	/**
	 * ArmchairTileView konstruktora.
	 * @param t - ArmchairTile típus.
	 * @param b - Pontok listája a kirajzoláshoz.
	 */
	public ArmchairTileView(ArmchairTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**  
	 * Az ArmchairTileView osztály GetTile metódusa. Visszaadja a csempét.
	 * @param -
	 * @return Tile típus.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**  
	 * Az ArmchairTileView osztály Draw metódusa. Ez a függvény rajzolja ki az ArmchairTile-t.
	 * @param graphics - Graphics típust kap paraméterként.
	 * @return void
	 */
	@Override
	public void Draw(Graphics graphics) {
		super.Draw(graphics);
		
		// Fotel:
		Point center = GetCenter();
		
		// Lábak:
		graphics.setColor(Color.black);
		graphics.fillRect(center.x-13, center.y+5, 5, 15);
		graphics.fillRect(center.x+8,  center.y+5, 5, 15);
		graphics.drawRect(center.x-13, center.y+5, 5, 15);
		graphics.drawRect(center.x+8,  center.y+5, 5, 15);
		
		// Ülés:
		graphics.setColor(new Color(75, 0, 130));
		graphics.fillOval(center.x-15, center.y, 30, 12);
		
		graphics.setColor(Color.black);
		graphics.drawOval(center.x-15, center.y, 30, 12);
		
		// Támla:
		graphics.setColor(new Color(75, 0, 130));
		graphics.fillOval(center.x-18, center.y-20, 14, 30);
		
		graphics.setColor(Color.black);
		graphics.drawOval(center.x-18, center.y-20, 14, 30);
	}
}
