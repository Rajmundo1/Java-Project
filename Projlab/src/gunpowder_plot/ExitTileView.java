package gunpowder_plot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**
 * ExitTileView osztály, mely a TileView osztályból származik.
 */
public class ExitTileView extends TileView {
	/**
	 * Eltároljuk az ExitTile-t.
	 */
	private ExitTile tile;
	
	/**
	 * Az ExitTileView osztály konstruktora, mely a megadott paramétereknek megfelelõen létrehoz egy ExitTileView objektumot.
	 * @param t - ExitTile típus.
	 * @param b - Lista mely tárolja a kirajzoláshoz szükséges pontokat.
	 */
	public ExitTileView(ExitTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**
	 * ExitTileView osztály, GetTile függvénye, mely vissza adja az ExitTile-t
	 * @return - Tile típus.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**
	 * ExitTileView osztály Draw függvénye, mely kirajzol egy ExitTile-t.
	 * @param graphics - Graphics típus.
	 * @return - void
	 */
	@Override
	public void Draw(Graphics graphics) {
		Draw(graphics, Color.yellow);
		
		// EXIT sign:
		Point center = GetCenter();
		
		graphics.setColor(new Color(0, 100, 0));
		graphics.fillRect(center.x-20, center.y-8, 40, 16);
		
		graphics.setFont(new Font("Arial", Font.BOLD, 10));
		graphics.setColor(Color.white);
		graphics.drawString("E X I T", center.x-15, center.y + 4);
	}
}
