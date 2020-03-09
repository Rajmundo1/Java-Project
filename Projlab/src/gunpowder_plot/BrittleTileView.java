package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**  
 * BrittleTileView osztály, mely a TileView osztályból származik le.
 */
public class BrittleTileView extends TileView {
	/**
	 * Eltároljuk a BrittleTile-t.
	 */
	private BrittleTile tile;
	
	/**  
	 * A BrittleTileView osztály konstruktora. Létrehoz a megadott paramétereknek megfelelõen egy BrittleTileView-t.
	 * @param t - BrittleTile típus.
	 * @param b - Lista típus mely tárolja a rajzoláshoz szükséges pontokat.
	 */
	public BrittleTileView(BrittleTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**  
	 * A BrittleTileView osztály GetTile függvénye, mely vissza adja a csempét.
	 * @param - 
	 * @return - Tile típus.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**  
	 * A BrittleTileView osztály Draw függvénye, mely a BrittleTile kirajzolásáért felelõs.
	 * @param graphics - Graphics típus.
	 * @return void
	 */
	@Override
	public void Draw(Graphics graphics) {
		int health = tile.GetHealth();
		int tone = 10*health;
		
		Draw(graphics, new Color(tone, tone, tone));
	}
}
