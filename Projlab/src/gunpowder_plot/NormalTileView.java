package gunpowder_plot;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**
 * NormalTileView osztály, mely a TileView-bõl származik.
 */
public class NormalTileView extends TileView {
	/**
	 * Eltárolunk egy NormalTile-t.
	 */
	private NormalTile tile;
	
	/**
	 * NormalTileView osztály konstruktora.
	 * @param t - NormalTile.
	 * @param b - Lista, mely a pontokat tárolja.
	 */
	public NormalTileView(NormalTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**
	 * NormalTileView osztály GetTile metódusa, mely visszaadja az eltárolt Tile-t.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**
	 * NormalTileView osztály Draw függvénye.
	 * @param graphics - Graphics típus.
	 * @return - void.
	 */
	@Override
	public void Draw(Graphics graphics) {
		super.Draw(graphics);
	}
}
