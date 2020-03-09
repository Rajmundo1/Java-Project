package gunpowder_plot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**
 * ExitTileView oszt�ly, mely a TileView oszt�lyb�l sz�rmazik.
 */
public class ExitTileView extends TileView {
	/**
	 * Elt�roljuk az ExitTile-t.
	 */
	private ExitTile tile;
	
	/**
	 * Az ExitTileView oszt�ly konstruktora, mely a megadott param�tereknek megfelel�en l�trehoz egy ExitTileView objektumot.
	 * @param t - ExitTile t�pus.
	 * @param b - Lista mely t�rolja a kirajzol�shoz sz�ks�ges pontokat.
	 */
	public ExitTileView(ExitTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**
	 * ExitTileView oszt�ly, GetTile f�ggv�nye, mely vissza adja az ExitTile-t
	 * @return - Tile t�pus.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**
	 * ExitTileView oszt�ly Draw f�ggv�nye, mely kirajzol egy ExitTile-t.
	 * @param graphics - Graphics t�pus.
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
