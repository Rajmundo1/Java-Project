package gunpowder_plot;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**
 * NormalTileView oszt�ly, mely a TileView-b�l sz�rmazik.
 */
public class NormalTileView extends TileView {
	/**
	 * Elt�rolunk egy NormalTile-t.
	 */
	private NormalTile tile;
	
	/**
	 * NormalTileView oszt�ly konstruktora.
	 * @param t - NormalTile.
	 * @param b - Lista, mely a pontokat t�rolja.
	 */
	public NormalTileView(NormalTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**
	 * NormalTileView oszt�ly GetTile met�dusa, mely visszaadja az elt�rolt Tile-t.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**
	 * NormalTileView oszt�ly Draw f�ggv�nye.
	 * @param graphics - Graphics t�pus.
	 * @return - void.
	 */
	@Override
	public void Draw(Graphics graphics) {
		super.Draw(graphics);
	}
}
