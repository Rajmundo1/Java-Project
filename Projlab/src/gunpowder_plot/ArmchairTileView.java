package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**  
 * ArmchairTileView oszt�ly.
 * Az ArmchairTile oszt�lyb�l sz�rmazik.
 * Ez az oszt�ly felel�s a fotel megjelen�t�s��rt. 
 */
public class ArmchairTileView extends TileView {
	/**
	 * ArmchairTile t�rol�sa.
	 */
	private ArmchairTile tile;
	
	/**
	 * ArmchairTileView konstruktora.
	 * @param t - ArmchairTile t�pus.
	 * @param b - Pontok list�ja a kirajzol�shoz.
	 */
	public ArmchairTileView(ArmchairTile t, List<Point> b) {
		super(b);
		tile = t;
	}
	
	/**  
	 * Az ArmchairTileView oszt�ly GetTile met�dusa. Visszaadja a csemp�t.
	 * @param -
	 * @return Tile t�pus.
	 */
	@Override
	public Tile GetTile() {
		return tile;
	}
	
	/**  
	 * Az ArmchairTileView oszt�ly Draw met�dusa. Ez a f�ggv�ny rajzolja ki az ArmchairTile-t.
	 * @param graphics - Graphics t�pust kap param�terk�nt.
	 * @return void
	 */
	@Override
	public void Draw(Graphics graphics) {
		super.Draw(graphics);
		
		// Fotel:
		Point center = GetCenter();
		
		// L�bak:
		graphics.setColor(Color.black);
		graphics.fillRect(center.x-13, center.y+5, 5, 15);
		graphics.fillRect(center.x+8,  center.y+5, 5, 15);
		graphics.drawRect(center.x-13, center.y+5, 5, 15);
		graphics.drawRect(center.x+8,  center.y+5, 5, 15);
		
		// �l�s:
		graphics.setColor(new Color(75, 0, 130));
		graphics.fillOval(center.x-15, center.y, 30, 12);
		
		graphics.setColor(Color.black);
		graphics.drawOval(center.x-15, center.y, 30, 12);
		
		// T�mla:
		graphics.setColor(new Color(75, 0, 130));
		graphics.fillOval(center.x-18, center.y-20, 14, 30);
		
		graphics.setColor(Color.black);
		graphics.drawOval(center.x-18, center.y-20, 14, 30);
	}
}
