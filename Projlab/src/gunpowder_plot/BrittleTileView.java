package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**  
 * BrittleTileView oszt�ly, mely a TileView oszt�lyb�l sz�rmazik le.
 */
public class BrittleTileView extends TileView {
	/**
	 * Elt�roljuk a BrittleTile-t.
	 */
	private BrittleTile tile;
	
	/**  
	 * A BrittleTileView oszt�ly konstruktora. L�trehoz a megadott param�tereknek megfelel�en egy BrittleTileView-t.
	 * @param t - BrittleTile t�pus.
	 * @param b - Lista t�pus mely t�rolja a rajzol�shoz sz�ks�ges pontokat.
	 */
	public BrittleTileView(BrittleTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**  
	 * A BrittleTileView oszt�ly GetTile f�ggv�nye, mely vissza adja a csemp�t.
	 * @param - 
	 * @return - Tile t�pus.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**  
	 * A BrittleTileView oszt�ly Draw f�ggv�nye, mely a BrittleTile kirajzol�s��rt felel�s.
	 * @param graphics - Graphics t�pus.
	 * @return void
	 */
	@Override
	public void Draw(Graphics graphics) {
		int health = tile.GetHealth();
		int tone = 10*health;
		
		Draw(graphics, new Color(tone, tone, tone));
	}
}
