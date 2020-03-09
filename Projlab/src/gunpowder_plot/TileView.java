package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

/**
 * TileView absztakt oszt�ly, mely megval�s�tja az IDrawable interf�szt.
 */
public abstract class TileView implements IDrawable {
	/**
	 * Pontokat t�rol� lista.
	 */
	protected List<Point> boundary;
	
	/**
	 * TileView oszt�ly konstruktora.
	 * @param b - Pontokb�l �ll� lista.
	 */
	public TileView(List<Point> b) {
		boundary = b;
	}

	/**
	 * TileView oszt�ly Draw met�dusa, mely a param�terk�nt kapott objektumot kirajzolja.
	 * @param graphics - Graphics.
	 * @return - void.
	 */
	@Override
	public void Draw(Graphics graphics) {
		Draw(graphics, new Color(245, 245, 220));
	}
	
	/**
	 * TileView oszt�ly Draw met�dusa, mely a param�terk�nt kapott objektumot kirajzolja.
	 * @param graphics - Graphics t�pus, a csemp�t ide rajzolja.
	 * @param fill - Color t�pus, a csemp�t ilyen sz�nnel t�lti ki.
	 * @return - void.
	 */
	protected void Draw(Graphics graphics, Color fill) {
		// Boundary �s kit�lt�se:
		Polygon poly = BoundaryAsPolygon();
		
		graphics.setColor(fill);
		graphics.fillPolygon(poly);
		
		graphics.setColor(Color.black);
		graphics.drawPolygon(poly);
	}
	
	/**
	 * TileView oszt�ly GetCenter met�dusa, mely visszaadja a TileView k�z�ppontj�t.
	 * @return p - Point t�pus.
	 */
	public Point GetCenter() {
		Point p = new Point(0, 0);
		
		for(Point point : boundary)
			p = new Point(p.x + point.x, p.y + point.y);
		
		return new Point(Math.round(p.x / (float)boundary.size()),
						 Math.round(p.y / (float)boundary.size()));
	}
	
	/**
	 * TileView oszt�ly GetTile met�dusa, mely visszaadja a t�rolt Tile-t.
	 * @return Tile t�pus.
	 */
	abstract public Tile GetTile();
	
	/**
	 * TileView oszt�ly IsUnder met�dusa, mely visszaadja, hogy a megadott pont alatt van-e a Tile.
	 * @param point - Point t�pus.
	 * @return boolean t�pus.
	 */
	public boolean IsUnder(Point point)
	{
		return BoundaryAsPolygon().contains(point);
	}
	
	/**
	 * TileView oszt�ly BoundaryAsPolygon met�dusa, mely a csemp�t meghat�roz� pontokb�l poligont k�sz�t.
	 * @return Polygon t�pus.
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
