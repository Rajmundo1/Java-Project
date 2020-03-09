package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

/**
 * TileView absztakt osztály, mely megvalósítja az IDrawable interfészt.
 */
public abstract class TileView implements IDrawable {
	/**
	 * Pontokat tároló lista.
	 */
	protected List<Point> boundary;
	
	/**
	 * TileView osztály konstruktora.
	 * @param b - Pontokból álló lista.
	 */
	public TileView(List<Point> b) {
		boundary = b;
	}

	/**
	 * TileView osztály Draw metódusa, mely a paraméterként kapott objektumot kirajzolja.
	 * @param graphics - Graphics.
	 * @return - void.
	 */
	@Override
	public void Draw(Graphics graphics) {
		Draw(graphics, new Color(245, 245, 220));
	}
	
	/**
	 * TileView osztály Draw metódusa, mely a paraméterként kapott objektumot kirajzolja.
	 * @param graphics - Graphics típus, a csempét ide rajzolja.
	 * @param fill - Color típus, a csempét ilyen színnel tölti ki.
	 * @return - void.
	 */
	protected void Draw(Graphics graphics, Color fill) {
		// Boundary és kitöltése:
		Polygon poly = BoundaryAsPolygon();
		
		graphics.setColor(fill);
		graphics.fillPolygon(poly);
		
		graphics.setColor(Color.black);
		graphics.drawPolygon(poly);
	}
	
	/**
	 * TileView osztály GetCenter metódusa, mely visszaadja a TileView középpontját.
	 * @return p - Point típus.
	 */
	public Point GetCenter() {
		Point p = new Point(0, 0);
		
		for(Point point : boundary)
			p = new Point(p.x + point.x, p.y + point.y);
		
		return new Point(Math.round(p.x / (float)boundary.size()),
						 Math.round(p.y / (float)boundary.size()));
	}
	
	/**
	 * TileView osztály GetTile metódusa, mely visszaadja a tárolt Tile-t.
	 * @return Tile típus.
	 */
	abstract public Tile GetTile();
	
	/**
	 * TileView osztály IsUnder metódusa, mely visszaadja, hogy a megadott pont alatt van-e a Tile.
	 * @param point - Point típus.
	 * @return boolean típus.
	 */
	public boolean IsUnder(Point point)
	{
		return BoundaryAsPolygon().contains(point);
	}
	
	/**
	 * TileView osztály BoundaryAsPolygon metódusa, mely a csempét meghatározó pontokból poligont készít.
	 * @return Polygon típus.
	 */
	protected Polygon BoundaryAsPolygon() {
		int[] x = new int[boundary.size()];
		int[] y = new int[boundary.size()];
		int i = 0;
		for(Point p : boundary) {
			x[i] = p.x; y[i] = p.y;
			++i;
		}
		return new Polygon(x, y, boundary.size());
	}

}
